package xmu.crms.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;

import org.springframework.scheduling.annotation.Scheduled;

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
	 * 更新Event表.
	 * @author qinlingyun
	 * @param eventId 事件的ID
	 * @param newTime 需要修改的时间
	 */	 
	 void updateEvent(BigInteger eventId, Date newTime);

	 
	/**
	 * 每十分钟检查一次Event实体的状况
	 * @author qinlingyun
	 */
	 @Scheduled(fixedRate = 1000*60*10)
	 void scheduled();
		
}
