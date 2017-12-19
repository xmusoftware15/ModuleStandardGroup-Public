package xmu.crms.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器
 * 
 * @author qinlingyun liuaiqi
 * @version 2.00
 */
@Component
public interface TimeService {

		/**
		 * 讨论课结束后计算展示得分.
		 * <p>每天8点到21点 每四十分钟触发一次<br>
		 * <p>条件: 讨论课已结束<br>
		 * @author qinlingyun
		 */
		@Scheduled(cron = "0 0/40 8-21 ? * *")
		public void countPresentationGrade();
		
		/**
		 * 课前将固定小组复制一份作为讨论课小组名单.
		 * <p>每天7点到21点 每半小时触发一次<br>
		 * <p>条件: 讨论课上课前<br>
		 * @author qinlingyun
		 */
		@Scheduled(cron = "0 0/30 7-21 ? * *")
		public void fixedGroupToSeminarGroup();
}
