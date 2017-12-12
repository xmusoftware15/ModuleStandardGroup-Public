package xmu.crms.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import xmu.crms.bo.*;


/**
 * @author ModuleStandardGroup
 * @version 1.00
 */

public class TopicService {
	
	/**
	 * 按topicId获取topic.
	 * <p>按topicId获取topic<br>
	 * @author aixing
	 * @param topicId 要获取的topic的topicId
	 * @return 该topic
	 */
    TopicBO getTopicByTopicId(BigInteger topicId){
        TopicBO topic = null;
        //topic=TopicDao.getTopicByTopicId(BigInteger topicId);
        return topic;
    }
    
    /**
     * 根据topicId修改topic.
     * <p>根据topicId修改topic<br>
     * @author aixing
     * @param topicId 讨论课的ID
     * @param topic 修改后的讨论课
     * @return 是否修改成功
     */
    boolean updateTopicByTopicId(BigInteger topicId,TopicBO topic){
        //更改讨论课信息
        return true; 
    }
    
    /**
     * 删除topic.
     * <p>删除topic<br>
     * @param topicId 要删除的topic的topicId
     * @param seminarId 要删除topic所属seminar的id
     * @return 是否成功
     */
    boolean deleteTopicByTopicId(BigInteger topicId,BigInteger seminarId){
        //删除topic还要把每个选了这个topic的小组的选题属性修改为null
        //想找到选了这个topic的小组，首先通过seminarId获得该讨论课所有小组，遍历判断是否选了这个topic
        SeminarGroupService sg=new SeminarGroupService();
        //GroupService gs=new GroupService();
        List<SeminarGroupBO> groups=sg.listSeminarGroupBySeminarId(seminarId);
        List<SeminarGroupBO> topic_group=new ArrayList<SeminarGroupBO>();
        //for g in groups
            //if(选了此topic) topic_group.add(g);
        //修改topic_group的选题属性
        //for g in topic_group{
            //g.topic=null;
            //gs.updateSeminarGroupById(g.id, g);}
        //删除讨论课
        return true;
    }
    
	/**
	 * 按seminarId获取Topic.
	 * <p>按seminarId获取Topic<br>  
	 * @author zhouzhongjun
     * @param seminarId 课程Id
     * @return null
	 */
	List<TopicBO> listTopicBySeminarId(BigInteger seminarId) {
			
		return null;
	};
	
	/**
	 * 根据讨论课Id和topic信息创建一个话题.
	 * <p>根据讨论课Id和topic信息创建一个话题<br>
	 * @author aixing
	 * @param seminarId 话题所属讨论课的Id
	 * @param topic 话题
	 * @return 新建话题后给topic分配的Id
	 */
	BigInteger insertTopicBySeminarId(BigInteger seminarId,TopicBO topic){
	    BigInteger bi=null;
	    return bi;
	}
	
	/**
	 * 小组取消选择话题.
	 * <p>小组取消选择话题  <br> 
	 * <p>删除seminar_group_topic表的记录<br>
	 * @author zhouzhongjun
     * @param groupId 小组Id
     * @param topicId 话题Id
	 * @return true删除成功 false删除失败
	 */
	private boolean deleteTopicById(BigInteger groupId,BigInteger topicId)  {
		
		//删除自己
		return true;
		
	};	
	/**
	 * 按topicId删除SeminarGroupTopic表信息.
	 * @author zhouzhongjun
     * @param topicId 讨论课Id
	 * @return true删除成功 false删除失败
	 */
	boolean deleteSeminarGroupTopicByTopicId(BigInteger topicId) {
		
		
		//删除自己
		return true;
	};
	
	
	/**
	 * 按seminarId删除话题.
	 * <p>根据seminarId获得topic信息，然后再根据topic删除seninargrouptopic信息和StudentScoreGroup信息，最后再根据删除topic信息
	 * @author zhouzhongjun
     * @param seminarId 讨论课Id
	 *@see TopicService #listTopicBySeminarId(BigInteger seminarId)
	 *@see TopicService #deleteSeminarGroupTopicByTopicId(BigInteger topicId)
	 *@see GradeService   #deleteStudentScoreGroupByTopicId(BigInteger topicId)
	 * @return true删除成功 false删除失败
	 */
	boolean deleteTopicBySeminarId(BigInteger seminarId) {
		
		
		//删除自己
		return true;
	};
	
}
