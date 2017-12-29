package xmu.crms.dao;

import xmu.crms.entity.User;

/**
 * @author LiuXuezhang
 * @date 2017/12/28 20:50
 */
public interface LoginDao {

    /**
     * 小程序登录验证用
     * 通过openid拿用户
     * @param openid
     * @return
     */
    User getUserByOpenId(String openid);

    /**
     * 通过手机号注册用户
     * @param user
     * @return
     */
    User signUpPhone(User user);
}
