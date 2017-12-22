package xmu.crms.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时器
 * 
 * @author qinlingyun liuaiqi
 * @version 2.10
 */
public class TimerService {

    private ApplicationContext applicationContext;
    private List<Method> eventCallbacks;
    public TimerService(@Autowired final ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
        Object[] beans = Arrays.stream(applicationContext.getBeanDefinitionNames()).map(applicationContext::getBean).toArray();
        Class<?>[] beanTypes = Arrays.stream(beans).map(Object::getClass).distinct().toArray(Class<?>[]::new);
        eventCallbacks = Arrays.stream(beanTypes)
                                     .flatMap(clz -> Arrays.stream(clz.getDeclaredMethods()))
                                     .filter(method -> method.getDeclaredAnnotation(CrmsEvent.class) != null)
                                     .collect(Collectors.toList());
    }
	/**
	 * 每十分钟检查一次Event实体的状况
	 * @author qinlingyun
	 */
	@Scheduled(fixedRate = 1000 * 60 * 5)
	 void scheduled(){
        for (Method callback : eventCallbacks) {
            CrmsEvent event = callback.getDeclaredAnnotation(CrmsEvent.class);
            String table = event.table();
            String timeColumn = event.timeColumn();
            String[] whereColumns = event.whereColumns();
            String[] paramColumns = event.whereColumns();
            List<Object[]> realParams = new ArrayList<>();// select paramColumns from table where timeColumn < NOW() + INTERVAL 5 MINUTE AND timeColumn > NOW() AND whereColumns
            for (Object[] realParam : realParams) {
                try {
                    callback.invoke(applicationContext.getBean(callback.getDeclaringClass()), realParam);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
		
}
