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
 * @author YeXiaona ZhouZhongjun CaoXingmei
 * @version 2.00
 *
 */
    public interface CourseService
    {

        /**
         * 按userId获取与当前用户相关联的课程列表.
         * <p>老师与他相关联的课程列表<br> 
         * @author ZhouZhongjun
         * @param userId 用户Id
         * @return null 课程列表
         * @exception InfoIllegalException userId格式错误时抛出
         * @exception CourseNotFoundException 未找到课程
         */
        List<Course> ListCourseByUserId(BigInteger userId);


        /**
         * 按userId创建课程.
         * @author ZhouZhongjun
         * @param userId 用户Id
         * @param course 课程信息
         * @return courseId 新建课程的id
         * @exception InfoIllegalException userId格式错误时抛出
         */
        BigInteger InsertCourseByUserId(BigInteger userId, Course course);


        /**
         * 按courseId获取课程 .
         * @author ZhouZhongjun
         * @param courseId 课程Id
         * @return course
         * @exception InfoIllegalException courseId格式错误时抛出
         * @exception CourseNotFoundException 未找到课程
         */
        Course GetCourseByCourseId(BigInteger courseId);


        /**
         * 传入courseId和course信息修改course信息.
         * @author ZhouZhongjun
         * @param courseId 课程Id
         * @param course 课程信息
         * @return true修改成功  false修改失败
         */
        Boolean UpdateCourseByCourseId(BigInteger courseId, Course course);


        /**
         * 按courseId删除课程.
         * <p>先根据courseID删除Seminar 和 class,然后再将course的信息删除<br>  
         * @author ZhouZhongjun
         * @param courseId 课程Id
         * @see SeminarService #deleteSemiarByCourseId(BigInteger courseId)
         * @see ClassService   #deleteClassByCourseId(BigInteger courseId)
         * @return true删除成功  false删除失败
         * @exception InfoIllegalException courseId格式错误时抛出
         * @exception CourseNotFoundException 未找到课程
         */
        Boolean DeleteCourseByCourseId(BigInteger courseId);



        /**
         * 根据课程名称获取课程列表.
         * <p>根据课程名称获取课程列表<br>
         * @author YeXiaona
         * @param courseName 课程名称
         * @return list 课程列表
         * @see CourseService #getCourseByCourseId(BigInteger courseId)
         * @exception InfoIllegalException courseId格式错误时抛出
         * @exception CourseNotFoundException 未找到课程
         */
        List<Course> ListCourseByCourseName(String courseName);


        /**
         * 按课程名称获取班级列表.
         * <p>根据课程名获取课程ID，通过课程ID获取班级列表<br>
         * @author YeXiaona
         * @param courseName 课程名称
         * @return list 班级列表
         * @see CourseService #listCourseByCourseName(String courseName)
         * @see ClassService #listClassByCourseId(BigInteger courseId)
         * @exception InfoIllegalException courseId格式错误时抛出
         * @exception CourseNotFoundException 未找到课程
         * @exception ClassNotFoundException 未找到班级
         */
        List<ClassInfo> ListClassByCourseName(String courseName);


        /**
         * 按教师名称获取班级列表.
         * <p>根据教师名称获取课程ID，通过课程ID获取班级列表<br>
         * @author YeXiaona
         * @param teacherName 教师名称
         * @return list 班级列表
         * @see UserService #listUserIdByUserName(String userName)
         * @see CourseService #listClassByUserId(BigInteger userId)
         * @exception UserNotFoundException 未找到用户
         * @exception CourseNotFoundException 未找到课程
         * @exception ClassNotFoundException 未找到班级
         */
        List<ClassInfo> ListClassByTeacherName(String teacherName);


        /**
         * 根据教师ID获取班级列表.  
         * @author YeXiaona
         * @param userId 教师ID
         * @return list 班级列表
         * @see CourseService #listCourseByUserId(BigInteger userId)
         * @see ClassService #listClassByCourseId(BigInteger courseId)
         * @exception InfoIllegalException userId格式错误时抛出
         * @exception InfoIllegalException courseId格式错误时抛出
         * @exception CourseNotFoundException 未找到课程
         * @exception ClassNotFoundException 未找到班级
         */
        List<ClassInfo> ListClassByUserId(BigInteger userId);

    }
}
