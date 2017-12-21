using System.Collections.Generic;
using Xmu.Crms.Shared.Models;

namespace Xmu.Crms.Shared.Service
{
    /// <summary>
    /// @author Aixing ZhouZhongjun
    /// @version 2.00
    /// </summary>
    public interface ITopicService
    {
        /// <summary>
        /// 按topicId获取topic.
        /// @author aixing
        /// </summary>
        /// <param name="topicId">要获取的topic的topicId</param>
        /// <returns>该topic</returns>
        /// <exception cref="T:System.ArgumentException">Id格式错误时抛出</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.TopicNotFoundException">无此小组或Id错误</exception>
        Topic GetTopicByTopicId(long topicId);

        /// <summary>
        /// 根据topicId修改topic.
        /// @author aixing
        /// </summary>
        /// <param name="topicId">讨论课的ID</param>
        /// <param name="topic">修改后的讨论课</param>
        /// <exception cref="T:System.ArgumentException">Id格式错误时抛出</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.TopicNotFoundException">无此小组或Id错误</exception>
        void UpdateTopicByTopicId(long topicId, Topic topic);

        /// <summary>
        /// 删除topic.
        /// </summary>
        /// <param name="topicId">要删除的topic的topicId</param>
        /// <param name="seminarId">要删除topic所属seminar的id</param>
        /// 
        /// 删除topic还要把每个选了这个topic的小组的选题属性修改为null
        /// 想找到选了这个topic的小组，首先通过seminarId获得该讨论课所有小组，遍历判断是否选了这个topic
        /// SeminarGroupService sg=new SeminarGroupService();
        /// GroupService gs=new GroupService();
        /// List&lt;SeminarGroupBO&gt; groups=sg.listSeminarGroupBySeminarId(seminarId);
        /// List&lt;SeminarGroupBO&gt; topic_group=new ArrayList&lt;SeminarGroupBO&gt;();
        /// for g in groups
        /// if(选了此topic) topic_group.add(g);
        /// 修改topic_group的选题属性
        /// for g in topic_group{
        /// g.topic=null;
        /// gs.updateSeminarGroupById(g.id, g);}
        /// 删除讨论课
        /// 
        /// <exception cref="T:System.ArgumentException">Id格式错误时抛出</exception>
        void DeleteTopicByTopicId(long topicId, long seminarId);

        /// <summary>
        /// 按seminarId获取Topic.
        /// @author zhouzhongjun
        /// </summary>
        /// <param name="seminarId">课程Id</param>
        /// <returns>null</returns>
        /// <exception cref="T:System.ArgumentException">Id格式错误时抛出</exception>
        List<Topic> ListTopicBySeminarId(long seminarId);

        /// <summary>
        /// 根据讨论课Id和topic信息创建一个话题.
        /// @author aixing
        /// </summary>
        /// <param name="seminarId">话题所属讨论课的Id</param>
        /// <param name="topic">话题</param>
        /// <returns>新建话题后给topic分配的Id</returns>
        /// <exception cref="T:System.ArgumentException">Id格式错误时抛出</exception>
        long InsertTopicBySeminarId(long seminarId, Topic topic);

        /// <summary>
        /// 小组取消选择话题.
        /// @author zhouzhongjun
        /// 删除seminar_group_topic表的记录
        /// </summary>
        /// <param name="groupId">小组Id</param>
        /// <param name="topicId">话题Id</param>
        /// <exception cref="T:System.ArgumentException">groupId格式错误或topicId格式错误时抛出</exception>
        void DeleteTopicById(long groupId, long topicId);

        /// <summary>
        /// 按topicId删除SeminarGroupTopic表信息.
        /// @author zhouzhongjun
        /// </summary>
        /// <param name="topicId">讨论课Id</param>
        /// <exception cref="T:System.ArgumentException">topicId格式错误</exception>
        void DeleteSeminarGroupTopicByTopicId(long topicId);

        /// <summary>
        /// 按seminarId删除话题.
        /// @author zhouzhongjun
        /// 根据seminarId获得topic信息，然后再根据topic删除seninargrouptopic信息和StudentScoreGroup信息，最后再根据删除topic信息
        /// </summary>
        /// <param name="seminarId">讨论课Id</param>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ITopicService.ListTopicBySeminarId(System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ITopicService.DeleteSeminarGroupTopicByTopicId(System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IGradeService.DeleteStudentScoreGroupByTopicId(System.Int64)"/>
        /// <exception cref="T:System.ArgumentException">seminarId格式错误</exception>
        void DeleteTopicBySeminarId(long seminarId);
    }
}