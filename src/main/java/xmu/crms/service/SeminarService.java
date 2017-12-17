package xmu.crms.service;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import xmu.crms.entity.*;
import xmu.crms.exception.*;

/**
 * 
 * @author zhouzhongjun CaoXingmei YeHongjie
 * @version 2.00
 *
 */
public interface SeminarService {
	
	/**
	 * 按courseId获取Seminar.
	 * @author zhouzhongjun
     * @param courseId 课程Id
     * @return List 讨论课列表
     * @exception InfoIllegalException CourseId 格式错误、教师设置embedGrade为true时抛出
     * @exception CourseNotFoundException 未找到该课程时抛出
	 */
	 List<Seminar> listSeminarByCourseId(BigInteger courseId)
	        throws InfoIllegalException,CourseNotFoundException;
	
	
	/**
	 * 按courseId删除Seminar.
	 * <p>先根据CourseId获得所有的seminar的信息，然后根据seminar信息删除相关topic的记录，然后再根据SeminarId删除SeminarGroup表记录,最后再将seminar的信息删除<br>  
	 * @author zhouzhongjun
     * @param courseId 课程Id
	 * @see SeminarService #listSemiarByCourseId(BigInteger courseId)
	 * @see TopicService   #deleteTopicBySeminarId(BigInteger seminarId)
	 * @see SeminarGroupService  #deleteSeminarGroupBySeminarId(BigInteger seminarId)
	 * @return true删除成功 false删除失败
	 * @exception InfoIllegalException CourseId 格式错误时抛出
	 * @exception CourseNotFoundException 该课程不存在时抛出
	 */
	 Boolean deleteSeminarByCourseId(BigInteger courseId) throws InfoIllegalException,
	        CourseNotFoundException; 
		

	/**
	 * 获得学生当前讨论课信息(小程序端获得讨论课信息进行选题分组、签到等).
	 * <p>通过学生用户id和讨论课id获得学生当前的讨论课信息<br>(此学生是否是队长，当前讨论课是否处于签到状态，当前讨论课是否可以选题，当前讨论课的组队方式).
	 * @author CaoXingmei
	 * @param seminarId 讨论课的id
	 * @param userId 用户的id
	 * @return 当前讨论课的信息
	 * @see SeminarGroupService #getSeminarGroupById(BigInteger userId, BigInteger seminarId)
	 * @exception InfoIllegalException  格式错误时抛出
	 * @exception SeminarNotFoundException 该讨论课不存在时抛出
	 */
	 Seminar getMySeminarBySeminarId(BigInteger seminarId,BigInteger userId) throws 
	        InfoIllegalException,SeminarNotFoundException;
	
	
	/**
	 * 获得学生相关的某个讨论课的信息.
	 * ＜p＞通过学生用户id和讨论课id获得学生某个讨论课的详细信息<br>(包括讨论课信息，教师信息).
	 * @author CaoXingmei
	 * @param seminarId 讨论课的id
	 * @param userId 学生的id
	 * @return 相应的讨论课的详细信息
	 * @exception InfoIllegalException SeminarId 格式错误时抛出
	 * @exception SeminarNotFoundException 该讨论课不存在时抛出
	 */
	 Seminar getSeminarDetailBySeminarId(BigInteger seminarId,BigInteger userId)
	        throws InfoIllegalException,SeminarNotFoundException;
	
	
	/**
	 * 用户通过讨论课id获得讨论课的信息.
	 * <p>用户通过讨论课id获得讨论课的信息（包括讨论课名称、讨论课描述、分组方式、开始时间、结束时间）<br>
	 * @author CaoXingmei
	 * @param seminarId 讨论课的id
	 * @return 相应的讨论课信息
	 * @exception InfoIllegalException SeminarId 格式错误时抛出
	 * @exception SeminarNotFoundException 该讨论课不存在时抛出
	 */
	 Seminar getSeminarBySeminarId(BigInteger seminarId) throws
	        InfoIllegalException,SeminarNotFoundException;
	
	
	/**
	 * 按讨论课id修改讨论课.
	 * <p>用户（老师）通过seminarId修改讨论课的相关信息<br>
	 * @author CaoXingmei
	 * @param seminarId 讨论课的id
	 * @param seminar 讨论课信息
	 * @return true(修改成功), false(修改失败)
	 * @exception InfoIllegalException SeminarId 格式错误时抛出
	 * @exception SeminarNotFoundException 该讨论课不存在时抛出
	 */
	 Boolean updateSeminarBySeminarId(BigInteger seminarId, Seminar seminar) throws
	        InfoIllegalException,SeminarNotFoundException;
	
	
	/**
	 * 按讨论课id删除讨论课.
	 * <p>用户（老师）通过seminarId删除讨论课<br>(包括删除讨论课包含的topic信息和小组信息).
	 * @author CaoXingmei
	 * @param seminarId 讨论课的id
	 * @return true(删除成功), false(删除失败)
	 * @see SeminarGroupService #deleteSeminarGroupBySeminarId(BigInteger seminarId)
	 * @see TopicService#deleteTopicBySeminarId(BigInteger seminarId)
	 * @exception InfoIllegalException SeminarId 格式错误时抛出
	 * @exception SeminarNotFoundException 该讨论课不存在时抛出
	 */
	 Boolean deleteSeminarBySeminarId(BigInteger seminarId) throws
	        InfoIllegalException,SeminarNotFoundException;
	
	
	/**
	 * 新增讨论课.
	 * <p>用户（老师）在指定的课程下创建讨论课<br>
	 * @author YeHongjie
	 * @param courseId 课程的id
	 * @param seminar 讨论课信息
	 * @return seminarId 若创建成功返回创建的讨论课id，失败则返回-1
	 * @exception InfoIllegalException CourseId 格式错误时抛出
	 * @exception CourseNotFoundException 该课程不存在时抛出
	 */
	 BigInteger insertSeminarByCourseId(BigInteger courseId, Seminar seminar) throws
	        InfoIllegalException,CourseNotFoundException;
    
}
