using System.Collections.Generic;
using Xmu.Crms.Shared.Models;

namespace Xmu.Crms.Shared.Service
{
    /// <summary>
    /// @author YeXiaona ZhouZhongjun CaoXingmei
    /// @version 2.00
    /// </summary>
    public interface ICourseService
    {
        /// <summary>
        /// 按userId获取与当前用户相关联的课程列表.
        /// @author ZhouZhongjun
        /// </summary>
        /// <param name="userId">用户Id</param>
        /// <returns>null 课程列表</returns>
        /// <exception cref="T:System.ArgumentException">userId格式错误时抛出</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.CourseNotFoundException">未找到课程</exception>
        List<Course> ListCourseByUserId(long userId);


        /// <summary>
        /// 按userId创建课程.
        /// @author ZhouZhongjun
        /// </summary>
        /// <param name="userId">用户Id</param>
        /// <param name="course">课程信息</param>
        /// <returns>courseId 新建课程的id</returns>
        /// <exception cref="T:System.ArgumentException">userId格式错误时抛出</exception>
        long InsertCourseByUserId(long userId, Course course);


        /// <summary>
        /// 按courseId获取课程 .
        /// @author ZhouZhongjun
        /// </summary>
        /// <param name="courseId">课程Id</param>
        /// <returns>course</returns>
        /// <exception cref="T:System.ArgumentException">userId格式错误时抛出</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.CourseNotFoundException">未找到课程</exception>
        Course GetCourseByCourseId(long courseId);


        /// <summary>
        /// 传入courseId和course信息修改course信息.
        /// @author ZhouZhongjun
        /// </summary>
        /// <param name="courseId">课程Id</param>
        /// <param name="course">课程信息</param>
        void UpdateCourseByCourseId(long courseId, Course course);


        /// <summary>
        /// 按courseId删除课程.
        /// @author ZhouZhongjun
        /// </summary>
        /// <param name="courseId">课程Id</param>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ISeminarService.DeleteSeminarByCourseId(System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IClassService.DeleteClassByCourseId(System.Int64)"/>
        /// <exception cref="T:System.ArgumentException">courseId格式错误时抛出</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.CourseNotFoundException">未找到课程</exception>
        void DeleteCourseByCourseId(long courseId);


        /// <summary>
        /// 根据课程名称获取课程列表.
        /// @author YeXiaona
        /// </summary>
        /// <param name="courseName">课程名称</param>
        /// <returns>list 课程列表</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ICourseService.GetCourseByCourseId(System.Int64)"/>
        List<Course> ListCourseByCourseName(string courseName);


        /// <summary>
        /// 按课程名称获取班级列表.
        /// @author YeXiaona
        /// </summary>
        /// <param name="courseName">课程名称</param>
        /// <returns>list 班级列表</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ICourseService.ListCourseByCourseName(System.String)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IClassService.ListClassByCourseId(System.Int64)"/>
        List<ClassInfo> ListClassByCourseName(string courseName);


        /// <summary>
        /// 按教师名称获取班级列表.
        /// @author YeXiaona
        /// </summary>
        /// <param name="teacherName">教师名称</param>
        /// <returns>list 班级列表</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IUserService.ListUserIdByUserName(System.String)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ICourseService.ListClassByUserId(System.Int64)"/>
        List<ClassInfo> ListClassByTeacherName(string teacherName);


        /// <summary>
        /// 根据教师ID获取班级列表.
        /// @author YeXiaona
        /// </summary>
        /// <param name="userId">教师ID</param>
        /// <returns>list 班级列表</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ICourseService.ListCourseByUserId(System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IClassService.ListClassByCourseId(System.Int64)"/>
        /// <exception cref="T:System.ArgumentException">userId格式错误时抛出</exception>
        List<ClassInfo> ListClassByUserId(long userId);
    }
}