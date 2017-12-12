package xmu.crms.service;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import xmu.crms.bo.CourseBO;
import xmu.crms.bo.UserBO;


/**
 * 
 * @author ModuleStandardGroup
 * @version 1.00
 *
 */
public class CourseService {
	/**
	 * 按userId获取与当前用户相关联的课程列表.
	 * <p>老师与他相关联的课程列表<br> 
	 * @author zhouzhongjun
	 * @param userId 用户Id
	 * @return null 课程列表
	 */
	private List<CourseBO> listCourseByUserId(BigInteger userId) {
		return null;
	};	
	
	/**
	 * 按userId创建课程.
	 * @author zhouzhongjun
	 * @param userId 用户Id
	 * @param course 课程信息
	 * @return courseId 新建课程的id
	 */
	private  BigInteger insertCourseByUserId(BigInteger userId,CourseBO course) {
		
		BigInteger courseId = null;
		return  courseId;
	};	
	
	
	/**
	 * 按courseId获取课程 .
	 * @author zhouzhongjun
	 * @param courseId 课程Id
	 * @return course
	 */
	private  CourseBO getCourseByCourseId(BigInteger courseId) {
		
		CourseBO course=new CourseBO();
		return course;
		
	};	
	
	
	/**
	 * 传入courseId和course信息修改course信息.
	 * @author zhouzhongjun
     * @param courseId 课程Id
	 * @param course 课程信息
	 * @return true修改成功  false修改失败
	 */
	private boolean updateCourseByCourseId(BigInteger courseId,CourseBO course) {
		
		return true;
		
	};	
	
	/**
	 * 按courseId删除课程.
	 * <p>先根据courseID删除Seminar 和 class,然后再将course的信息删除<br>  
	 * @author zhouzhongjun
     * @param courseId 课程Id
	 *@see SeminarService #deleteSemiarByCourseId(BigInteger courseId)
	 *@see ClassService   #deleteClassByCourseId(BigInteger courseId)
	 *@return true删除成功  false删除失败
	 */
	boolean deleteCourseByCourseId(BigInteger courseId) {
		
		
		//删除自己
		return true;
	};
	

	
	/**
	 * 根据课程名称获取课程列表.
	 * <p>根据课程名称获取课程列表<br>
	 * @author yexiaona
	 * @param courseName 课程名称
	 * @return list 课程列表

	 * @see CourseService #listCourseByCourseName(String courseName)
	 * @see CourseService #getCourseByCourseId(BigInteger courseId)
	 */
	private List<CourseBO> listCourseByCourseName(String courseName)
	{
		List<CourseBO> list=new ArrayList<CourseBO>();
		return list;
	}
	
	/**
	 * 根据教师名称列出课程名称.
	 * <p>根据教师名称列出课程名称<br>
	 * @author yexiaona
	 * @param teacherName 教师名称
	 * @return list 课程列表
	 * @see UserService #listUserByUserName(String userName)
	 * @see CourseService #listCourseByUserId(BigInteger userId)
	 */
	private List<CourseBO> listCourseByTeacherName(String teacherName)
	{
		List<CourseBO> list=new ArrayList<CourseBO>();
		return list;
	}

}
