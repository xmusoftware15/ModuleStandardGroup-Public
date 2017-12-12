package xmu.crms.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import xmu.crms.bo.ClassBO;

/**
 * 
 * @author ModuleStandardGroup
 * @version 1.00
 *
 */
public class ClassService {
	/**
	 * 按classId删除CourseSelection表的一条记录 .
	 * @author zhouzhongjun
     * @param classId 班级Id
     * @return true/false 是否成功删除
	 */
	boolean deleteClassSelectionByClassId(BigInteger classId) {
		
		//删除自己
		return true;
	}
	/**
	 * 按课程名称和教师名称获取班级列表.
	 * <p>根据课程名和教师名获取课程ID，通过课程ID获取班级列表;若课程名和班级名均不为空，取交集<br>
	 * @author yexiaona
	 * @param courseName 课程名称
	 * @param teacherName 教师名称
	 * @return List 班级列表
	 * @see ClassService #listClassByCourseName(String courseName)
	 * @see ClassService #listClassByTeacherName(String teacherName)
	 */
	private List<ClassBO> listClassByName(String courseName,String teacherName)
	{
		List<ClassBO> list=new ArrayList<ClassBO>();
		return list;
	}
	
	/**
	 * 按课程名称获取班级列表.
	 * <p>根据课程名获取课程ID，通过课程ID获取班级列表<br>
	 * @author yexiaona
	 * @param courseName 课程名称
	 * @return list 班级列表
	 * @see CourseService #listCourseByCourseName(String courseName)
	 * @see ClassService #listClassByCourseId(BigInteger courseId)
	 */
	private List<ClassBO> listClassByCourseName(String courseName)
	{
		List<ClassBO> list=new ArrayList<ClassBO>();
		return list;
	}
	
	/**
	 * 按教师名称获取班级列表.
	 * <p>根据教师名称获取课程ID，通过课程ID获取班级列表<br>
	 * @author yexiaona
	 * @param teacherName 教师名称
	 * @return list 班级列表
	 * @see CourseService #listCourseByTeacherName(String teacherName)
	 * @see ClassService #listClassByCourseId(BigInteger courseId)
	 */
	private List<ClassBO> listClassByTeacherName(String teacherName)
	{
		List<ClassBO> list=new ArrayList<ClassBO>();
		return list;
	}
	
	/**
	 * 根据教师ID获取班级列表.
	 * @author yexiaona
	 * @param userId 教师ID
	 * @return list 班级列表
	 * @see CourseService #listCourseByUserId(BigInteger userId)
	 */
	private List<ClassBO> listClassByUserId(BigInteger userId)
	{
		List<ClassBO> list=new ArrayList<ClassBO>();
		return list;
	}
	
	/**
	 * 根据课程ID获得班级列表.
	 * @author yexiaona
	 * @param courseId 课程ID
	 * @return list 班级列表
	 */
	private List<ClassBO> listClassByCourseId(BigInteger courseId)
	{
		List<ClassBO> list=new ArrayList<ClassBO>();
		return list;
	}
	
	/**
	 * 按班级id获取班级详情.
	 * <p>根据班级id获取班级<br>
	 * @author yexiaona
	 * @param classId 班级ID
	 * @return ClassBO 班级
	 */
	private ClassBO getClassByClassId(BigInteger classId)
	{
		ClassBO classBo=new ClassBO();
		return classBo;
	}
	
	/**
	 * 按班级id和班级修改班级信息.
	 * <p>根据班级id修改班级信息<br>
	 * @author yexiaona
	 * @param classId 班级ID
	 * @return boolean 班级修改是否成功情况
	 * @see ScoreRuleService #updateScoreRuleById(BigInteger scoreRuleId)
	 */
	private boolean updateClassByClassId(BigInteger classId)
	{
		return true;
	}
	
	/**
	 * 按班级id删除班级.
	 * <p>根据班级id删除班级<br>
	 * @author yexiaona
	 * @param classId 班级ID
	 * @return boolean 班级删除是否成功情况
	 * @see ScoreRuleService #deleteScoreRuleById(BigInteger scoreRuleId)
	 * @see ClassService #deleteCourseSelectionById(BigInteger classId,User user)
	 * @see FixGroupService #deleteFixGroupByClassId(BigInteger classId)
	 * @see SeminarGroupService #deleteSeminarGroupByClaaId(BigInteger classId)
	 */
	private boolean deleteClassByClassId(BigInteger classId)
	{
		boolean isDeleted=true;
		return isDeleted;
	}
	
	/**
	 * 学生按班级id选择班级.
	 * <p>根据班级id和用户id新增选课记录<br>
	 * @author yexiaona
	 * @param userId 用户id
	 * @param classId 班级id
	 * @return url 选课url
	 */
	private String insertCourseSelectionById(BigInteger userId,BigInteger classId)
	{
		String url=new String();
		return url;
	}
	
	/**
	 * 学生按班级id取消选择班级.
	 * <p>根据班级id和用户id删除选课记录及与该班级相关的信息<br>
	 * @author yexiaona
	 * @param userId 用户id
	 * @param classId 班级id
	 * @return boolean 取消班级是否成功
	 */
	private boolean deleteCourseSelectionById(BigInteger userId,BigInteger classId)
	{
		boolean isDeleted=true;
		return isDeleted;
	}
	
	/**
	 * 老师获取该班级签到、分组状态.
	 * <p>根据讨论课id及班级id，获得该班级的签到、分组状态<br>
	 * @author yexiaona
	 * @param seminarId 讨论课id
	 * @return classBO 班级
	 * @see SeminarGroupService #listSeminarGroupBySeminarId(BigInteger seminarId)
	 */
	private ClassBO getCallGroupStatusById(BigInteger seminarId)
	{
		ClassBO classBO=new ClassBO();
		return classBO;
	}
	
	/**
	 * 新建班级.
	 * <p>根据教师id和课程id新建班级<br>
	 * @author yexiaona
	 * @param userId 教师id
	 * @param courseId 课程id
	 * @return classBO 班级
	 * @see ClassService #insertCourseSelectionById(BigInteger userId,BigInteger classId)
	 */
	private ClassBO insertClassById(BigInteger userId,BigInteger courseId)
	{
		ClassBO classBO=new ClassBO();
		return classBO;
	}
	
	/**
	 * 按courseId删除Class.
	 * <p>先根据CourseId获得所有的class的信息，然后根据class信息删除courseSelection表的记录，然后再根据courseId和classId删除ScoureRule表记录，再调用根据classId删除固定分组，最后再将班级的信息删除<br>  
	 * @author zhouzhongjun
     * @param courseId 课程Id
	 *@see ClassService  #listClassByCourseId(BigInteger courseId)
	 *@see ClassService   #deleteClasssSelectionByClassId(BigInteger classId)
	 *@see ScoreRuleService  #deleteScoreRuleById(BigInteger CourseId,BigInteger ClassId)
	 *@see FixGroupService  #deleteFixGroupByClassId(BigInteger ClassId)
	 *@return true删除成功 false删除失败
	 */
	boolean deleteClassByCourseId(BigInteger courseId) {
			
		//删除自己
		return true;
	};

}
