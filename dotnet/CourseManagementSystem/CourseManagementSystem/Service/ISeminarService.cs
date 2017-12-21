using System.Collections.Generic;
using Xmu.Crms.Shared.Models;

namespace Xmu.Crms.Shared.Service
{
    /// <summary>
    /// @author zhouzhongjun CaoXingmei YeHongjie
    /// @version 2.00
    /// </summary>
    public interface ISeminarService
    {
        /// <summary>
        /// 按courseId获取Seminar.
        /// @author zhouzhongjun
        /// </summary>
        /// <param name="courseId">课程Id</param>
        /// <returns>List 讨论课列表</returns>
        /// <exception cref="T:System.ArgumentException">格式错误、教师设置embedGrade为true时抛出</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.CourseNotFoundException">未找到该课程时抛出</exception>
        List<Seminar> ListSeminarByCourseId(long courseId);


        /// <summary>
        /// 按courseId删除Seminar.
        /// @author zhouzhongjun
        /// 先根据CourseId获得所有的seminar的信息，然后根据seminar信息删除相关topic的记录，然后再根据SeminarId删除SeminarGroup表记录,最后再将seminar的信息删除
        /// </summary>
        /// <param name="courseId">课程Id</param>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ISeminarService.ListSeminarByCourseId(System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ITopicService.DeleteTopicBySeminarId(System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ISeminarGroupService.DeleteSeminarGroupBySeminarId(System.Int64)"/>
        /// <exception cref="T:System.ArgumentException">格式错误时抛出</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.CourseNotFoundException">该课程不存在时抛出</exception>
        void DeleteSeminarByCourseId(long courseId);

        /// <summary>
        /// 获得学生相关的某个讨论课的信息.
        /// @author CaoXingmei
        /// 通过学生用户id和讨论课id获得学生某个讨论课的详细信息(包括讨论课信息，教师信息).
        /// </summary>
        /// <param name="seminarId">讨论课的id</param>
        /// <param name="userId">学生的id</param>
        /// <returns>相应的讨论课的详细信息</returns>
        /// <exception cref="T:System.ArgumentException">格式错误时抛出</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.CourseNotFoundException">该课程不存在时抛出</exception>
        Seminar GetSeminarDetailBySeminarId(long seminarId, long userId);


        /// <summary>
        /// 用户通过讨论课id获得讨论课的信息.
        /// @author CaoXingmei
        /// 用户通过讨论课id获得讨论课的信息（包括讨论课名称、讨论课描述、分组方式、开始时间、结束时间）
        /// </summary>
        /// <param name="seminarId">讨论课的id</param>
        /// <returns>相应的讨论课信息</returns>
        /// <exception cref="T:System.ArgumentException">格式错误时抛出</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.CourseNotFoundException">该课程不存在时抛出</exception>
        Seminar GetSeminarBySeminarId(long seminarId);


        /// <summary>
        /// 按讨论课id修改讨论课.
        /// @author CaoXingmei
        /// 用户（老师）通过seminarId修改讨论课的相关信息
        /// </summary>
        /// <param name="seminarId">讨论课的id</param>
        /// <param name="seminar">讨论课信息</param>
        /// <exception cref="T:System.ArgumentException">格式错误时抛出</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.SeminarNotFoundException">该讨论课不存在时抛出</exception>
        void UpdateSeminarBySeminarId(long seminarId, Seminar seminar);


        /// <summary>
        /// 按讨论课id删除讨论课.
        /// @author CaoXingmei
        /// 用户（老师）通过seminarId删除讨论课(包括删除讨论课包含的topic信息和小组信息).
        /// </summary>
        /// <param name="seminarId">讨论课的id</param>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ISeminarGroupService.DeleteSeminarGroupBySeminarId(System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ITopicService.DeleteTopicBySeminarId(System.Int64)"/>
        /// <exception cref="T:System.ArgumentException">格式错误时抛出</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.SeminarNotFoundException">该讨论课不存在时抛出</exception>
        void DeleteSeminarBySeminarId(long seminarId);


        /// <summary>
        /// 新增讨论课.
        /// @author YeHongjie
        /// 用户（老师）在指定的课程下创建讨论课
        /// </summary>
        /// <param name="courseId">课程的id</param>
        /// <param name="seminar">讨论课信息</param>
        /// <returns>seminarId 若创建成功返回创建的讨论课id，失败则返回-1</returns>
        /// <exception cref="T:System.ArgumentException">格式错误时抛出</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.SeminarNotFoundException">该讨论课不存在时抛出</exception>
        long InsertSeminarByCourseId(long courseId, Seminar seminar);
    }
}