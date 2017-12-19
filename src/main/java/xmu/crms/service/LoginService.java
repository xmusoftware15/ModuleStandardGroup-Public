package xmu.crms.service;

import java.math.BigInteger;

import xmu.crms.entity.*;
import xmu.crms.exception.*;

/**
 * @author ModuleStandardGroup/YeHongjie
 * @version 2.00
 */
public interface LoginService {
	
	/**
	 * 微信登录.
	 * <p>微信登录<br> 
	 * @author qinlingyun
	 * @param userId 用户Id
	 * @param code 微信小程序/OAuth2授权的Code
	 * @param state 微信OAuth2授权的state。对于小程序，值恒为 MiniProgram
	 * @param successUrl 微信OAuth2授权后跳转到的网址
	 * @return user 该用户信息
	 * @exception UserNotFoundException 登录失败时抛出
	 */
	 User signInWeChat(BigInteger userId,String code,String state,String successUrl) throws UserNotFoundException;
	
	
	/**
	 * 手机号登录.
	 * <p>手机号登录 (.Net使用),User中只有phone和password，用于判断用户名密码是否正确<br>
	 * @author qinlingyun 
	 * @param user 用户信息(手机号Phone和密码Password)
	 * @return user 该用户信息
	 * @exception UserNotFoundException 登录失败时抛出
	 */
	 User signInPhone(User user) throws UserNotFoundException;
}
