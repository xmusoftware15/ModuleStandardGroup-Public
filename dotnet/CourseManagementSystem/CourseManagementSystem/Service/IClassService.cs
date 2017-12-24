using System.Collections.Generic;
using Xmu.Crms.Shared.Models;

namespace Xmu.Crms.Shared.Service
{
    /// <summary>
    /// @author YeXiaona,ZhouZhongJun
    /// @version 2.00
    /// </summary>
    public interface IClassService
    {
        /// <summary>
        /// 按classId删除CourseSelection表的一条记录.
        /// @author zhouzhongjun
        /// </summary>
        /// <param name="classId">班级Id</param>
        void DeleteClassSelectionByClassId(long classId);

        /// <summary>
        /// 根据课程ID获得班级列表.
        /// @author yexiaona
        /// </summary>
        /// <param name="courseId">课程ID</param>
        /// <returns>list 班级列表</returns>
        IList<ClassInfo> ListClassByCourseId(long courseId);



        /// <summary>
        /// 按班级id获取班级详情.
        /// @author yexiaona
        /// </summary>
        /// <param name="classId">班级ID</param>
        /// <returns>ClassBO 班级</returns>
        ClassInfo GetClassByClassId(long classId);

        /// <summary>
        /// 按班级id和班级修改班级信息.
        /// @author yexiaona
        /// </summary>
        /// <param name="classId">班级ID</param>
        /// <param name="newclass">修改后班级信息</param>
        void UpdateClassByClassId(long classId, ClassInfo newclass);

        /// <summary>
        /// 按班级id删除班级.
        /// @author yexiaona
        /// </summary>
        /// <param name="classId">班级ID</param>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IClassService.DeleteScoreRuleById(System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IClassService.DeleteCourseSelectionById(System.Int64,System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IFixGroupService.DeleteFixGroupByClassId(System.Int64)"/>
        void DeleteClassByClassId(long classId);

        /// <summary>
        /// 学生按班级id选择班级.
        /// @author yexiaona
        /// </summary>
        /// <param name="userId">用户id</param>
        /// <param name="classId">班级id</param>
        /// <returns>courseSelectionId 选课记录id</returns>
        long InsertCourseSelectionById(long userId, long classId);

        /// <summary>
        /// 学生按班级id取消选择班级.
        /// @author yexiaona
        /// </summary>
        /// <param name="userId">用户id</param>
        /// <param name="classId">班级id</param>
        void DeleteCourseSelectionById(long userId, long classId);

        /// <summary>
        /// 老师获取位置信息，获取班级签到状态.
        /// 
        /// @author yexiaona
        /// </summary>
        /// <param name="seminarId">讨论课id</param>
        /// <param name="classId">班级id</param>
        /// <returns>location 班级签到状态</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ISeminarGroupService.ListSeminarGroupBySeminarId(System.Int64)"/>
        Location GetCallStatusById(long seminarId, long classId);



        /// <summary>
        /// 按courseId删除Class.
        /// @author zhouzhongjun
        /// </summary>
        /// <param name="courseId">课程Id</param>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IClassService.ListClassByCourseId(System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IClassService.DeleteClassSelectionByClassId(System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IClassService.DeleteScoreRuleById(System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IFixGroupService.DeleteFixGroupByClassId(System.Int64)"/>
        void DeleteClassByCourseId(long courseId);



        ///<summary>
        ///老师发起签到.
        ///往location表插入一条当前讨论课班级的签到状态
        /// </summary>
        /// <param name="location">当前讨论课班级的签到状态记录 </param>
        /// <returns> 返回location表的新记录的id</returns>
        ///   <exception cref="T:Xmu.Crms.Shared.Exceptions.SeminarNotFoundException">讨论课没有找到</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.ClassesNotFoundException">无此Id的班级</exception>
        long CallInRollById(Location location);

        /// <summary>
        /// 新增老师结束签到
        /// @author qinlingyun
        /// 老师结束签到,修改当前讨论课班级的签到状态为已结束
        /// </summary>
        /// <param name="location">当前讨论课班级的签到状态记录</param>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.SeminarNotFoundException">讨论课没有找到</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.ClassesNotFoundException">无此Id的班级</exception>
        void EndCallRollById(long seminarId,long classId);

        ///<summary>
        ///根据学生ID获取班级列表.
        /// @author YeXiaona
        ///
        /// </summary>
        /// <param name="userId">学生ID</param>
        /// <returns>list 班级列表</returns>
        /// <exception cref="T:System.ArgumentException">userId格式错误时抛出</exception>
        ///  <exception cref="T:Xmu.Crms.Shared.Exceptions.ClassesNotFoundException">无此班级</exception>
        List<ClassInfo> ListClassByUserId(long userId);

    }
}