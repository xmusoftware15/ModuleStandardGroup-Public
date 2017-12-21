using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Numerics;
using Xmu.Crms.Shared.Models;

namespace Xmu.Crms.Shared.Service
{
    /**
 * @author YeHongjie
 * @version 2.00
 */
    public interface IUserService
    {
        /**
	 * 添加学生签到信息.
	 * <p>根据班级id，讨论课id，学生id，经度，纬度进行签到，在方法中通过班级id，讨论课id获取当堂课发起签到的位置<br>
	 * @author LiuAiqi
	 * @param classId 班级的id
	 * @param seminarId 讨论课的id
	 * @param userId 学生的id
	 * @param longitude 经度
	 * @param latitude 纬度
	 * @exception IllegalArgumentException 信息不合法，id格式错误 
	 * @exception ClassesNotFoundException 未找到班级
	 * @exception SeminarNotFoundException 未找到讨论课
	 */
        void InsertAttendanceById(long classId, long seminarId, long userId, double longitude, double latitude);

        /**
         * 获取学生签到信息.
         * <p>根据班级id，讨论课id获取当堂课签到信息
         * @author LiuAiqi
         * @param classId 班级的id
         * @param seminarId 讨论课id
         * @return list 当堂课签到信息
         * @exception IllegalArgumentException 信息不合法，id格式错误 
         * @exception ClassesNotFoundException throws when 未找到班级
         * @exception SeminarNotFoundException throws when 未找到讨论课
         */
        List<Attendance> ListAttendanceById(long classId, long seminarId);




        /**
         * 根据用户Id获取用户的信息.
         * <p>根据用户Id获取用户的信息<br> 
         * @author qinlingyun
         * @param userId 用户Id
         * @return user 用户信息
         * @see SchoolService#getSchoolBySchoolId(long schoolId)
         * @exception IllegalArgumentException throws when 信息不合法，id格式错误 
         * @exception UserNotFoundException throws when 未找到对应用户
         */
        UserInfo GetUserByUserId(long userId);

        /**
         * 根据用户名获取用户ID.
         * <p>根据用户名获取用户ID<br>
         * @author qinlingyun
         * @param userName 用户名
         * @return userId 用户ID
         * @exception IllegalArgumentException throws when 信息不合法，id格式错误 
         * @exception UserNotFoundException throws when 未找到对应用户
         */
        List<long> ListUserIdByUserName(string userName);

        /**
	 * 根据用户ID修改用户信息.
	 * <p>根据用户ID修改用户信息<br> 
	 * @author qinlingyun
	 * @param userId 用户Id
	 * @param user 用户信息
	 * @exception UserNotFoundException throws when 未找到对应用户
	 */
        void UpdateUserByUserId(long userId, UserInfo user);


        /**
         * 按班级ID、学号开头、姓名开头获取学生列表.
         * <p>按班级ID、学号开头、姓名开头获取学生列表<br> 
         * @author qinlingyun
         * @param classId 班级ID
         * @param numBeginWith 学号开头
         * @param nameBeginWith 姓名开头
         * @return list 用户列表
         * @exception IllegalArgumentException throws when 信息不合法
         * @exception ClassesNotFoundException throws when 未找到对应班级
         */
        List<UserInfo> ListUserByClassId(long classId, string numBeginWith, string nameBeginWith);


        /**
         * 根据用户名获取用户列表.
         * <p>根据用户名获取用户列表<br> 
         * @author qinlingyun
         * @param userName 用户名
         * @return list 用户列表
         * @exception UserNotFoundException throws when 未找到对应用户
         */
        List<UserInfo> ListUserByUserName(string userName);


        /**
         * 获取讨论课所在的班级的出勤学生名单.
         * <p>根据ID获取讨论课所在的班级的出勤学生名单<br>
         * @author qinlingyun
         * @param seminarId 讨论课ID
         * @param classId 班级ID
         * @return list 处于出勤状态的学生的列表
         * @see UserService #listAttendanceById(long, long)
         * @see UserService #getUserByUserId(long)
         * @exception IllegalArgumentException throws when 信息不合法，id格式错误
         */
        List<UserInfo> ListPresentStudent(long seminarId, long classId);


        /**
         * 获取讨论课所在班级缺勤学生名单.
         * <p>获取讨论课所在班级缺勤学生名单<br>
         * @param seminarId 讨论课ID
         * @param classId 班级ID
         * @return list 处于缺勤状态的学生列表
         * @see UserService #listUserByClassId(long, String, String)
         * @see UserService #listPresentStudent(long, long)
         * @exception IllegalArgumentException throws when 信息不合法，id格式错误
         */
        List<UserInfo> ListAbsenceStudent(long seminarId, long classId);

        /**
         * 根据教师名称列出课程名称.
         * <p>根据教师名称列出课程名称<br>
         * @author yexiaona
         * @param teacherName 教师名称
         * @return list 课程列表
         * @see UserService #listUserByUserName(String userName)
         * @see CourseService #listCourseByUserId(long userId)
         */
        List<Course> ListCourseByTeacherName(string teacherName);


    }
}
