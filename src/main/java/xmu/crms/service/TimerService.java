package xmu.crms.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;

/**
 * 定时器
 * 
 * @author qinlingyun liuaiqi
 * @version 2.20
 */
public interface TimerService {

	/**
	 * 向Event表插入数据.
	 * @author qinlingyun
	 * @param time 事件的时间
	 * @param beanName 对象名
	 * @param methodName 方法名
	 * @param paramMap 方法参数
	 */
	 void insertEvent(Date time, String beanName, String methodName, HashMap<BigInteger, String> paramMap);
	 
		 
	/**
	 * 如果用hashMap实现不了 ，可以参考赖神提供的意见使用List<Object>：
	 */ 
	 //void insertEvent(Date time, String beanName, String methodName, List<Object> paramList);
	 
		 
	 
	/**
	 * 更新Event表.
	 * @author qinlingyun
	 * @param eventId 事件的ID
	 * @param newTime 需要修改的时间
	 */	 
	 void updateEvent(BigInteger eventId, Date newTime);

	 
	/**
	 * 每十分钟检查一次Event实体的状况
	 * @author qinlingyun
	 * 注解：@Scheduled(fixedRate = 1000*60*10)
	 */
	 void scheduled();
	 
	 
	 
/**
 * 题外话：.
 * 不使用event表，下面是赖神的方法，有需要自取：
 * 自定义注解：
+@Target({ElementType.METHOD}) 
+@Retention(RetentionPolicy.RUNTIME) 
+@Documented 
+public @interface CrmsEvent { 
+    String table(); 
+    String timeColumn(); 
+    String[] whereColumns() default {};
+    String[] paramColumns(); 
+} 这个注解放在定时器方法上，注解的参数可以自己根据合适的来定义

timerService:
+    void insertEvent(Date time, String beanName, String methodName, HashMap<BigInteger, String> paramMap){ 
+        Event e = new Event(time, beanName, methodName, paramMap); 
+        //Insert entity to db  
+    } 

+    private ApplicationContext applicationContext; 
+    private List<Method> eventCallbacks; 
+    public TimerService(@Autowired final ApplicationContext applicationContext){ 
+        this.applicationContext = applicationContext; 
+        Object[] beans = Arrays.stream(applicationContext.getBeanDefinitionNames()).map(applicationContext::getBean).toArray(); 
+        Class<?>[] beanTypes = Arrays.stream(beans).map(Object::getClass).distinct().toArray(Class<?>[]::new); 
+        eventCallbacks = Arrays.stream(beanTypes) 
+                                     .flatMap(clz -> Arrays.stream(clz.getDeclaredMethods())) 
+                                     .filter(method -> method.getDeclaredAnnotation(CrmsEvent.class) != null) 
+                                     .collect(Collectors.toList()); 
+    }

+	@Scheduled(fixedRate = 1000 * 60 * 5) 
+	 void scheduled(){ 
+        for (Method callback : eventCallbacks) { 
+            CrmsEvent event = callback.getDeclaredAnnotation(CrmsEvent.class); 
+            String table = event.table(); 
+            String timeColumn = event.timeColumn(); 
+            String[] whereColumns = event.whereColumns(); 
+            String[] paramColumns = event.whereColumns(); 
+            List<Object[]> realParams = new ArrayList<>();// select paramColumns from table where timeColumn < NOW() + INTERVAL 5 MINUTE AND timeColumn > NOW() AND whereColumns 
+            for (Object[] realParam : realParams) { 
+                try {
+                    callback.invoke(applicationContext.getBean(callback.getDeclaringClass()), realParam); 
+                } catch (IllegalAccessException | InvocationTargetException e) { 
+                    e.printStackTrace(); 
+                } 
+            }
+        } 
+ 
+        //select * from event where time < NOW() 
+        List<Event> events = new ArrayList<>(); 
+        for (Event event : events) { 
+            try { 
+                Object bean = applicationContext.getBean(event.getBeanName()); 
+                Method callback = BeanUtils.findMethod(bean.getClass(), event.getMethodName()); 
+                callback.invoke(bean, event.getMap().values().toArray()); 
+            } catch (IllegalAccessException | InvocationTargetException e) { 
+                e.printStackTrace(); 
+ 
+            } 
+            //delete from event where id = event.id 
+        } 
+    }
 *
 */
	 
		
}
