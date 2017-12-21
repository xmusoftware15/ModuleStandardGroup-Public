package xmu.crms.service;

import java.util.Date;
import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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
	 * @param beanName 方法名称
	 * @param paramMap 方法参数
	 */
	 void insertEvent(Date time, Bean beanName, HashMap<Integer, String> paramMap);

	/**
	 * 每十分钟检查一次Event实体的状况
	 * @author qinlingyun
	 */
	 void scheduled();
		
}
