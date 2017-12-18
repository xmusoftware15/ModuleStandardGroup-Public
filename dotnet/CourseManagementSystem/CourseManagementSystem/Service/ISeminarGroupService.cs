using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Numerics;
using Xmu.Crms.Shared.Models;

namespace Xmu.Crms.Shared.Service
{
    /**
 * 
 * @author ModuleStandardGroup/zhouzhongjun
 * @version 2.00
 *
 */
    public interface SeminarGroupService
    {


        /**
         * 按seminarGroupId删除SeminarGroupMember信息.
         * @author zhouzhongjun
         * @param seminarGroupId 讨论课小组Id
         * @return true/false 是否成功删除
         */
        Boolean DeleteSeminarGroupMemberBySeminarGroupId(BigInteger seminarGroupId);

        /**
         * 将学生加入讨论课小组.
         * <p>将用户加入指定的讨论课小组<br>*
         * @author YeHongjie
         * @param userId 学生的id
         * @param groupId 要加入讨论课小组的id
         * @return BigInteger 若创建成功返回该条记录的id，失败则返回-1
         *@exception InfoIllegalException throws when (信息不合法，id格式错误)
         *@exception GroupNotFoundException throws when (未找到小组)
         *@exception UserNotFoundException throws when (不存在该学生)
         *@exception InvalidOperationException throws when （待添加学生已经在小组里了）
         */
        BigInteger InsertSeminarGroupMemberById(BigInteger userId, BigInteger groupId);

        /**
         * 查询讨论课小组成员.
         * <p>按照讨论课小组id查询该小组的成员<br>*
         * @author YeHongjie
         * @param groupId 要查询的讨论课小组id
         * @return List 讨论课小组成员信息
         * @exception InfoIllegalException throws when 信息不合法，id格式错误
         * @exception GroupNotFoundException throws when 未找到小组
         */
        List<UserInfo> ListSeminarGroupMemberByGroupId(BigInteger groupId);

        /**
         * 获取某学生所有的讨论课小组.
         * <p>根据学生id获取学生所在的所有讨论课小组的id<br>
         * @author qinlingyun
         * @param userId 学生id
         * @return list 讨论课小组列表
         * @exception InfoIllegalException throws when 信息不合法，id格式错误
         */
        List<SeminarGroup> ListSeminarGroupIdByStudentId(BigInteger userId);


        /**
         * 查询讨论课小组队长id.
         * <p>按照讨论课小组id查询该小组的队长id<br>*
         * @author YeHongjie
         * @param groupId 要查询的讨论课小组id
         * @return leaderId 讨论课小组队长id
         * @exception InfoIllegalException throws when 信息不合法，id格式错误
         * @exception GroupNotFoundException throws when 未找到小组
         */
        BigInteger GetSeminarGroupLeaderByGroupId(BigInteger groupId);


        /**
         * 按seminarId获取SeminarGroup.
         * @author zhouzhongjun
         * @param seminarId 课程Id
         * @return 讨论课小组列表
         * @exception InfoIllegalException throws when 信息不合法，id格式错误
         * @exception SeminarNotFoundException throws when 未找到讨论课
         */
        List<SeminarGroup> ListSeminarGroupBySeminarId(BigInteger seminarId);

        /**
         * 按seminarId删除讨论课小组信息.
         * <p>根据seminarId获得SeminarGroup，然后根据SeminarGroupId删除SeminarGroupMember信息，最后再删除SeminarGroup信息<br>  
         * @author zhouzhongjun
         * @param seminarId 讨论课Id
         * @see SeminarGroupService #listSeminarGroupBySeminarId(BigInteger seminarId)
         * @see SeminarGroupService #deleteSeminarGroupMemberBySeminarGroupId(BigInteger seminarGroupId)
         * @return true删除成功 false删除失败
         * @exception InfoIllegalException throws when 信息不合法，id格式错误
         */
        Boolean DeleteSeminarGroupBySeminarId(BigInteger seminarId);

        /**
         * 创建讨论课小组.
         * ＜p＞在指定讨论课下创建讨论课小组<br>*
         * @author YeHongjie
         * @param seminarId 讨论课的id
         * @param seminarGroupBO 小组信息
         * @see SeminarGroupService #insertSeminarGroupMemberByGroupId(BigInteger groupId,SeminarGroupMember SeminarGroupMember) 
         * @return BigInteger 若创建成功返回该小组的id，失败则返回-1
         * @exception InfoIllegalException throws when 信息不合法，id格式错误
         */
        BigInteger InsertSeminarGroupBySeminarId(BigInteger seminarId, SeminarGroup seminarGroup);

        /**
         * 创建小组成员信息.
         * ＜p＞在指定小组成员表下创建一个新的小组信息<br>*
         * @param groupId 小组的id
         * @param seminarGroupMember 小组成员信息
         * @return BigInteger 若创建成功返回该小组成员表的id，失败则返回-1
         */
        BigInteger InsertSeminarGroupMemberByGroupId(BigInteger groupId, SeminarGroupMember SeminarGroupMember);


        /**
         * 删除讨论课小组.
         * ＜p＞按照id删除讨论课小组<br>*
         * @author YeHongjie
         * @param seminarGroupId 讨论课小组的id
         * @return Boolean 若创建成功返回true，失败返回false
         * @see SeminarGroupService #deleteSeminarGroupMemberBySeminarGroupId(BigInteger seminarGroupId)
         * @exception InfoIllegalException throws when 信息不合法，id格式错误
         */
        Boolean DeleteSeminarGroupByGroupId(BigInteger seminarGroupId);


        /**
         * 查询讨论课小组.
         * ＜p＞按照id查询某一讨论课小组的信息（包括成员）<br>*
         * @author YeHongjie
         * @param groupId 小组的id
         * @return seminarGroup 讨论课小组对象，若未找到相关小组返回空(null)
         * @see SeminarGroupService #listSeminarGroupMemberByGroupId(BigInteger groupId)
         * @exception InfoIllegalException throws when (信息不合法，id格式错误)
         * @exception GroupNotFoundException throws when (未找到小组)
         */
        SeminarGroup GetSeminarGroupByGroupId(BigInteger groupId);

        /**
         * 获取学生所在讨论课队长.
         * ＜p＞按照用户id和讨论课id获取学生所在讨论课小组队长<br>*
         * @author YeHongjie
         * @param userId 用户的id
         * @param seminarId 讨论课id
         * @return BigInteger 讨论课小组的队长id，若未找到相关小组队长返回空(null)
         * @see SeminarGroupService #getSeminarGroupById(BigInteger userId, BigInteger seminarId)
         * @see SeminarGroupService #getSeminarGroupLeaderByGroupId(BigInteger groupId)
         * @exception InfoIllegalException throws when 信息不合法，id格式错误
         */
        BigInteger GetSeminarGroupLeaderById(BigInteger userId, BigInteger seminarId);


        /**
         * 自动分组.
         * ＜p＞根据讨论课id和班级id，对签到的学生进行自动分组<br>*
         * @author YeHongjie
         * @param seminarId 讨论课的id
         * @param classId 班级的id
         * @see UserService #List<AttendanceBO> listAttendanceById(BigInteger classId, BigInteger seminarId);
         * @return Boolean 自动分组成功返回true，否则返回false
         * @exception InfoIllegalException throws when 信息不合法，id格式错误
         * @exception ClassesNotFoundException throws when  未找到班级
         * @exception SeminarNotFoundException throws when  未找到讨论课
         */
        Boolean AutomaticallyGrouping(BigInteger seminarId, BigInteger classId);


        /**
        * 根据讨论课Id及用户id，获得该用户所在的讨论课的小组的信息.
        * @param seminarId (讨论课的id)
        * @param userId（用户的id）
        * @return SeminarGroup Group的相关信息
        * @exception InfoIllegalException throws when 信息不合法，id格式错误
        * @exception GroupNotFoundException throws when 未找到小组
        */
        SeminarGroup GetSeminarGroupById(BigInteger seminarId, BigInteger userId);


        /**
         * 根据话题Id获得选择该话题的所有小组的信息.
         * @param  topicId(话题的id)
         * @return  List<GroupBO> 所有选择该话题的所有group的信息
         *@exception nfoIllegalException throws when (信息不合法，id格式错误)
         *@exception GroupNotFoundException throws when (未找到小组)
         */
        List<SeminarGroup> ListGroupByTopicId(BigInteger topicId);

        /**
         * 小组按id选择话题.
         * <p>小组通过小组id和话题id选择讨论课的话题<br>
         * @author heqi
         * @param groupId 小组id
         * @param topicId 话题id
         * @return String 返回一个url
         * @exception InfoIllegalException throws when GroupId、TopicId格式错误时抛出
         * @exception GroupNotFoundException throws when 该小组不存在时抛出
         */
        String InsertTopicByGroupId(BigInteger groupId, BigInteger topicId);


        /**
         * 小组取消话题.
         * <p>小组按小组id取消讨论课的话题的选择<br>
         * @author heqi
         * @param groupId 小组id
         * @return true/false 返回取消话题是否成功
         * @exception InfoIllegalException GroupId throws when 格式错误时抛出
         * @exception GroupNotFoundException throws when 该小组不存在时抛出
         */
        Boolean DeleteTopicByGroupId(BigInteger groupId);

        /**
         * 成为组长.
         * <p>同学按小组id和自身id成为组长<br>
         * @param groupId 小组id
         * @param userId  学生id
         * @return true/false 返回成为组长是否成功
         * @exception InfoIllegalException(信息不合法，id格式错误)
         * @exception GroupNotFoundException throws when (未找到小组)
         * @exception UserNotFoundException throws when (不存在该学生)
         * @exception InvalidOperationException throws when （已经有组长了）
         */
        Boolean AssignLeaderById(BigInteger groupId, BigInteger userId);

        /**
         * 组长辞职.
         * <p>同学按小组id和自身id,辞掉组长职位<br>
         * @param groupId 小组id
         * @param userId  学生id
         * @return true/false 返回组成辞职是否成功
         * @exception InfoIllegalException throws when (信息不合法，id格式错误)
         * @exception GroupNotFoundException throws when (未找到小组)
         */
        Boolean ResignLeaderById(BigInteger groupId, BigInteger userId);




    }
}
