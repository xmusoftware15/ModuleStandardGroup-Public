package xmu.crms.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;

/**
 * 定时器
 * 
 * @author qinlingyun liuaiqi
 * @version 2.10
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
	 * 更新Event表.
	 * @author qinlingyun
	 * @param time 事件的时间
	 * @param beanName 对象名
	 * @param methodName 方法名
	 * @param paramMap 方法参数
	 */	 
	 void updateEvent(Date time, String beanName, String methodName, HashMap<BigInteger, String> paramMap);

	 
	/**
	 * 每十分钟检查一次Event实体的状况
	 * @author qinlingyun
	 */
	 void scheduled();
		
}
