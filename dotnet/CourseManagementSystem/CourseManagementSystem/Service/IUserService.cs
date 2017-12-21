using System.Collections.Generic;
using Xmu.Crms.Shared.Models;

namespace Xmu.Crms.Shared.Service
{
    /// <summary>
    /// @author YeHongjie
    /// @version 2.00
    /// </summary>
    public interface IUserService
    {
        /// <summary>
        /// 添加学生签到信息.
        /// @author LiuAiqi
        /// 根据班级id，讨论课id，学生id，经度，纬度进行签到 在方法中通过班级id，讨论课id获取当堂课发起签到的位置
        /// </summary>
        /// <param name="classId">班级的id</param>
        /// <param name="seminarId">讨论课的id</param>
        /// <param name="userId">学生的id</param>
        /// <param name="longitude">经度</param>
        /// <param name="latitude">纬度</param>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.ClassNotFoundException">未找到班级</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.SeminarNotFoundException">未找到讨论课</exception>
        void InsertAttendanceById(long classId, long seminarId, long userId, double longitude, double latitude);

        /// <summary>
        /// 获取学生签到信息.
        /// @author LiuAiqi
        /// 根据班级id，讨论课id获取当堂课签到信息
        /// </summary>
        /// <param name="classId">班级的id</param>
        /// <param name="seminarId">讨论课id</param>
        /// <returns>list 当堂课签到信息</returns>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.ClassNotFoundException">未找到班级</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.SeminarNotFoundException">未找到讨论课</exception>
        List<Attendance> ListAttendanceById(long classId, long seminarId);

        /// <summary>
        /// 根据用户Id获取用户的信息.
        /// @author qinlingyun
        /// </summary>
        /// <param name="userId">用户Id</param>
        /// <returns>user 用户信息</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ISchoolService.GetSchoolBySchoolId(System.Int64)"/>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.UserNotFoundException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.UserNotFoundException">未找到对应用户</exception>
        UserInfo GetUserByUserId(long userId);

        /// <summary>
        /// 根据用户名获取用户ID.
        /// @author qinlingyun
        /// </summary>
        /// <param name="userName">用户名</param>
        /// <returns>userId 用户ID</returns>
        List<long> ListUserIdByUserName(string userName);

        /// <summary>
        /// 根据用户ID修改用户信息.
        /// @author qinlingyun
        /// </summary>
        /// <param name="userId">用户Id</param>
        /// <param name="user">用户信息</param>
        /// <returns>list 用户id列表</returns>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.UserNotFoundException">未找到对应用户</exception>
        void UpdateUserByUserId(long userId, UserInfo user);

        /// <summary>
        /// 按班级ID、学号开头、姓名开头获取学生列表.
        /// @author qinlingyun
        /// </summary>
        /// <param name="classId">班级ID</param>
        /// <param name="numBeginWith">学号开头</param>
        /// <param name="nameBeginWith">姓名开头</param>
        /// <returns>list 用户列表</returns>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.ClassNotFoundException">未找到对应班级</exception>
        List<UserInfo> ListUserByClassId(long classId, string numBeginWith, string nameBeginWith);

        /// <summary>
        /// 根据用户名获取用户列表.
        /// @author qinlingyun
        /// </summary>
        /// <param name="userName">用户名</param>
        /// <returns>list 用户列表</returns>
        List<UserInfo> ListUserByUserName(string userName);

        /// <summary>
        /// 获取讨论课所在的班级的出勤学生名单.
        /// @author qinlingyun
        /// </summary>
        /// <param name="seminarId">讨论课ID</param>
        /// <param name="classId">班级ID</param>
        /// <returns>list 处于出勤状态的学生的列表</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IUserService.ListAttendanceById(System.Int64,System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IUserService.GetUserByUserId(System.Int64)"/>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        List<UserInfo> ListPresentStudent(long seminarId, long classId);

        /// <summary>
        /// 获取讨论课所在班级缺勤学生名单.
        /// </summary>
        /// <param name="seminarId">讨论课ID</param>
        /// <param name="classId">班级ID</param>
        /// <returns>list 处于缺勤状态的学生列表</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IUserService.ListUserByClassId(System.Int64,System.String,System.String)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IUserService.ListPresentStudent(System.Int64,System.Int64)"/>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        List<UserInfo> ListAbsenceStudent(long seminarId, long classId);

        /// <summary>
        /// 根据教师名称列出课程名称.
        /// @author yexiaona
        /// </summary>
        /// <param name="teacherName">教师名称</param>
        /// <returns>list 课程列表</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IUserService.ListUserByUserName(System.String)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ICourseService.ListCourseByUserId(System.Int64)"/>
        List<Course> ListCourseByTeacherName(string teacherName);
    }
}