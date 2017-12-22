package xmu.crms.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import xmu.crms.entity.Event;

/**
 * 定时器
 * 
 * @author qinlingyun liuaiqi
 * @version 2.10
 */

public class TimerService {

    /**
     * 向Event表插入数据.
     * @author qinlingyun
     * @param time 事件的时间
     * @param beanName 方法名称
     * @param paramMap 方法参数
     */
    void insertEvent(Date time, String beanName, String methodName, HashMap<BigInteger, String> paramMap){
        Event e = new Event(time, beanName, methodName, paramMap);
        //Insert entity to db
    }

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

        //select * from event where time < NOW()
        List<Event> events = new ArrayList<>();
        for (Event event : events) {
            try {
                Object bean = applicationContext.getBean(event.getBeanName());
                Method callback = BeanUtils.findMethod(bean.getClass(), event.getMethodName());
                callback.invoke(applicationContext.getBean(event.getBeanName()), event.getMap().values().toArray());
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();

            }
            //delete from event where id = event.id
        }
    }
		
}
