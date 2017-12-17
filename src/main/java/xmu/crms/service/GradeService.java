package xmu.crms.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Huhui QinLingyun ZhouZhongjun
 * @version 2.00
 *
 */
public interface GradeService {

	/**
	 * 按topicId删除学生打分表.
	 * @author zhouzhongjun
     * @param topicId 话题Id
     *  @return true删除成功  false删除失败
	 */
	 Boolean deleteStudentScoreGroupByTopicId(BigInteger topicId);
	/**
	 * 获取某学生所有讨论课的成绩.
	 * <p>获取某学生所有讨论课的成绩<br>
	 * @author qinlingyun
	 * @param userId 学生id
	 * @param seminarGroupId 讨论课小组id
	 * @return list 讨论课分数列表
	 * @see SeminarGroupService#listSeminarGroupIdByStudentId(BigInteger userId)
	 */
    List<BigInteger> listSeminarGradeBySeminarGroupId(BigInteger userId, BigInteger seminarGroupId);
    
	/**
	 * 提交对其他小组的打分.
	 * 
	 * @author Huhui
	 * @param userId 用户id
	 * @param seminarId 讨论课Id
	 * @param groupId 小组Id
	 * @param grade 分数
	 * @return true 提交成功 false 提交失败
	 */
	 Boolean insertGroupGradeByUserId(BigInteger userId,BigInteger seminarId,BigInteger groupId,BigInteger grade) ;

	/**
	 * 按ID设置小组报告分.
	 * 
	 * @author Huhui
	 * @param seminar_group_id 讨论课组id
	 * @param grade 分数
	 * @return Boolean true 操作成功 false 操作失败
	 */
	 Boolean updateGroupByGroupId(BigInteger seminar_group_id, BigInteger grade) ;
	
	/**
	 * 获取某学生的讨论课成绩列表.
	 * @author qinlingyun
	 * @param userId 用户id
	 * @return list 讨论课成绩列表
	 * @see SeminarGroupService#listSeminarGroupBySeminarId(BigInteger seminarId)
	 */
	 List<BigInteger> listSeminarGradeByStudentId(BigInteger userId);
	
}
