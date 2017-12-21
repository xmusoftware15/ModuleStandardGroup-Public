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
        /// 按课程名称和教师名称获取班级列表.
        /// @author yexiaona
        /// </summary>
        /// <param name="courseName">课程名称</param>
        /// <param name="teacherName">教师名称</param>
        /// <returns>List 班级列表</returns>
        List<ClassInfo> ListClassByName(string courseName, string teacherName);

        /// <summary>
        /// 根据课程ID获得班级列表.
        /// @author yexiaona
        /// </summary>
        /// <param name="courseId">课程ID</param>
        /// <returns>list 班级列表</returns>
        List<ClassInfo> ListClassByCourseId(long courseId);

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
        void UpdateClassByClassId(long classId);

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
        /// <returns>url 选课url</returns>
        string InsertCourseSelectionById(long userId, long classId);

        /// <summary>
        /// 学生按班级id取消选择班级.
        /// @author yexiaona
        /// </summary>
        /// <param name="userId">用户id</param>
        /// <param name="classId">班级id</param>
        void DeleteCourseSelectionById(long userId, long classId);

        /// <summary>
        /// 老师获取该班级签到、分组状态.
        /// 
        /// @author yexiaona
        /// </summary>
        /// <param name="seminarId">讨论课id</param>
        /// <returns>classBO 班级</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ISeminarGroupService.ListSeminarGroupBySeminarId(System.Int64)"/>
        ClassInfo GetCallGroupStatusById(long seminarId);

        /// <summary>
        /// 新建班级.
        /// @author yexiaona
        /// </summary>
        /// <param name="userId">教师id</param>
        /// <param name="courseId">课程id</param>
        /// <returns>classId 班级Id</returns>
        long InsertClassById(long userId, long courseId);

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

        /// <summary>
        /// 按classId删除ScoreRule.
        /// @author zhouzhongjun
        /// </summary>
        /// <param name="classId">班级Id</param>
        void DeleteScoreRuleById(long classId);

        /// <summary>
        /// 查询评分规则.
        /// @author YeHongjie
        /// </summary>
        /// <param name="classId">班级id</param>
        /// <returns>ProportionBO 返回评分规则，若未找到对应评分规则返回空（null)</returns>
        ClassInfo GetScoreRule(long classId);

        /// <summary>
        /// 新增评分规则.
        /// @author YeHongjie
        /// </summary>
        /// <param name="classId">班级Id</param>
        /// <param name="proportions">评分规则</param>
        /// <returns>scoreRuleId 若创建成功则返回该评分规则的id，失败则返回-1</returns>
        long InsertScoreRule(long classId, ClassInfo proportions);

        /// <summary>
        /// 修改评分规则.
        /// @author YeHongjie
        /// </summary>
        /// <param name="classId">班级id</param>
        /// <param name="proportions">评分规则</param>
        void UpdateScoreRule(long classId, ClassInfo proportions);
    }
}