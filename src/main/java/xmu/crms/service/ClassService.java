package xmu.crms.service;

import java.math.BigInteger;
import java.util.List;

import xmu.crms.entity.ClassInfo;
import xmu.crms.entity.Location;
import xmu.crms.entity.User;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.InvalidOperationException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.exception.UserNotFoundException;

/**
 * @author aixing
 * @version 2.20
 */
public interface ClassService {
    /**
     * 按classId删除CourseSelection表的一条记录 .
     *
     * @param classId 班级Id
     * @author zhouzhongjun
     */
    void deleteClassSelectionByClassId(BigInteger classId);

 
    /**
     * 根据课程ID获得班级列表.
     *
     * @param courseId 课程ID
     * @return list 班级列表
     * @throws CourseNotFoundException 无此课程Id
     * @author yexiaona
     */
    List<ClassInfo> listClassByCourseId(BigInteger courseId)
            throws CourseNotFoundException;

    /**
     * 按班级id获取班级详情.
     * <p>根据班级id获取班级<br>
     *
     * @param classId 班级ID
     * @return ClassBO 班级
     * @throws ClassesNotFoundException 无此班级Id
     * @author yexiaona
     */
    ClassInfo getClassByClassId(BigInteger classId)
            throws ClassesNotFoundException;

    /**
     * 按班级id和班级修改班级信息.
     * <p>
     * 根据班级id修改班级信息<br>
     *
     * @param classId  班级ID
     * @param newClass 修改后的班级
     * @throws ClassesNotFoundException 无此班级Id
     * @author yexiaona
     */
    void updateClassByClassId(BigInteger classId, ClassInfo newClass)
            throws ClassesNotFoundException;

    /**
     * 按班级id删除班级.
     * <p>
     * 根据班级id删除班级<br>
     *
     * @param classId 班级ID
     * @throws ClassesNotFoundException 无此班级Id
     * @author yexiaona
     * @see ClassService #deleteCourseSelectionById(BigInteger classId,User user)
     * @see FixGroupService #deleteFixGroupByClassId(BigInteger classId)
     * @see SeminarGroupService #deleteSeminarGroupByClaaId(BigInteger classId)
     */
    void deleteClassByClassId(BigInteger classId)
            throws ClassesNotFoundException;

    /**
     * 学生按班级id选择班级.
     * <p>
     * 根据班级id和用户id新增选课记录<br>
     *
     * @param userId  用户id
     * @param classId 班级id
     * @return courseSelectionId 选课记录id
     * @throws UserNotFoundException  无此姓名的教师
     * @throws ClassesNotFoundException 无此Id的班级
     * @author yexiaona
     */
    BigInteger insertCourseSelectionById(BigInteger userId, BigInteger classId) throws
            UserNotFoundException, ClassesNotFoundException;

    /**
     * 学生按班级id取消选择班级.
     * <p>
     * 根据班级id和用户id删除选课记录及与该班级相关的信息<br>
     *
     * @param userId  用户id
     * @param classId 班级id
     * @throws UserNotFoundException  无此姓名的教师
     * @throws ClassesNotFoundException 无此Id的班级
     * @author yexiaona
     */
    void deleteCourseSelectionById(BigInteger userId, BigInteger classId) throws
            UserNotFoundException, ClassesNotFoundException;

    /**
     * 老师获取该班级签到状态.
     * <p>
     * 根据讨论课id及班级id，获得老师所在位置经纬度和该班级的签到状态<br>
     *
     * @param classId   班级id
     * @param seminarId 讨论课id
     * @return location 该班级签到状态
     * @throws SeminarNotFoundException 无此Id的讨论课
     * @author yexiaona
     */
    Location getCallStatusById(BigInteger classId, BigInteger seminarId)
            throws SeminarNotFoundException;

    /**
     * 新建班级.
     * <p>
     * 根据课程id新建班级<br>
     *
     * @param courseId  课程id
     * @param classInfo 班级信息
     * @return classId 班级Id
     * @throws CourseNotFoundException 无此Id的课程
     * @author ixing
     */
    BigInteger insertClassById(BigInteger courseId, ClassInfo classInfo) throws
            CourseNotFoundException;

    /**
     * 按courseId删除Class.
     * <p>
     * 先根据CourseId获得所有的class的信息，然后根据class信息删除courseSelection表的记录，然后再根据courseId和classId删除ScoureRule表记录，再调用根据classId删除固定分组，最后再将班级的信息删除<br>
     *
     * @param courseId 课程Id
     * @throws CourseNotFoundException 无此Id的课程
     * @author zhouzhongjun
     * @see ClassService #listClassByCourseId(BigInteger courseId)
     * @see ClassService #deleteClasssSelectionByClassId(BigInteger classId)
     * @see FixGroupService #deleteFixGroupByClassId(BigInteger ClassId)
     */
    void deleteClassByCourseId(BigInteger courseId) throws
            CourseNotFoundException;

   
    /**
     * 老师发起签到.
     * <p>往location表插入一条当前讨论课班级的签到状态<br>
     * 
     * @param location 当前讨论课班级的签到状态记录
     * @return 返回location表的新记录的id
     * @throws SeminarNotFoundException 讨论课没有找到
     * @throws ClassesNotFoundException   无此Id的班级
     */
    BigInteger callInRollById(Location location)
            throws SeminarNotFoundException, ClassesNotFoundException;

    /**
     * 新增老师结束签到.
     * <p>老师结束签到,修改当前讨论课班级的签到状态为已结束<br>
     * 
     * @author qinlingyun
     * @param seminarId 讨论课Id
     * @param classId 班级Id
     * @throws SeminarNotFoundException 讨论课没有找到
     * @throws ClassesNotFoundException   无此Id的班级
     */
    void endCallRollById(BigInteger seminarId,BigInteger classId)
            throws SeminarNotFoundException, ClassesNotFoundException;
    
    
    
    /**
     * 根据学生ID获取班级列表.
     * <p>根据学生ID获取班级列表<br>
     *
     * @param userId 学生ID
     * @return list 班级列表
     * @throws IllegalArgumentException userId格式错误时抛出或courseId格式错误时抛出
     * @throws ClassesNotFoundException   未找到班级
     * @author YeXiaona
     * @see ClassService #getClassByClassId(BigInteger classId)
     */
    List<ClassInfo> listClassByUserId(BigInteger userId) throws IllegalArgumentException, ClassesNotFoundException;
}
