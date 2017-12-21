using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Numerics;
using Xmu.Crms.Shared.Models;

namespace Xmu.Crms.Shared.Service
{
    /**
 * 定时器
 * 
 * @author qinlingyun liuaiqi
 * @version 2.00
 */
    public interface ITimerService
    {
        /**
         * 此部分待根据标准组设计的event实体进行修改
         * /
        //void insertEvent(Date time, Bean beanName, hashMap<Integer, String> paramMap);

        //需要设置定时器的方法：
        /**
		 * 讨论课结束后计算展示得分.
		 * <p>条件: 讨论课已结束<br>
		 * @author qinlingyun
		 */
        //void countPresentationGrade();


        /**
		 * 讨论课结束后计算本次讨论课得分.
		 * <p>条件: 讨论课已结束，展示得分已算出<br>
		 * @author qinlingyun
		 */
        //void countGroupGradeBySerminarId();		

        /**
		 * 课前将固定小组复制一份作为讨论课小组名单.
		 * <p>每天7点到21点 每半小时触发一次<br>
		 * <p>条件: 讨论课上课前<br>
		 * @author qinlingyun
		 */
        //void fixedGroupToSeminarGroup();

        /**
		 * 课堂结束后设置缺勤的名单.
		 * <p>点名结束后是迟到，此时学生仍可以签到，课程结束后则是缺勤<br>
		 * <p>条件: 课堂结束后<br>
		 * @author qinlingyun
		 */
        //void updateAbsentListByClassId();

        //应添加此方法到userService里,不需定时器
        /**
		 * 获取讨论课所在班级迟到学生名单.
		 * <p>获取讨论课所在班级迟到学生名单<br>
		 * @param seminarId 讨论课ID
		 * @param classId 班级ID
		 * @return list 处于迟到状态的学生列表
		 * @see UserService #listUserByClassId(BigInteger, String, String)
		 * @see UserService #listPresentStudent(BigInteger, BigInteger)
		 * @exception IllegalArgumentException throws when 信息不合法，id格式错误 
		 */
        //List<User> listLateStudent(BigInteger seminarId,BigInteger classId) throws IllegalArgumentException;

        /**
		 * 讨论课开始前随机分组  (此方法已有，自动分组).
		 * <p>条件: 讨论课开始前<br>
		 * @author qinlingyun
		 */
        //void automaticallyGrouping(BigInteger seminarId,BigInteger classId);





    }
}
