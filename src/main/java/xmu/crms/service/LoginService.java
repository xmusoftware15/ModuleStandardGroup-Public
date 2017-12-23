package xmu.crms.service;

import java.math.BigInteger;

import xmu.crms.entity.*;
import xmu.crms.exception.*;

/**
 * @author Huhui AiXing
 * @version 2.20
 */
public interface LoginService {
	
	/**
	 * 微信登录.
	 * <p>微信登录<br> 
	 * @author qinlingyun
	 * @param userId 用户Id
	 * @param code 微信小程序/OAuth2授权的Code
	 * @param state 微信OAuth2授权的state。对于小程序，值恒为 MiniProgram
	 * @param successUrl 微信OAuth2授权后跳转到的网址
	 * @return user 该用户信息
	 * @exception UserNotFoundException 登录失败时抛出
	 */
	 User signInWeChat(BigInteger userId,String code,String state,String successUrl) throws UserNotFoundException;

	/**
	 * 微信登录后用户绑定.
	 * <p>User中只有phone和password，userId是注册后才有并且在数据库自增<br>
	 * @param user 用户信息
	 * @throws IllegalArgumentException user中信息有误
	 */
	 void signUpWeChat(User user) throws IllegalArgumentException;

	/**
	 * 手机号登录.
	 * <p>手机号登录 (.Net使用),User中只有phone和password，用于判断用户名密码是否正确<br>
	 * @author qinlingyun 
	 * @param user 用户信息(手机号Phone和密码Password)
	 * @return user 该用户信息
	 * @exception UserNotFoundException 登录失败时抛出
	 */
	 User signInPhone(User user) throws UserNotFoundException;
	
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
	 * <p>教师解绑账号(j2ee使用)<br>
	 * @author qinlingyun
	 * @param userId 用户id
	 * @see CourseService#listCourseByUserId(BigInteger userId)
	 * @see CourseService#deleteCourseByCourseId(BigInteger courseId)
	 * @exception IllegalArgumentException 信息不合法，id格式错误
	 * @exception UserNotFoundException 未找到对应用户
	 */
	void deleteTeacherAccount(BigInteger userId) throws IllegalArgumentException,
			UserNotFoundException;
	
	 /**
	 * 用户解绑.
	 * <p>学生解绑账号(j2ee使用)<br>
	 * @author qinlingyun
	 * @param userId 用户id
	 * @see ClassService#deleteCourseSelectionById(BigInteger userId,BigInteger classId)
	 * @exception IllegalArgumentException 信息不合法，id格式错误
	 * @exception UserNotFoundException 未找到对应用户
	 */
	void deleteStudentAccount(BigInteger userId) throws IllegalArgumentException,
			UserNotFoundException;
	
	
}
