package xmu.crms.service;

import java.math.BigInteger;
import java.util.List;

import xmu.crms.entity.*;
import xmu.crms.exception.*;


/**
 * @author Yexiaona
 * @version 2.20
 */

public interface TopicService {

    /**
     * 按topicId获取topic.
     * <p>按topicId获取topic<br>
     *
     * @param topicId 要获取的topic的topicId
     * @return 该topic
     * @throws TopicNotFoundException   无此小组或Id错误
     * @throws IllegalArgumentException Id格式错误时抛出
     * @author aixing
     */
    Topic getTopicByTopicId(BigInteger topicId) throws TopicNotFoundException, IllegalArgumentException;

    /**
     * 根据topicId修改topic.
     * <p>根据topicId修改topic<br>
     *
     * @param topicId 讨论课的ID
     * @param topic   修改后的讨论课
     * @throws TopicNotFoundException   无此小组或Id错误
     * @throws IllegalArgumentException Id格式错误或topic格式错误时抛出
     * @author aixing
     */
    void updateTopicByTopicId(BigInteger topicId, Topic topic) throws TopicNotFoundException, IllegalArgumentException;

    /**
     * 删除topic.
     * <p>删除topic表中相应讨论课的topic<br>
     *
     * @param topicId 要删除的topic的topicId
     * @throws IllegalArgumentException Id格式错误时抛出
     * @exception TopicNotFoundException 未找到该话题
     */
    void deleteTopicByTopicId(BigInteger topicId) throws IllegalArgumentException,TopicNotFoundException;


    /**
     * 按seminarId获取Topic.
     * <p>按seminarId获取Topic<br>
     *
     * @param seminarId 课程Id
     * @return null
     * @throws IllegalArgumentException Id格式错误时抛出
     * @author zhouzhongjun
     */
    List<Topic> listTopicBySeminarId(BigInteger seminarId) throws IllegalArgumentException;

    /**
     * 根据讨论课Id和topic信息创建一个话题.
     * <p>根据讨论课Id和topic信息创建一个话题<br>
     *
     * @param seminarId 话题所属讨论课的Id
     * @param topic     话题
     * @return 新建话题后给topic分配的Id
     * @throws IllegalArgumentException Id格式错误或topic格式错误时抛出
     * @author aixing
     */
    BigInteger insertTopicBySeminarId(BigInteger seminarId, Topic topic) throws IllegalArgumentException;

    /**
     * 小组取消选择话题.
     * <p>小组取消选择话题  <br>
     * <p>删除seminar_group_topic表的一条记录<br>
     *
     * @param groupId 小组Id
     * @param topicId 话题Id
     * @throws IllegalArgumentException groupId格式错误或topicId格式错误时抛出
     * @author zhouzhongjun
     */
    void deleteSeminarGroupTopicById(BigInteger groupId, BigInteger topicId) throws IllegalArgumentException;

    /**
     * 按topicId删除SeminarGroupTopic表信息.
     * <p>删除seminar_group_topic表中选择了某个话题的全部记录<br>
     *
     * @param topicId 讨论课Id
     * @throws IllegalArgumentException topicId格式错误
     * @author zhouzhongjun
     */
    void deleteSeminarGroupTopicByTopicId(BigInteger topicId) throws IllegalArgumentException;

    /**
     * 按话题id和小组id获取讨论课小组选题信息（包括该小组该话题展示成绩）
     * <p>按话题id和小组id获取讨论课小组选题信息（包括该小组该话题展示成绩）<br>
     * @param topicId 话题id
     * @param groupId 组id
     * @return seminarGroupTopic 讨论课小组选题信息
     * @exception IllegalArgumentException topicId或groupId格式错误
     */
    SeminarGroupTopic getSeminarGroupTopicById(BigInteger topicId, BigInteger groupId) throws IllegalArgumentException;

    /**
     * 根据小组id获取该小组该堂讨论课所有选题信息
     * <p>根据小组id获取该小组该堂讨论课所有选题信息<br>
     * @param groupId
     * @return list 该小组该堂讨论课选题列表
     * @exception IllegalArgumentException groupId格式错误
     */
    List<SeminarGroupTopic> listSeminarGroupTopicByGroupId(BigInteger groupId) throws IllegalArgumentException;


    /**
     * 按seminarId删除话题.
     * <p>删除某讨论课下的所有Topic<br>
     * <p>根据seminarId获得topic信息，然后再根据topic删除seninargrouptopic信息和根据seminarGroupTopicId删除StudentScoreGroup信息，最后再根据删除topic信息<br>
     *
     * @param seminarId 讨论课Id
     * @throws IllegalArgumentException seminarId格式错误
     * @author zhouzhongjun
     * @see TopicService #listTopicBySeminarId(BigInteger seminarId)
     * @see TopicService #deleteSeminarGroupTopicByTopicId(BigInteger topicId)
     * @see GradeService   #deleteStudentScoreGroupByTopicId(BigInteger seminarGroupTopicId)
     */
    void deleteTopicBySeminarId(BigInteger seminarId) throws IllegalArgumentException;

}
