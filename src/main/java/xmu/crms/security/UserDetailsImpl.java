package xmu.crms.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 实现 Spring Security的 UserDetail实体
 * 是Spring Security从数据库拿出的User 实体
 * @author LiuXuezhang
 */
public class UserDetailsImpl implements UserDetails,Serializable {

    private BigInteger id;
    private String openid;
    private String phone;
    private String password;
    private Integer type;
    private String number;
    private String name;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if(this.type == 0){
            authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
        } else if (this.type == 1){
            authorities.add(new SimpleGrantedAuthority("ROLE_TEACHER"));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserDetailsImpl{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
