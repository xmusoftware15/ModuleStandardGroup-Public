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
 * @author Huhui QinLingyun ZhouZhongjun
 * @version 2.00
 *
 */
    public interface GradeService
    {


        /**
         * 按topicId删除学生打分表.
         * @author zhouzhongjun
         * @param topicId 话题Id
         */
        void DeleteStudentScoreGroupByTopicId(long topicId);

        /**
         * 获取某学生所有讨论课的成绩.
         * <p>获取某学生所有讨论课的成绩<br>
         * @author qinlingyun
         * @param userId 学生id
         * @param seminarGroupId 讨论课小组id
         * @return list 讨论课分数列表
         * @see SeminarGroupService#listSeminarGroupIdByStudentId(BigInteger userId)
         */
        List<int> ListSeminarGradeBySeminarGroupId(long userId, long seminarGroupId);

        /**
         * 提交对其他小组的打分.
         * 
         * @author Huhui
         * @param userId 用户id
         * @param seminarId 讨论课Id
         * @param groupId 小组Id
         * @param grade 分数
         */
        void InsertGroupGradeByUserId(long userId, long seminarId, long groupId, int grade);

        /**
         * 按ID设置小组报告分.
         * 
         * @author Huhui
         * @param seminar_group_id 讨论课组id
         * @param grade 分数
         */
        void UpdateGroupByGroupId(long seminar_group_id, int grade);

        /**
         * 获取某学生的讨论课成绩列表.
         * @author qinlingyun
         * @param userId 用户id
         * @return list 讨论课成绩列表
         * @see SeminarGroupService#listSeminarGroupBySeminarId(BigInteger seminarId)
         */
        List<int> ListSeminarGradeByStudentId(long userId);
        


    }
}
