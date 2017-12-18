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
 * @author YeXiaona,ZhouZhongJun
 * @version 2.00
 *
 */
    public interface IClassService
    {
        /**
         * 按classId删除CourseSelection表的一条记录 .
         * 
         * @author zhouzhongjun
         * @param classId 班级Id
         * @return true/false 是否成功删除
         */

        
        void DeleteClassSelectionByClassId(long classId);

        /**
         * 按课程名称和教师名称获取班级列表.
         * <p>
         * 根据课程名和教师名获取课程ID，通过课程ID获取班级列表;若课程名和班级名均不为空，取交集<br>
         * 
         * @author yexiaona
         * @param courseName 课程名称
         * @param teacherName 教师名称
         * @return List 班级列表
         * @see ClassService #listClassByCourseName(String courseName)
         * @see ClassService #listClassByTeacherName(String teacherName)
         */
        List<ClassInfo> ListClassByName(string courseName, string teacherName);

        /**
         * 根据课程ID获得班级列表.
         * 
         * @author yexiaona
         * @param courseId 课程ID
         * @return list 班级列表
         */
        List<ClassInfo> ListClassByCourseId(long courseId);

        /**
         * 按班级id获取班级详情.
         * <p>
         * 根据班级id获取班级<br>
         * 
         * @author yexiaona
         * @param classId 班级ID
         * @return ClassBO 班级
         */
        ClassInfo GetClassByClassId(long classId);

        /**
         * 按班级id和班级修改班级信息.
         * <p>
         * 根据班级id修改班级信息<br>
         * 
         * @author yexiaona
         * @param classId 班级ID
         * @return boolean 班级修改是否成功情况
         * @see ScoreRuleService #updateScoreRuleById(long scoreRuleId)
         */
        bool UpdateClassByClassId(long classId);

        /**
         * 按班级id删除班级.
         * <p>
         * 根据班级id删除班级<br>
         * 
         * @author yexiaona
         * @param classId 班级ID
         * @return boolean 班级删除是否成功情况
         * @see ScoreRuleService #deleteScoreRuleById(long scoreRuleId)
         * @see ClassService #deleteCourseSelectionById(long classId,User user)
         * @see FixGroupService #deleteFixGroupByClassId(long classId)
         * @see SeminarGroupService #deleteSeminarGroupByClaaId(long classId)
         */
        bool DeleteClassByClassId(long classId);

        /**
         * 学生按班级id选择班级.
         * <p>
         * 根据班级id和用户id新增选课记录<br>
         * 
         * @author yexiaona
         * @param userId 用户id
         * @param classId 班级id
         * @return url 选课url
         */
        string InsertCourseSelectionById(long userId, long classId);

        /**
         * 学生按班级id取消选择班级.
         * <p>
         * 根据班级id和用户id删除选课记录及与该班级相关的信息<br>
         * 
         * @author yexiaona
         * @param userId 用户id
         * @param classId  班级id
         * @return boolean 取消班级是否成功
         */
        bool DeleteCourseSelectionById(long userId, long classId);

        /**
         * 老师获取该班级签到、分组状态.
         * <p>
         * 根据讨论课id及班级id，获得该班级的签到、分组状态<br>
         * 
         * @author yexiaona
         * @param seminarId  讨论课id
         * @return classBO 班级
         * @see SeminarGroupService #listSeminarGroupBySeminarId(long seminarId)
         */
        ClassInfo GetCallGroupStatusById(long seminarId);

        /**
         * 新建班级.
         * <p>
         * 根据教师id和课程id新建班级<br>
         * 
         * @author yexiaona
         * @param userId  教师id
         * @param courseId 课程id
         * @return classId 班级Id
         */
        long InsertClassById(long userId, long courseId);

        /**
         * 按courseId删除Class.
         * <p>
         * 先根据CourseId获得所有的class的信息，然后根据class信息删除courseSelection表的记录，然后再根据courseId和classId删除ScoureRule表记录，再调用根据classId删除固定分组，最后再将班级的信息删除<br>
         * 
         * @author zhouzhongjun
         * @param courseId 课程Id
         * @see ClassService #listClassByCourseId(long courseId)
         * @see ClassService #deleteClasssSelectionByClassId(long classId)
         * @see ScoreRuleService #deleteScoreRuleById(long CourseId,long ClassId)
         * @see FixGroupService #deleteFixGroupByClassId(long ClassId)
         * @return true删除成功 false删除失败
         */
        bool DeleteClassByCourseId(long courseId);

        /**
         * 按classId删除ScoreRule.
         * 
         * @author zhouzhongjun
         * @param classId 班级Id
         * @return true删除成功 false删除失败
         */
        bool DeleteScoreRuleById(long classId);

        /**
         * 查询评分规则.
         * <p>
         * 按id查询指定的评分规则<br>
         * 
         * @author YeHongjie
         * @param classId  班级id
         * @return ProportionBO 返回评分规则，若未找到对应评分规则返回空（null)
         */
        ClassInfo GetScoreRule(long classId);

        /**
         * 新增评分规则.
         * <p>
         * 新增评分规则<br>
         * 
         * @author YeHongjie
         * @param classId 班级Id
         * @param proportionsBO  评分规则
         * @return scoreRuleId 若创建成功则返回该评分规则的id，失败则返回-1
         */
        long InsertScoreRule(long classId, ClassInfo proportions);

        /**
         * 修改评分规则.
         * <p>
         * 修改指定的评分规则<br>
         * 
         * @author YeHongjie
         * @param classId 班级id
         * @param proportionsBO 评分规则
         * @return state 若修改成功则返回true，失败则返回false
         */
        bool UpdateScoreRule(long classId, ClassInfo proportions);

    }
}
