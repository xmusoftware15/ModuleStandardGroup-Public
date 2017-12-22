package xmu.crms.service;

import java.math.BigInteger;
import java.util.List;

import xmu.crms.entity.FixGroup;
import xmu.crms.entity.FixGroupMember;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.User;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.FixGroupNotFoundException;
import xmu.crms.exception.InvalidOperationException;
import xmu.crms.exception.UserNotFoundException;

/**
 * 
 * @author ZhouChulun YeHongjie Heqi Aixing
 * @version 2.10
 *
 */
public interface FixGroupService {
	
	
	/**
     * 按班级Id添加固定分组.
     * <p>按ClassId删除FixGroupMember<br>
     * @author zhouzhongjun
     * @param classId 固定分组Id
     * @param userId 队长的Id
     * @return BigInteger 若创建成功返回该条记录的id，失败则返回-1
     * @exception IllegalArgumentException 信息不合法，id格式错误 
     * @exception classNotFoundException 未找到班级
     * @exception UserNotFoundException 不存在该学生
	 */
	public BigInteger insertFixGroupByClassId(BigInteger classId,BigInteger userId) throws
	IllegalArgumentException,classNotFoundException,UserNotFoundException;
	
	/**
     * 按FixGroupId删除FixGroupMember.
     * <p>按FixGroupId删除FixGroupMember<br>
     * @author zhouzhongjun
     * @param fixGroupId 固定分组Id
     * @exception IllegalArgumentException 信息不合法，id格式错误 
     * @exception FixGroupNotFoundException 未找到小组
	 */
    public void deleteFixGroupMemberByFixGroupId(BigInteger fixGroupId) throws
    IllegalArgumentException,FixGroupNotFoundException;
    
    /**
     * 按FixGroupId和UserId删除FixGroupMember中某个学生.
     * <p>按FixGroupId和UserId删除FixGroupMember中的某个学生<br>
     * @author zhouzhongjun
     * @param fixGroupId 固定分组Id
     * @param userId 组员的Id
     * @exception IllegalArgumentException 信息不合法，id格式错误 
     * @exception FixGroupNotFoundException 未找到小组
     * @exception UserNotFoundException 不存在该学生
	 */
    public void deleteFixGroupUserById(BigInteger fixGroupId, BigInteger userId) throws
    IllegalArgumentException,FixGroupNotFoundException,UserNotFoundException;
	
    /**
     * 将学生加入固定小组.
     * ＜p＞将用户加入指定的固定小组<br>
     * @author YeHongjie
     * @param userId 学生的id
     * @param groupId 要加入固定小组的id
     * @return BigInteger 若创建成功返回该条记录的id，失败则返回-1
     * @exception IllegalArgumentException 信息不合法，id格式错误
     * @exception FixGroupNotFoundException 未找到小组
     * @exception UserNotFoundException 不存在该学生
     * @exception InvalidOperationException 待添加学生已经在小组里了
	 */
    public BigInteger insertFixGroupMemberById(BigInteger userId,BigInteger groupId)throws 
    IllegalArgumentException,FixGroupNotFoundException,UserNotFoundException,InvalidOperationException;
    
    /**
	 * 查询固定小组成员.
	 * ＜p＞按照固定小组id查询该小组的成员<br>
	 * @author YeHongjie
	 * @param groupId 要查询的固定小组id
	 * @return List 固定小组成员信息
	 * @exception IllegalArgumentException 信息不合法，id格式错误
     * @exception FixGroupNotFoundException 未找到小组
	 */
    public List<User> listFixGroupMemberByGroupId(BigInteger groupId)throws 
    IllegalArgumentException,FixGroupNotFoundException;
    
    /**
	 * 按classId查找FixGroup信息.
	 * <p>按classId查找FixGroup信息<br>
	 * @author zhouzhongjun
     * @param classId 班级Id
     * @return List 固定分组列表
     * @exception IllegalArgumentException 信息不合法，id格式错误
     * @exception classNotFoundException 未找到班级
	 */
	public List<FixGroup> listFixGroupByClassId(BigInteger classId)throws
	IllegalArgumentException,classNotFoundException;
	
	/**
	 * 按classId删除FixGroup
	 * <p>先根据classId得到所有的FixGroup信息，再根据FixGroupid删除FixGroupMember表的信息，最后再将FixGroup信息删除<br>*  
	 * @author zhouzhongjun
     * @param classId 班级Id
     * @see FixGroupService #listFixGroupByClassId(BigInteger classId)
     * @see FixGroupService #deleteFixGroupMemberByFixGroupId(BigInteger fixGroupId)
     * @exception IllegalArgumentException 信息不合法，id格式错误 
     * @exception classNotFoundException 未找到班级
	 */
	public void deleteFixGroupByClassId(BigInteger classId)throws 
	IllegalArgumentException,classNotFoundException;
    
	/**
	 * 删除固定小组.
	 * ＜p＞按照id删除固定小组<br>
	 * @author YeHongjie
	 * @param groupId 固定小组的id
	 * @see FixGroupService #deleteFixGroupMemberByFixGroupId(BigInteger fixGroupId)
	 * @exception IllegalArgumentException  信息不合法，id格式错误
	 * @exception FixGroupNotFoundException 未找到小组
	 */
    public void deleteFixGroupByGroupId(BigInteger groupId)throws
    IllegalArgumentException,FixGroupNotFoundException;
    
    /**
	 * 修改固定小组.
	 * ＜p＞修改固定小组的信息（不包括成员）<br>
	 * @author YeHongjie
	 * @param groupId 小组的id
	 * @param fixGroupBO 小组信息
	 * @exception IllegalArgumentException 信息不合法，id格式错误
	 * @exception FixGroupNotFoundException 未找到小组
	 */
    public void updateFixGroupByGroupId(BigInteger groupId,FixGroup fixGroupBO)throws
    IllegalArgumentException,FixGroupNotFoundException;
    
    /**
	 * 查询固定小组.
	 * ＜p＞按照id查询某一固定小组的信息（包括成员）<br>
	 * @author YeHongjie
	 * @param groupId 小组的id
	 * @return List 固定小组成员列表对象，若未找到相关成员返回空(null)
	 * @see FixGroupService #listFixGroupMemberByGroupId(BigInteger groupId)
	 * @exception IllegalArgumentException  信息不合法，id格式错误
	 * @exception FixGroupMemberNotFoundException 未找到小组成员
	 */
    public List<FixGroupMember> listFixGroupByGroupId(BigInteger groupId)throws
    IllegalArgumentException,FixGroupNotFoundException;
    

 

	/**
	 * 将学生加入小组.
	 * ＜p＞将用户加入指定的小组<br>
	 * @author YeHongjie
	 * @param userId 学生的id
	 * @param groupId 要加入小组的id
	 * @return BigInteger 若创建成功返回该条记录的id，失败则返回-1
	 * @exception IllegalArgumentException 信息不合法，id格式错误
	 * @exception FixGroupNotFoundException 未找到小组
	 * @exception UserNotFoundException 不存在该学生
	 * @exception InvalidOperationException 待添加学生已经在小组里了
	 */

    public BigInteger insertStudentIntoGroup(BigInteger userId,BigInteger groupId) throws 
    IllegalArgumentException,FixGroupNotFoundException,UserNotFoundException,
            InvalidOperationException;

	 /**
		 * 按id获取小组.
		 * <p>通过学生id和班级id获取学生所在的班级固定小组<br>
		 * @author heqi
		 * @param userId 学生id
		 * @param classId 班级id
		 * @return FixGroup 返回班级固定小组的信息 
		 * @see UserService#getUserByUserId(BigInteger UserId)
		 * @exception IllegalArgumentException  信息不合法，id格式错误
		 * @exception classNotFoundException 未找到小组
		 * @exception UserNotFoundException 不存在该学生
		 */
		public FixGroup getFixedGroupById(BigInteger userId,BigInteger classId)throws
		IllegalArgumentException,classNotFoundException,UserNotFoundException;

		/**
	     * 根据groupId修改group.
	     * <p>根据groupId修改group<br>
	     * @author aixing
	     * @param groupId 要修改的group的Id
	     * @param group 新的group信息
	     * @exception IllegalArgumentException  信息不合法，id格式错误
		 * @exception FixGroupNotFoundException 未找到小组
	     */
	    public void updateSeminarGroupById(BigInteger groupId,SeminarGroup group)throws
	    IllegalArgumentException,FixGroupNotFoundException;
	
	/**
	 * 将固定小组作为讨论课小组名单.
	 * @author qinlingyun
	 * @param semianrId 讨论课ID
	 * @param fixedGroupId 小组ID
	 * @exception IllegalArgumentException  信息不合法，id格式错误
	 * @exception FixGroupNotFoundException 未找到小组
	 * @exception SeminarNotFoundException 未找到讨论课
	 */
	 void fixedGroupToSeminarGroup(BigInteger semianrId, BigInteger fixedGroupId) throws 
	 IllegalArgumentException,FixGroupNotFoundException,SeminarNotFoundException;

}
