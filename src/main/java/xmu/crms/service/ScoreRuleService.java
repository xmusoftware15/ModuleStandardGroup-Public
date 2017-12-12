package xmu.crms.service;

import java.math.BigInteger;

import xmu.crms.bo.ProportionsBO;

/**
 * 
 * @author ModuleStandardGroup
 * @version 1.00
 *
 */

public class ScoreRuleService {



		/**
		 * 按classId和CourseId删除ScoreRule.
		 * @author zhouzhongjun
		 * @param courseId 班级Id
	     * @param classId 班级Id
	     * @return true删除成功 false删除失败
		 */
		boolean deleteScoreRuleById(BigInteger courseId,BigInteger classId) {
			
			//删除自己
			return true;
		};
		
		/**
		 * 新增评分规则.
		 * <p>新增评分规则<br>  
		 * @author YeHongjie
	     * @param proportionsBO 评分规则
	     * @return scoreRuleId 若创建成功则返回该评分规则的id，失败则返回-1
		 */
		BigInteger insertScoreRule(ProportionsBO proportionsBO)
		{
			BigInteger scoreRuleId=BigInteger.valueOf(-1);
			return scoreRuleId;
		}
		
		/**
		 * 修改评分规则.
		 * <p>修改指定的评分规则<br>  
		 * @author YeHongjie
		 * @param proportionId 评分规则id
	     * @param proportionsBO 评分规则
	     * @return state 若修改成功则返回true，失败则返回false
		 */
		Boolean updateScoreRule(BigInteger proportionId, ProportionsBO proportionsBO)
		{
			Boolean state=Boolean.valueOf(false);
			return state;
		}
		
		/**
		 * 删除评分规则.
		 * <p>删除指定的评分规则<br>  
		 * @author YeHongjie
		 * @param proportionId 评分规则id
	     * @return Boolean 若删除成功则返回true，失败则返回false
		 */
		Boolean deleteScoreRule(BigInteger proportionId)
		{
			Boolean state=Boolean.valueOf(false);
			return state;
		}
		
		/**
		 * 查询评分规则.
		 * <p>按id查询指定的评分规则<br>  
		 * @author YeHongjie
		 * @param proportionId 评分规则id
	     * @return ProportionBO 返回评分规则，若未找到对应评分规则返回空（null)
		 */
		ProportionsBO getScoreRule(BigInteger proportionId)
		{
			ProportionsBO proportionsBO=null;
			return proportionsBO;
		}
}
