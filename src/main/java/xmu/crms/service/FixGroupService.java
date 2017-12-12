package xmu.crms.service;

import java.math.BigInteger;
import java.util.List;

import xmu.crms.bo.*;

/**
 * 
 * @author ModuleStandardGroup
 * @version 1.00
 *
 */

public class FixGroupService {
	/**
	 * 按FixGroupId删除FixGroupMember.
	 * @author zhouzhongjun
     * @param fixGroupId 固定分组Id
     * @return true删除成功  false删除失败
	 */
	boolean deleteFixGroupMemberByFixGroupId(BigInteger fixGroupId) {
		
		//删除自己
		return true;
	};
	
	/**
	 * 将学生加入固定小组.
	 * ＜p＞将用户加入指定的固定小组<br>*
	 * @author YeHongjie
	 * @param userId 学生的id
	 * @param groupId 要加入固定小组的id
	 * @return BigInteger 若创建成功返回该条记录的id，失败则返回-1
	 */
    BigInteger insertFixGroupMemberById(BigInteger userId,BigInteger groupId)
    {
    	BigInteger recordId = BigInteger.valueOf(-1);
    	return recordId;
    }
    
	/**
	 * 查询固定小组成员.
	 * ＜p＞按照固定小组id查询该小组的成员<br>*
	 * @author YeHongjie
	 * @param groupId 要查询的固定小组id
	 * @return List 固定小组成员信息
	 */
    List<UserBO> listFixGroupMemberByGroupId(BigInteger groupId)
    {
    	List<UserBO> userBOs=null;
    	return userBOs;
    }
	/**
	 * 按classId查找FixGroup信息.
	 * @author zhouzhongjun
     * @param classId 班级Id
     * @return null 固定分组列表
	 */
	List<FixGroupBO> listFixGroupByClassId(BigInteger classId) {
		
		return null;
	};
	
	/**
	 * 按classId删除FixGroup
	 * <p>先根据classId得到所有的FixGroup信息，再根据FixGroupid删除FixGroupMember表的信息，最后再将FixGroup信息删除<br>  
	 * @author zhouzhongjun
     * @param classId 班级Id
     * @see FixGroupService #listFixGroupByClassId(BigInteger classId)
     * @see FixGroupService #deleteFixGroupMemberByFixGroupId(BigInteger fixGroupId)
     * @return true删除成功  false删除失败
	 */
	boolean deleteFixGroupByClassId(BigInteger classId) {
		
		//删除自己
		return true;
	};
    
    /**
	 * 创建固定小组.
	 * ＜p＞在指定班级下创建固定小组<br>*
	 * @author YeHongjie
	 * @param classId 班级的id
	 * @param fixGroupBO 小组信息
	 * @return BigInteger 若创建成功返回该小组的id，失败则返回-1
	 */
    BigInteger insertFixGroupByClassId(BigInteger classId,FixGroupBO fixGroupBO)
    {
    	BigInteger fixGroupId = BigInteger.valueOf(-1);
    	return fixGroupId;
    }
    
    /**
	 * 删除固定小组.
	 * ＜p＞按照id删除固定小组<br>*
	 * @author YeHongjie
	 * @param groupId 固定小组的id
	 * @return state 若创建成功返回true，失败返回false
	 * @see FixGroupService #deleteFixGroupMemberByFixGroupId(BigInteger fixGroupId)
	 */
    Boolean deleteFixGroupByGroupId(BigInteger groupId)
    {
    	Boolean state=Boolean.valueOf(false);
    	return state;
    }
    
    /**
	 * 修改固定小组.
	 * ＜p＞修改固定小组的信息（不包括成员）<br>*
	 * @author YeHongjie
	 * @param groupId 小组的id
	 * @param fixGroupBO 小组信息
	 * @return Boolean 若创建成功返回true，失败返回false
	 */
    Boolean updateFixGroupByGroupId(BigInteger groupId,FixGroupBO fixGroupBO)
    {
    	Boolean state=Boolean.valueOf(false);
    	return state;
    }
    
    /**
	 * 查询固定小组.
	 * ＜p＞按照id查询某一固定小组的信息（包括成员）<br>*
	 * @author YeHongjie
	 * @param groupId 小组的id
	 * @return fixGroupBO 固定小组对象，若未找到相关小组返回空(null)
	 * @see FixGroupService #listFixGroupMemberByGroupId(BigInteger groupId)
	 */
    FixGroupBO getFixGroupByGroupId(BigInteger groupId)
    {
    	FixGroupBO fixGroupBO=null;
    	return fixGroupBO;
    }
 

    /**
	 * 将学生加入小组.
	 * ＜p＞将用户加入指定的小组<br>*
	 * @author YeHongjie
	 * @param userId 学生的id
	 * @param groupId 要加入小组的id
	 * @return BigInteger 若创建成功返回该条记录的id，失败则返回-1
	 */
    BigInteger insertStudnetIntoGroup(BigInteger userId,BigInteger groupId)
    {
    	BigInteger recordId = BigInteger.valueOf(-1);
    	return recordId;
    }

    /**
	 * 小组取消话题.
	 * <p>小组按小组id取消讨论课的话题的选择<br>
	 * @author heqi
	 * @param groupId 小组id
	 * @return true or false 返回取消话题是否成功
	 */
	private boolean deleteTopicByGroupId(BigInteger groupId) {
		//TopicDao.deleteTopicByGroupId(BigInteger groupId)
		return true;
	}

    /**
	 * 按id获取小组.
	 * <p>通过学生id和班级id获取学生所在的班级固定小组<br>
	 * @author heqi
	 * @param userId 学生id
	 * @param classId 班级id
	 * @return GroupBO 返回班级固定小组的信息 
	 * @see UserService#getUserByUserId(BigInteger UserId)
	 */
	private GroupBO getFixedGroupById(BigInteger userId,BigInteger classId){
		//rs = UserService.listMembersById(BigInteger userId);
		//for student_id in rs;
		//UserService.UserBO getUserByUserId(BigInteger UserId)
		//得到小组所有成员信息返回小组信息
		GroupBO groupBO = new GroupBO();
		return groupBO;
	}

        /**
	 * 小组按id选择话题.
	 * <p>小组通过小组id和话题id选择讨论课的话题<br>
	 * @author heqi
	 * @param groupId 小组id
	 * @param topicId 话题id
	 * @return String 返回一个url
	 */
	private String insertTopicByGroupId(BigInteger groupId, BigInteger topicId){
		//TopicDao.insertTopicByGroupId(BigInteger groupId, BigInteger topicId)
		String url = null;
		return url;
	}

        /**
	 * 将学生加入小组.
	 * ＜p＞将用户加入指定的小组<br>*
	 * @author YeHongjie
	 * @param userId 学生的id
	 * @param groupId 要加入小组的id
	 * @return BigInteger 若创建成功返回该条记录的id，失败则返回-1
	 */
    BigInteger insertStudnetIntoGroup(BigInteger userId,BigInteger groupId)
    {
    	BigInteger recordId = BigInteger.valueOf(-1);
    	return recordId;
    }

    /**
     * 根据groupId修改group.
     * <p>根据groupId修改group<br>
     * @author aixing
     * @param groupId 要修改的group的Id
     * @param group 新的group信息
     * @return
     */
    BigInteger updateSeminarGroupById(BigInteger groupId,GroupBO group){
        BigInteger bi=null;
        //修改此group
        return bi;
    }
}
