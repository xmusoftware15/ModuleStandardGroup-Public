using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Numerics;
using Xmu.Crms.Shared.Models;

namespace Xmu.Crms.Shared.Service
{
    public interface FixGroupService
    {
        /**
	 * 按班级Id添加固定分组.
	 * @author zhouzhongjun
     * @param classId 固定分组Id
     * @param userId 队长的Id
     * @return 若创建成功返回该条记录的id，失败则返回-1
     * @exception InfoIllegalException 信息不合法，id格式错误 
     * @exception classNotFoundException 未找到班级
	 */
        long InsertFixGroupByClassId(long classId, long userId);
        /**
	 * 按FixGroupId删除FixGroupMember.
	 * @author zhouzhongjun
	 * @param fixGroupId 固定分组Id
	 * @exception IllegalArgumentException 信息不合法，id格式错误
	 * @exception FixGroupNotFoundException 未找到小组
	 */
        void DeleteFixGroupMemberByFixGroupId(long fixGroupId);

        /**
	 * 将学生加入固定小组.
	 * ＜p＞将用户加入指定的固定小组<br>*
	 * @author YeHongjie
	 * @param userId 学生的id
	 * @param groupId 要加入固定小组的id
	 * @return BigInteger 若创建成功返回该条记录的id，失败则返回-1
	 * @exception IllegalArgumentException 信息不合法，id格式错误
	 * @exception FixGroupNotFoundException 未找到小组
	 * @exception UserNotFoundException 不存在该学生
	 * @exception InvalidOperationException 待添加学生已经在小组里了

	 */
        long InsertFixGroupMemberById(long userId, long groupId);

        /**
	 * 查询固定小组成员.
	 * ＜p＞按照固定小组id查询该小组的成员<br>*
	 * @author YeHongjie
	 * @param groupId 要查询的固定小组id
	 * @return List 固定小组成员信息
	 * @exception IllegalArgumentException 信息不合法，id格式错误
	 * @exception FixGroupNotFoundException 未找到小组
	 */
        List<UserInfo> ListFixGroupMemberByGroupId(long groupId);
        /**
	 * 按classId查找FixGroup信息.
	 * @author zhouzhongjun
	 * @param classId 班级Id
	 * @return null 固定分组列表
	 * @exception IllegalArgumentException 信息不合法，id格式错误
	 */
        List<FixGroup> ListFixGroupByClassId(long classId);

        /**
	 * 按classId删除FixGroup
	 * <p>先根据classId得到所有的FixGroup信息，再根据FixGroupid删除FixGroupMember表的信息，最后再将FixGroup信息删除<br>
	 * @author zhouzhongjun
	 * @param classId 班级Id
	 * @see FixGroupService #listFixGroupByClassId(BigInteger classId)
	 * @see FixGroupService #deleteFixGroupMemberByFixGroupId(BigInteger fixGroupId)
	 * @exception IllegalArgumentException 信息不合法，id格式错误
	 * @exception ClassNotFoundException 未找到班级
	 */
        void DeleteFixGroupByClassId(long classId);

        /**
	 * 删除固定小组.
	 * ＜p＞按照id删除固定小组<br>*
	 * @author YeHongjie
	 * @param groupId 固定小组的id
	 * @see FixGroupService #deleteFixGroupMemberByFixGroupId(BigInteger fixGroupId)
	 * @exception IllegalArgumentException  信息不合法，id格式错误
	 * @exception FixGroupNotFoundException 未找到小组
	 */
        void DeleteFixGroupByGroupId(long groupId);

        /**
	 * 修改固定小组.
	 * ＜p＞修改固定小组的信息（不包括成员）<br>*
	 * @author YeHongjie
	 * @param groupId 小组的id
	 * @param fixGroupBO 小组信息
	 * @exception IllegalArgumentException 信息不合法，id格式错误
	 * @exception FixGroupNotFoundException 未找到小组
	 */
        void UpdateFixGroupByGroupId(long groupId, FixGroup fixGroup);

        /**
	 * 查询固定小组.
	 * ＜p＞按照id查询某一固定小组的信息（包括成员）<br>*
	 * @author YeHongjie
	 * @param groupId 小组的id
	 * @return fixGroupBO 固定小组对象，若未找到相关小组返回空(null)
	 * @see FixGroupService #listFixGroupMemberByGroupId(BigInteger groupId)
	 * @exception IllegalArgumentException  信息不合法，id格式错误
	 * @exception FixGroupNotFoundException 未找到小组
	 */
        FixGroup GetFixGroupByGroupId(long groupId);


        /**
      * 将学生加入小组.
      * ＜p＞将用户加入指定的小组<br>*
      * @author YeHongjie
      * @param userId 学生的id
      * @param groupId 要加入小组的id
      * @return BigInteger 若创建成功返回该条记录的id，失败则返回-1
      * @exception FixGroupNotFoundException  信息不合法，id格式错误
      * @exception FixGroupNotFoundException 未找到小组
      * @exception UserNotFoundException 不存在该学生
      * @exception InvalidOperationException 待添加学生已经在小组里了
      */
        long InsertStudnetIntoGroup(long userId, long groupId);

        /**
	 * 小组取消话题.
	 * <p>小组按小组id取消讨论课的话题的选择<br>
	 * @author heqi
	 * @param groupId 小组id
	 * @exception IllegalArgumentException  信息不合法，id格式错误
	 * @exception FixGroupNotFoundException 未找到小组
	 */
        void DeleteTopicByGroupId(long groupId);

        /**
	 * 按id获取小组.
	 * <p>通过学生id和班级id获取学生所在的班级固定小组<br>
	 * @author heqi
	 * @param userId 学生id
	 * @param classId 班级id
	 * @return GroupBO 返回班级固定小组的信息
	 * @see UserService#getUserByUserId(BigInteger UserId)
	 * @exception IllegalArgumentException  信息不合法，id格式错误
	 * @exception ClassNotFoundException 未找到小组
	 * @exception UserNotFoundException 不存在该学生
	 */
        FixGroup GetFixedGroupById(long userId, long classId);

        /**
	 * 根据groupId修改group.
	 * <p>根据groupId修改group<br>
	 * @author aixing
	 * @param groupId 要修改的group的Id
	 * @param group 新的group信息
	 * @exception IllegalArgumentException  信息不合法，id格式错误
	 * @exception FixGroupNotFoundException 未找到小组
	 */
        void UpdateSeminarGroupById(long groupId, SeminarGroup group);

    }
}
