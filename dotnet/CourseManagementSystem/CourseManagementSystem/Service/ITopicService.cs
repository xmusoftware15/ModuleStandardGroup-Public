using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Numerics;
using Xmu.Crms.Shared.Models;

namespace Xmu.Crms.Shared.Service
{
    /**
 * @author Aixing ZhouZhongjun
 * @version 2.00
 */
    public interface TopicService
    {


        /**
         * 按topicId获取topic.
         * <p>按topicId获取topic<br>
         * @author aixing
         * @param topicId 要获取的topic的topicId
         * @return 该topic
         * @exception TopicNotFoundException 无此小组或Id错误
         * @exception InfoIllegalException Id格式错误时抛出
         */
        Topic GetTopicByTopicId(BigInteger topicId);

        /**
         * 根据topicId修改topic.
         * <p>根据topicId修改topic<br>
         * @author aixing
         * @param topicId 讨论课的ID
         * @param topic 修改后的讨论课
         * @return 是否修改成功
         * @exception TopicNotFoundException 无此小组或Id错误
         * @exception InfoIllegalException Id格式错误或topic格式错误时抛出
         */
        Boolean UpdateTopicByTopicId(BigInteger topicId, Topic topic);

        /**
         * 删除topic.
         * <p>删除topic<br>
         * @param topicId 要删除的topic的topicId
         * @param seminarId 要删除topic所属seminar的id
         * @return 是否成功
         * @exception InfoIllegalException Id格式错误时抛出
         */
        Boolean DeleteTopicByTopicId(BigInteger topicId, BigInteger seminarId);
        //删除topic还要把每个选了这个topic的小组的选题属性修改为null
        //想找到选了这个topic的小组，首先通过seminarId获得该讨论课所有小组，遍历判断是否选了这个topic
        //SeminarGroupService sg=new SeminarGroupService();
        //GroupService gs=new GroupService();
        //List<SeminarGroupBO> groups=sg.listSeminarGroupBySeminarId(seminarId);
        // List<SeminarGroupBO> topic_group=new ArrayList<SeminarGroupBO>();
        //for g in groups
        //if(选了此topic) topic_group.add(g);
        //修改topic_group的选题属性
        //for g in topic_group{
        //g.topic=null;
        //gs.updateSeminarGroupById(g.id, g);}
        //删除讨论课



        /**
         * 按seminarId获取Topic.
         * <p>按seminarId获取Topic<br>  
         * @author zhouzhongjun
         * @param seminarId 课程Id
         * @return null
         * @exception InfoIllegalException Id格式错误时抛出
         */
        List<Topic> ListTopicBySeminarId(BigInteger seminarId);

        /**
         * 根据讨论课Id和topic信息创建一个话题.
         * <p>根据讨论课Id和topic信息创建一个话题<br>
         * @author aixing
         * @param seminarId 话题所属讨论课的Id
         * @param topic 话题
         * @return 新建话题后给topic分配的Id
         * @exception InfoIllegalException Id格式错误或topic格式错误时抛出
         */
        BigInteger InsertTopicBySeminarId(BigInteger seminarId, Topic topic);

        /**
         * 小组取消选择话题.
         * <p>小组取消选择话题  <br> 
         * <p>删除seminar_group_topic表的记录<br>
         * @author zhouzhongjun
         * @param groupId 小组Id
         * @param topicId 话题Id
         * @return true删除成功 false删除失败
         * @exception InfoIllegalException groupId格式错误或topicId格式错误时抛出
         */
        Boolean DeleteTopicById(BigInteger groupId, BigInteger topicId);
        /**
         * 按topicId删除SeminarGroupTopic表信息.
         * @author zhouzhongjun
         * @param topicId 讨论课Id
         * @return true删除成功 false删除失败
         * @exception InfoIllegalException topicId格式错误
         */
        Boolean DeleteSeminarGroupTopicByTopicId(BigInteger topicId);


        /**
         * 按seminarId删除话题.
         * <p>根据seminarId获得topic信息，然后再根据topic删除seninargrouptopic信息和StudentScoreGroup信息，最后再根据删除topic信息
         * @author zhouzhongjun
         * @param seminarId 讨论课Id
         *@see TopicService #listTopicBySeminarId(BigInteger seminarId)
         *@see TopicService #deleteSeminarGroupTopicByTopicId(BigInteger topicId)
         *@see GradeService   #deleteStudentScoreGroupByTopicId(BigInteger topicId)
         * @return true删除成功 false删除失败
         * @exception InfoIllegalException seminarId格式错误
         */
        Boolean DeleteTopicBySeminarId(BigInteger seminarId);


    }
}
