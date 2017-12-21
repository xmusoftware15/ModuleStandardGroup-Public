using System.Collections.Generic;
using Xmu.Crms.Shared.Models;

namespace Xmu.Crms.Shared.Service
{
    /// <summary>
    /// @author ModuleStandardGroup/zhouzhongjun
    /// @version 2.00
    /// </summary>
    public interface ISeminarGroupService
    {
        /// <summary>
        /// 按seminarGroupId删除SeminarGroupMember信息.
        /// @author zhouzhongjun
        /// </summary>
        /// <param name="seminarGroupId">讨论课小组Id</param>
        void DeleteSeminarGroupMemberBySeminarGroupId(long seminarGroupId);

        /// <summary>
        /// 将学生加入讨论课小组.
        /// @author YeHongjie
        /// </summary>
        /// <param name="userId">学生的id</param>
        /// <param name="groupId">要加入讨论课小组的id</param>
        /// <returns>long 该条记录的id</returns>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.GroupNotFoundException">未找到小组</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.UserNotFoundException">不存在该学生</exception>
        /// <exception cref="T:System.InvalidOperationException">待添加学生已经在小组里了</exception>
        long InsertSeminarGroupMemberById(long userId, long groupId);

        /// <summary>
        /// 查询讨论课小组成员.
        /// @author YeHongjie
        /// </summary>
        /// <param name="groupId">要查询的讨论课小组id</param>
        /// <returns>List 讨论课小组成员信息</returns>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.GroupNotFoundException">未找到小组</exception>
        List<UserInfo> ListSeminarGroupMemberByGroupId(long groupId);

        /// <summary>
        /// 获取某学生所有的讨论课小组.
        /// @author qinlingyun
        /// </summary>
        /// <param name="userId">学生id</param>
        /// <returns>list 讨论课小组列表</returns>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        List<SeminarGroup> ListSeminarGroupIdByStudentId(long userId);

        /// <summary>
        /// 查询讨论课小组队长id.
        /// @author YeHongjie
        /// </summary>
        /// <param name="groupId">要查询的讨论课小组id</param>
        /// <returns>leaderId 讨论课小组队长id</returns>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.GroupNotFoundException">未找到小组</exception>
        long GetSeminarGroupLeaderByGroupId(long groupId);

        /// <summary>
        /// 按seminarId获取SeminarGroup.
        /// @author zhouzhongjun
        /// </summary>
        /// <param name="seminarId">课程Id</param>
        /// <returns>讨论课小组列表</returns>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.SeminarNotFoundException">未找到小组</exception>
        List<SeminarGroup> ListSeminarGroupBySeminarId(long seminarId);

        /// <summary>
        /// 按seminarId删除讨论课小组信息.
        /// @author zhouzhongjun
        /// 根据seminarId获得SeminarGroup，然后根据SeminarGroupId删除SeminarGroupMember信息，最后再删除SeminarGroup信息
        /// </summary>
        /// <param name="seminarId">讨论课Id</param>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ISeminarGroupService.ListSeminarGroupBySeminarId(System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ISeminarGroupService.DeleteSeminarGroupMemberBySeminarGroupId(System.Int64)"/>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        void DeleteSeminarGroupBySeminarId(long seminarId);

        /// <summary>
        /// 创建讨论课小组.
        /// @author YeHongjie
        /// </summary>
        /// <param name="seminarId">讨论课的id</param>
        /// <param name="seminarGroup">小组信息</param>
        /// <returns>long 返回该小组的id</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ISeminarGroupService.InsertSeminarGroupMemberById(System.Int64,System.Int64)"/>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        long InsertSeminarGroupBySeminarId(long seminarId, SeminarGroup seminarGroup);

        /// <summary>
        /// 创建小组成员信息.
        /// </summary>
        /// <param name="groupId">小组的id</param>
        /// <param name="seminarGroupMember">小组成员信息</param>
        /// <returns>long 返回该小组成员表的id</returns>
        long InsertSeminarGroupMemberByGroupId(long groupId, SeminarGroupMember seminarGroupMember);


        /// <summary>
        /// 删除讨论课小组.
        /// @author YeHongjie
        /// </summary>
        /// <param name="seminarGroupId">讨论课小组的id</param>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ISeminarGroupService.DeleteSeminarGroupMemberBySeminarGroupId(System.Int64)"/>
        void DeleteSeminarGroupByGroupId(long seminarGroupId);

        /// <summary>
        /// 查询讨论课小组.
        /// @author YeHongjie
        /// 按照id查询某一讨论课小组的信息（包括成员）
        /// </summary>
        /// <param name="groupId">小组的id</param>
        /// <returns>seminarGroup 讨论课小组对象，若未找到相关小组返回空(null)</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ISeminarGroupService.ListSeminarGroupMemberByGroupId(System.Int64)"/>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.GroupNotFoundException">未找到小组</exception>
        SeminarGroup GetSeminarGroupByGroupId(long groupId);

        /// <summary>
        /// 获取学生所在讨论课队长.
        /// @author YeHongjie
        /// </summary>
        /// <param name="userId">用户的id</param>
        /// <param name="seminarId">讨论课id</param>
        /// <returns>long 讨论课小组的队长id，若未找到相关小组队长返回空(null)</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ISeminarGroupService.GetSeminarGroupById(System.Int64,System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ISeminarGroupService.GetSeminarGroupLeaderByGroupId(System.Int64)"/>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        long GetSeminarGroupLeaderById(long userId, long seminarId);

        /// <summary>
        /// 自动分组.
        /// @author YeHongjie
        /// </summary>
        /// 
        /// 根据讨论课id和班级id，对签到的学生进行自动分组
        /// 
        /// <param name="seminarId">讨论课的id</param>
        /// <param name="classId">班级的id</param>
        /// <returns>Boolean 自动分组成功返回true，否则返回false</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IUserService.ListAttendanceById(System.Int64,System.Int64)"/>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.SeminarNotFoundException">未找到讨论课</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.ClassNotFoundException">未找到班级</exception>
        bool AutomaticallyGrouping(long seminarId, long classId);

        /// <summary>
        /// 根据讨论课Id及用户id，获得该用户所在的讨论课的小组的信息.
        /// </summary>
        /// <param name="seminarId">(讨论课的id)</param>
        /// <param name="userId"></param>
        /// <returns>SeminarGroup Group的相关信息</returns>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.GroupNotFoundException">未找到小组</exception>
        SeminarGroup GetSeminarGroupById(long seminarId, long userId);

        /// <summary>
        /// 根据话题Id获得选择该话题的所有小组的信息.
        /// </summary>
        /// <param name="topicId"></param>
        /// <returns>List&lt;GroupBO&gt;所有选择该话题的所有group的信息</returns>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.GroupNotFoundException">未找到小组</exception>
        List<SeminarGroup> ListGroupByTopicId(long topicId);

        /// <summary>
        /// 小组按id选择话题.
        /// @author heqi
        /// </summary>
        /// <param name="groupId">小组id</param>
        /// <param name="topicId">话题id</param>
        /// <returns>String 返回一个url</returns>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.GroupNotFoundException">未找到小组</exception>
        string InsertTopicByGroupId(long groupId, long topicId);

        /// <summary>
        /// 成为组长.
        /// 同学按小组id和自身id成为组长
        /// </summary>
        /// <param name="groupId">小组id</param>
        /// <param name="userId">学生id</param>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.UserNotFoundException">不存在该学生</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.GroupNotFoundException">未找到小组</exception>
        /// <exception cref="T:System.InvalidOperationException">已经有组长了</exception>
        void AssignLeaderById(long groupId, long userId);

        /// <summary>
        /// 组长辞职.
        /// 同学按小组id和自身id,辞掉组长职位
        /// </summary>
        /// <param name="groupId">小组id</param>
        /// <param name="userId">学生id</param>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.UserNotFoundException">不存在该学生</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.GroupNotFoundException">未找到小组</exception>
        /// <exception cref="T:System.InvalidOperationException">学生不是组长</exception>
        void ResignLeaderById(long groupId, long userId);
    }
}