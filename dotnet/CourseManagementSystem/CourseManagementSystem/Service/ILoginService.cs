using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Numerics;
using Xmu.Crms.Shared.Models;

namespace Xmu.Crms.Shared.Service
{
    /**
 * @author ModuleStandardGroup/YeHongjie
 * @version 2.00
 */
    public interface LoginService
    {


        /**
         * 微信登录.
         * <p>微信登录<br> 
         * @author qinlingyun
         * @param userId 用户Id
         * @param code 微信小程序/OAuth2授权的Code
         * @param state 微信OAuth2授权的state。对于小程序，值恒为 MiniProgram
         * @param successUrl 微信OAuth2授权后跳转到的网址
         * @return user 该用户信息
         */
        UserInfo SignInWeChat(BigInteger userId, String code, String state, String successUrl);


        /**
         * 手机号登录.
         * <p>手机号登录 (.Net使用)<br>*User中只有phone和password，用于判断用户名密码是否正确<br>
         * @author qinlingyun 
         * @param user 用户信息(手机号Phone和密码Password)
         * @return user 该用户信息
         */
        UserInfo SignInPhone(UserInfo user);

    }
}
