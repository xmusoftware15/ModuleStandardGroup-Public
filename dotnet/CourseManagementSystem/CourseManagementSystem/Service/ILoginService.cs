using Xmu.Crms.Shared.Models;

namespace Xmu.Crms.Shared.Service
{
    /// <summary>
    /// @author ModuleStandardGroup/YeHongjie
    /// @version 2.00
    /// </summary>
    public interface ILoginService
    {
        /// <summary>
        /// 微信登录.
        /// @author qinlingyun
        /// </summary>
        /// <param name="userId">用户Id</param>
        /// <param name="code">微信小程序/OAuth2授权的Code</param>
        /// <param name="state">微信OAuth2授权的state。对于小程序，值恒为 MiniProgram</param>
        /// <param name="successUrl">微信OAuth2授权后跳转到的网址</param>
        /// <returns>user 该用户信息</returns>
        UserInfo SignInWeChat(long userId, string code, string state, string successUrl);


        /// <summary>
        /// 手机号登录.
        /// @author qinlingyun
        /// User中只有phone和password，用于判断用户名密码是否正确
        /// </summary>
        /// <param name="user">用户信息(手机号Phone和密码Password)</param>
        /// <returns>user 该用户信息</returns>
        UserInfo SignInPhone(UserInfo user);

        /// <summary>
        /// 手机号注册.
        /// @author qinlingyun
        /// 手机号注册 User中只有phone和password，userId是注册后才有并且在数据库自增
        /// </summary>
        /// <param name="user">用户信息(手机号Phone和密码Password)</param>
        /// <returns>user 该用户信息</returns>
        UserInfo SignUpPhone(UserInfo user);


        /// <summary>
        /// 用户解绑.教师解绑账号
        /// @author qinlingyun
        /// </summary>
        /// <param name="userId">用户id</param>
        /// <returns>true 解绑成功 false 解绑失败</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ICourseService.ListCourseByUserId(System.Int64)"/>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.ICourseService.DeleteCourseByCourseId(System.Int64)"/>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.UserNotFoundException">未找到对应用户</exception>
        bool DeleteTeacherAccount(long userId);


        /// <summary>
        /// 用户解绑.学生解绑账号
        /// @author qinlingyun
        /// </summary>
        /// <param name="userId">用户id</param>
        /// <returns>true 解绑成功 false 解绑失败</returns>
        /// <seealso cref="M:Xmu.Crms.Shared.Service.IClassService.DeleteCourseSelectionById(System.Int64,System.Int64)"/>
        /// <exception cref="T:System.ArgumentException">id格式错误</exception>
        /// <exception cref="T:Xmu.Crms.Shared.Exceptions.UserNotFoundException">未找到对应用户</exception>
        bool DeleteStudentAccount(long userId);
    }
}