package xmu.crms.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import javax.security.auth.Subject;
import java.math.BigInteger;
import java.util.Collection;

/**
 * 从前端接受过来的验证token， 传来的只有用户名或密码， 微信传来的是code
 * 验证过后的包括一些角色信息，如 type
 * @author LiuXuezhang
 * @date
 */
public class MyAuthenticationToken extends AbstractAuthenticationToken {
    private BigInteger id;
    private String openid;
    private String number;
    private String phone;
    private String password;
    private String type;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * web认证之前的构造函数
     * @param phone
     * @param password
     */
    public MyAuthenticationToken(String phone, String password) {
        super(null);
        this.id=null;
        this.phone = phone;
        this.password = password;
        this.type = null;
        super.setAuthenticated(false);
    }

    /**
     * web认证之后，带一个type 用户角色分配
     * @param id
     * @param number
     * @param phone
     * @param password
     * @param type
     * @param authorities
     */
    public MyAuthenticationToken(BigInteger id, String number, String phone, String password, String type, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.openid = null;
        this.id = id;
        this.number = number;
        this.phone = phone;
        this.password = password;
        this.type = type;
        super.setAuthenticated(true);
    }

    /**
     * 小程序认证之前的构造函数
     * @param openid
     * @param type
     */
    public MyAuthenticationToken(String openid, Integer type){
        super(null);
        this.id = null;
        this.openid = openid;
        this.phone = null;
        this.password = null;
        this.type = (type==0?"student":"teacher" );
        super.setAuthenticated(false);
    }

    /**
     * 小程序认证之后
     * @param openid
     * @param id
     * @param number
     * @param phone
     * @param type
     * @param authorities
     */
    public MyAuthenticationToken(String openid, BigInteger id, String number, String phone, String type, Collection<? extends GrantedAuthority> authorities){
        super(authorities);
        this.password = null;
        this.openid = openid;
        this.id = id;
        this.number = number;
        this.phone = phone;
        this.type = type;
    }
    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.id;
    }
}
