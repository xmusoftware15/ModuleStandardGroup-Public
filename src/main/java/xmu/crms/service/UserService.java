package xmu.crms.service;

import java.math.BigInteger;
import java.util.List;
import xmu.crms.entity.*;
import xmu.crms.exception.*;

/**
 * @author YeHongjie
 * @version 2.00
 */
public interface UserService {
	
	/**
	 * 添加学生签到信息.
	 * <p>根据班级id，讨论课id，学生id，经度，纬度进行签到，在方法中通过班级id，讨论课id获取当堂课发起签到的位置<br>
	 * @author LiuAiqi
	 * @param classId 班级的id
	 * @param seminarId 讨论课的id
	 * @param userId 学生的id
	 * @param longitude 经度
	 * @param latitude 纬度
	 * @return true（添加签到信息成功）/false（添加签到信息未成功）
	 * @exception InfoIllegalException 信息不合法，id格式错误 
	 * @exception ClassesNotFoundException 未找到班级
	 * @exception SeminarNotFoundException 未找到讨论课
	 */
	 Boolean insertAttendanceById(BigInteger classId, BigInteger seminarId, 
	        BigInteger userId, double longitude, double latitude) throws
	InfoIllegalException,ClassesNotFoundException,SeminarNotFoundException;
	
	/**
	 * 获取学生签到信息.
	 * <p>根据班级id，讨论课id获取当堂课签到信息<br>
	 * @author LiuAiqi
	 * @param classId 班级的id
	 * @param seminarId 讨论课id
	 * @return list 当堂课签到信息
	 * @exception InfoIllegalException 信息不合法，id格式错误
	 * @exception ClassesNotFoundException 未找到班级
	 * @exception SeminarNotFoundException 未找到讨论课
	 */
	 List<Attendance> listAttendanceById(BigInteger classId, BigInteger seminarId)
	        throws InfoIllegalException,ClassesNotFoundException,
	        SeminarNotFoundException;

	/**
	 * 手机号注册.
	 * <p>手机号注册 (.Net使用),User中只有phone和password，userId是注册后才有并且在数据库自增<br> 
	 * @author qinlingyun	 
	 * @param user 用户信息(手机号Phone和密码Password)
	 * @return user 该用户信息
	 */
	 User signUpPhone(User user);
	
	
	/**
	 * 用户解绑.
	 * <p>教师解绑账号<br>
	 * @author qinlingyun
	 * @param userId 用户id
	 * @return true 解绑成功 false 解绑失败
	 * @see CourseService#listCourseByUserId(BigInteger userId)
	 * @see CourseService#deleteCourseByCourseId(BigInteger courseId)
	 * @exception InfoIllegalException 信息不合法，id格式错误
	 * @exception UserNotFoundException 未找到对应用户
	 */
	 boolean deleteTeacherAccount(BigInteger userId) throws InfoIllegalException,
	        UserNotFoundException;
	
	
	/**
	 * 用户解绑.
	 * <p>学生解绑账号<br>
	 * @author qinlingyun 
	 * @param userId 用户id
	 * @return true 解绑成功 false 解绑失败
	 * @see ClassService#deleteCourseSelectionById(BigInteger userId,BigInteger classId)
	 * @exception InfoIllegalException 信息不合法，id格式错误
	 * @exception UserNotFoundException 未找到对应用户
	 */		
	 Boolean deleteStudentAccount(BigInteger userId) throws InfoIllegalException,
	        UserNotFoundException;
	
	
	/**
	 * 根据用户Id获取用户的信息.
	 * <p>根据用户Id获取用户的信息<br> 
	 * @author qinlingyun
	 * @param userId 用户Id
	 * @return user 用户信息
	 * @see SchoolService#getSchoolBySchoolId(BigInteger schoolId)
	 * @exception InfoIllegalException throws when 信息不合法，id格式错误 
	 * @exception UserNotFoundException throws when 未找到对应用户
	 */
	 User getUserByUserId(BigInteger userId) throws InfoIllegalException,
	        UserNotFoundException;

	/**
	 * 根据用户名获取用户ID.
	 * <p>根据用户名获取用户ID<br>
	 * @author qinlingyun
	 * @param userName 用户名
	 * @return userId 用户ID
	 * @exception InfoIllegalException throws when 信息不合法，id格式错误 
	 * @exception UserNotFoundException throws when 未找到对应用户
	 */
	 List<BigInteger> listUserIdByUserName(String userName)throws 
	        InfoIllegalException,UserNotFoundException;;
	
	/**
	 * 根据用户ID修改用户信息.
	 * <p>根据用户ID修改用户信息<br> 
	 * @author qinlingyun
	 * @param userId 用户Id
	 * @param user 用户信息
	 * @return list 用户id列表
	 * @exception UserNotFoundException throws when 未找到对应用户
	 */
	 Boolean updateUserByUserId(BigInteger userId, User user) throws
	        UserNotFoundException;
	

	/**
	 * 按班级ID、学号开头、姓名开头获取学生列表.
	 * <p>按班级ID、学号开头、姓名开头获取学生列表<br> 
	 * @author qinlingyun
	 * @param classId 班级ID
	 * @param numBeginWith 学号开头
	 * @param nameBeginWith 姓名开头
	 * @return list 用户列表
	 * @exception InfoIllegalException throws when 信息不合法
	 * @exception ClassesNotFoundException throws when 未找到对应班级
	 */	
	 List<User> listUserByClassId(BigInteger classId,String numBeginWith,
	           String nameBeginWith) throws InfoIllegalException,
	            ClassesNotFoundException;
	

	/**
	 * 根据用户名获取用户列表.
	 * <p>根据用户名获取用户列表<br> 
	 * @author qinlingyun
	 * @param userName 用户名
	 * @return list 用户列表
	 * @exception UserNotFoundException throws when 未找到对应用户
	 */	
	 List<User> listUserByUserName(String userName) throws UserNotFoundException;
	
	
	/**
	 * 获取讨论课所在的班级的出勤学生名单.
	 * <p>根据ID获取讨论课所在的班级的出勤学生名单<br>
	 * @author qinlingyun
	 * @param seminarId 讨论课ID
	 * @param classId 班级ID
	 * @return list 处于出勤状态的学生的列表
	 * @see UserService #listAttendanceById(BigInteger, BigInteger)
	 * @see UserService #getUserByUserId(BigInteger)
	 * @exception InfoIllegalException throws when 信息不合法，id格式错误 
	 */
	 List<User> listPresentStudent(BigInteger seminarId, BigInteger classId)
	        throws InfoIllegalException;


	/**
	 * 获取讨论课所在班级缺勤学生名单.
	 * <p>获取讨论课所在班级缺勤学生名单<br>
	 * @param seminarId 讨论课ID
	 * @param classId 班级ID
	 * @return list 处于缺勤状态的学生列表
	 * @see UserService #listUserByClassId(BigInteger, String, String)
	 * @see UserService #listPresentStudent(BigInteger, BigInteger)
	 * @exception InfoIllegalException throws when 信息不合法，id格式错误 
	 */
	 List<User> listAbsenceStudent(BigInteger seminarId,BigInteger classId) throws
	        InfoIllegalException;
	
	/**
	 * 根据教师名称列出课程名称.
	 * <p>根据教师名称列出课程名称<br>
	 * @author yexiaona
	 * @param teacherName 教师名称
	 * @return list 课程列表
	 * @see UserService #listUserByUserName(String userName)
	 * @see CourseService #listCourseByUserId(BigInteger userId)
	 */
	 List<Course> listCourseByTeacherName(String teacherName);
}
