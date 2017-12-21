namespace Xmu.Crms.Shared.Service
{
    /// <summary>
    /// 定时器
    /// @author qinlingyun liuaiqi
    /// @version 2.00
    /// </summary>
    public interface ITimerService
    {
        /// <summary>
        /// 讨论课结束后计算展示得分.
        /// @author qinlingyun
        /// </summary>
        /// 
        /// 条件：讨论课结束
        void CountPresentationGrade();

        /// <summary>
        /// 课前将固定小组复制一份作为讨论课小组名单.
        /// @author qinlingyun
        /// </summary>
        /// 
        /// 条件：上课前
        void FixedGroupToSeminarGroup();
    }
}