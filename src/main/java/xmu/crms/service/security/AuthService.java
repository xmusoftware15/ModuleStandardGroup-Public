package xmu.crms.service.security;

import xmu.crms.entity.User;

import java.io.IOException;
import java.util.Map;

/**
 * AuthService 把LoginService的部分方法拿过来了， 在这里实现，做了部分修改
 * LoginService就不用实现这里实现的方法了
 * @author LiuXuezhang
 * @date 2017/12/22 8:48
 */
public interface AuthService {
    /**
     * web端注册用户
     * @param userToAdd
     * @return
     */
    User register(User userToAdd);

    /**
     * Web端登陆
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 刷新jwt ， 暂时用不上， jwt过期时间为一周
     * @param oldToken
     * @return
     */
    String refresh(String oldToken);

    /**
     * 微信端小程序登录
     * @param code
     * @return
     * @throws IOException
     */
    Map<String, Object> weChatLogin(String code, Integer type) throws IOException;


}
