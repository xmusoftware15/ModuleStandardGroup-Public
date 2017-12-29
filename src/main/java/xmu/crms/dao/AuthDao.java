package xmu.crms.dao;

import org.apache.ibatis.annotations.Param;
import xmu.crms.security.UserDetailsImpl;

/**
 * @author mads
 * @date 2017/12/28 20:15
 */
public interface AuthDao {
    /**
     * 根据手机号找用户
     * @param phone
     * @return
     */
    UserDetailsImpl getUserByNumber(@Param("phone") String phone);

    /**
     * 根据openid登录用
     * @param openid
     * @return
     */
    UserDetailsImpl getUserByOpenId(@Param("openid") String openid);
}
