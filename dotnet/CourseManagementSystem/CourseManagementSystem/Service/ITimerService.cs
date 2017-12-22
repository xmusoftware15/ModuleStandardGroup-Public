using System;

namespace Xmu.Crms.Shared.Service
{
    /// <summary>
    /// 定时器
    /// @author qinlingyun liuaiqi
    /// @version 2.00
    /// </summary>
    public interface ITimerService
    {
        ///<summary>
        ///向Event表插入数据.
        ///@author qinlingyun
        /// </summary>
        /// <param name="Time">事件的时间</param>
        /// <param name="Bean">方法名称</param>
        /// <param name="Parameter">方法参数</param>
        /// 
        void InsertEvent(DateTime Time, string Bean, string Parameter);

        ///<summary>
        ///每十分钟检查一次Event实体的状况
        ///@author qinlingyun
        /// </summary>
        void Scheduled();
    }
}