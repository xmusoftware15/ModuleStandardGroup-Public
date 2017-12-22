package xmu.crms.service;

import java.math.BigInteger;
import java.util.List;

import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.SeminarGroupMember;
import xmu.crms.entity.User;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.GroupNotFoundException;
import xmu.crms.exception.InvalidOperationException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.exception.UserNotFoundException;


/**
 * @author zhouzhongjun
 * @version 2.10
 */
public interface SeminarGroupService {

    /**
     * 按seminarGroupId删除SeminarGroupMember信息.
     * <p>按seminarGroupId删除SeminarGroupMember信息<br>
     *
     * @param seminarGroupId 讨论课小组Id
     * @author zhouzhongjun
     */
    void deleteSeminarGroupMemberBySeminarGroupId(BigInteger seminarGroupId);

    /**
     * 将学生加入讨论课小组.
     * <p>将用户加入指定的讨论课小组<br>
     *
     * @param userId  学生的id
     * @param groupId 要加入讨论课小组的id
     * @return
     * @throws IllegalArgumentException  (信息不合法，id格式错误)
     * @throws GroupNotFoundException    (未找到小组)
     * @throws UserNotFoundException     (不存在该学生)
     * @throws InvalidOperationException （待添加学生已经在小组里了）
     * @author YeHongjie
     */
    BigInteger insertSeminarGroupMemberById(BigInteger userId, BigInteger groupId)
            throws IllegalArgumentException, GroupNotFoundException, UserNotFoundException,
            InvalidOperationException;

    /**
     * 查询讨论课小组成员.
     * <p>按照讨论课小组id查询该小组的成员<br>
     *
     * @param groupId 要查询的讨论课小组id
     * @return List 讨论课小组成员信息
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @throws GroupNotFoundException   未找到小组
     * @author YeHongjie
     */
    List<User> listSeminarGroupMemberByGroupId(BigInteger groupId) throws
            IllegalArgumentException, GroupNotFoundException;

    /**
     * 获取某学生所有的讨论课小组.
     * <p>根据学生id获取学生所在的所有讨论课小组的信息<br>
     *
     * @param userId 学生id
     * @return list 讨论课小组列表
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @author qinlingyun
     */
    List<SeminarGroup> listSeminarGroupIdByStudentId(BigInteger userId) throws
            IllegalArgumentException;


    /**
     * 查询讨论课小组队长id.
     * <p>按照讨论课小组id查询该小组的队长id<br>
     *
     * @param groupId 要查询的讨论课小组id
     * @return leaderId 讨论课小组队长id
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @throws GroupNotFoundException   未找到小组
     * @author YeHongjie
     */
    BigInteger getSeminarGroupLeaderByGroupId(BigInteger groupId) throws
            IllegalArgumentException, GroupNotFoundException;


    /**
     * 按seminarId获取SeminarGroup.
     * <p>按seminarId获取SeminarGroup<br>
     *
     * @param seminarId 课程Id
     * @return 讨论课小组列表
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @throws SeminarNotFoundException 未找到讨论课
     * @author zhouzhongjun
     */
    List<SeminarGroup> listSeminarGroupBySeminarId(BigInteger seminarId) throws
            IllegalArgumentException, SeminarNotFoundException;

    /**
     * 按seminarId删除讨论课小组信息.
     * <p>根据seminarId获得SeminarGroup，然后根据SeminarGroupId删除SeminarGroupMember信息，最后再删除SeminarGroup信息<br>
     *
     * @param seminarId 讨论课Id
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @author zhouzhongjun
     * @see SeminarGroupService #listSeminarGroupBySeminarId(BigInteger seminarId)
     * @see SeminarGroupService #deleteSeminarGroupMemberBySeminarGroupId(BigInteger seminarGroupId)
     */
    void deleteSeminarGroupBySeminarId(BigInteger seminarId) throws
            IllegalArgumentException;

    /**
     * 创建讨论课小组.
     * <p>在指定讨论课下创建讨论课小组<br>
     *
     * @param seminarId    讨论课的id
     * @param seminarGroup 小组信息
     * @return BigInteger 若创建成功返回该小组的id，失败则返回-1
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @author YeHongjie
     * @see SeminarGroupService #insertSeminarGroupMemberByGroupId(BigInteger groupId,SeminarGroupMember SeminarGroupMember)
     */
    BigInteger insertSeminarGroupBySeminarId(BigInteger seminarId,
                                       SeminarGroup seminarGroup) throws IllegalArgumentException;

    /**
     * 创建小组成员信息.
     * <p>在指定小组成员表下创建一个新的小组信息<br>
     *
     * @param groupId            小组的id
     * @param seminarGroupMember 小组成员信息
     * @return BigInteger 若创建成功返回该小组成员表的id，失败则返回-1
     */
    BigInteger insertSeminarGroupMemberByGroupId(BigInteger groupId, SeminarGroupMember seminarGroupMember);


    /**
     * 删除讨论课小组.
     * <p>按照id删除讨论课小组<br>
     *
     * @param seminarGroupId 讨论课小组的id
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @author YeHongjie
     * @see SeminarGroupService #deleteSeminarGroupMemberBySeminarGroupId(BigInteger seminarGroupId)
     */
    void deleteSeminarGroupByGroupId(BigInteger seminarGroupId) throws
            IllegalArgumentException;


    /**
     * 查询讨论课小组.
     * <p>按照id查询某一讨论课小组的信息（包括成员）<br>
     *
     * @param groupId 小组的id
     * @return seminarGroup 讨论课小组对象，若未找到相关小组返回空(null)
     * @throws IllegalArgumentException (信息不合法，id格式错误)
     * @throws GroupNotFoundException   (未找到小组)
     * @author YeHongjie
     * @see SeminarGroupService #listSeminarGroupMemberByGroupId(BigInteger groupId)
     */
    SeminarGroup getSeminarGroupByGroupId(BigInteger groupId) throws
            IllegalArgumentException, GroupNotFoundException;

    /**
     * 获取学生所在讨论课队长.
     * <p>按照用户id和讨论课id获取学生所在讨论课小组队长<br>
     *
     * @param userId    用户的id
     * @param seminarId 讨论课id
     * @return BigInteger 讨论课小组的队长id，若未找到相关小组队长返回空(null)
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @author YeHongjie
     * @see SeminarGroupService #getSeminarGroupById(BigInteger userId, BigInteger seminarId)
     * @see SeminarGroupService #getSeminarGroupLeaderByGroupId(BigInteger groupId)
     */
    BigInteger getSeminarGroupLeaderById(BigInteger userId, BigInteger seminarId)
            throws IllegalArgumentException;


    /**
     * 定时器方法.
     * 自动分组.
     * <p>根据讨论课id和班级id，对签到的学生进行自动分组<br>
     *
     * @param seminarId 讨论课的id
     * @param classId   班级的id
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @throws ClassesNotFoundException 未找到班级
     * @throws SeminarNotFoundException 未找到讨论课
     * @author YeHongjie
     * @see UserService #listAttendanceById(BigInteger classId, BigInteger seminarId);
     */
    void automaticallyGrouping(BigInteger seminarId, BigInteger classId) throws
            IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException;


    /**
     * 根据讨论课Id及用户id，获得该用户所在的讨论课的小组的信息.
     * <p>根据讨论课Id及用户id，获得该用户所在的讨论课的小组的信息<br>
     *
     * @param seminarId 讨论课的id
     * @param userId    用户的id
     * @return SeminarGroup Group的相关信息
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @throws GroupNotFoundException   未找到小组
     */
    SeminarGroup getSeminarGroupById(BigInteger seminarId, BigInteger userId) throws
            IllegalArgumentException, GroupNotFoundException;


    /**
     * 根据话题Id获得选择该话题的所有小组的信息.
     * <p>根据话题Id获得选择该话题的所有小组的信息<br>
     *
     * @param topicId 话题的id
     * @return List 所有选择该话题的所有group的信息
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @throws GroupNotFoundException   未找到小组
     */
    List<SeminarGroup> listGroupByTopicId(BigInteger topicId) throws
            IllegalArgumentException, GroupNotFoundException;

    /**
     * 小组按id选择话题.
     * <p>小组通过小组id和话题id选择讨论课的话题<br>
     *
     * @param groupId 小组id
     * @param topicId 话题id
     * @return BigInteger 返回seminarGroupTopicId
     * @throws IllegalArgumentException GroupId、TopicId格式错误时抛出
     * @throws GroupNotFoundException   该小组不存在时抛出
     * @author heqi
     */
    BigInteger insertTopicByGroupId(BigInteger groupId, BigInteger topicId) throws
            IllegalArgumentException, GroupNotFoundException;


    /**
     * 成为组长.
     * <p>同学按小组id和自身id成为组长<br>
     *
     * @param groupId 小组id
     * @param userId  学生id
     * @throws IllegalArgumentException  信息不合法，id格式错误
     * @throws GroupNotFoundException    未找到小组
     * @throws UserNotFoundException     不存在该学生
     * @throws InvalidOperationException 已经有组长了
     */
    void assignLeaderById(BigInteger groupId, BigInteger userId) throws
            IllegalArgumentException, UserNotFoundException, GroupNotFoundException,
            InvalidOperationException;

    /**
     * 组长辞职.
     * <p>同学按小组id和自身id,辞掉组长职位<br>
     *
     * @param groupId 小组id
     * @param userId  学生id
     * @throws IllegalArgumentException (信息不合法，id格式错误)
     * @throws GroupNotFoundException   (未找到小组)
     */
    void resignLeaderById(BigInteger groupId, BigInteger userId) throws
            IllegalArgumentException, GroupNotFoundException;
}
