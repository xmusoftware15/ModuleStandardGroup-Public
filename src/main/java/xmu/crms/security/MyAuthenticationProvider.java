package xmu.crms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * 重写Spring Security的权限提供者
 * @author LiuXuezhang
 */
public class MyAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    /**
     * 权限认证
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MyAuthenticationToken myAuthenticationToken =
                (MyAuthenticationToken) authentication;
        UserDetails userDetails;
        if(myAuthenticationToken.getOpenid() == null) {
            // web端认证
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String username = myAuthenticationToken.getPhone();
            userDetails = userDetailsService.loadUserByUsername(username);
            if (!userDetails.getPassword().equals(myAuthenticationToken.getPassword())) {
                throw new BadCredentialsException("密码错误");
            }
        }else {
            //小程序端认证
            String openid = myAuthenticationToken.getOpenid();
            userDetails = userDetailsService.loadUserByOpenId(openid);
        }
        List<SimpleGrantedAuthority> simpleGrantedAuthority = (List<SimpleGrantedAuthority>) userDetails.getAuthorities();
        if (simpleGrantedAuthority == null) {
            throw new BadCredentialsException("没有权限");
        } else {
            Integer type = ((UserDetailsImpl) userDetails).getType();
            String typeString = "";
            if (type == 0) {
                typeString = "student";
            } else if (type == 1) {
                typeString = "teacher";
            }
            if(((UserDetailsImpl) userDetails).getOpenid() == null){
                return new MyAuthenticationToken(((UserDetailsImpl) userDetails).getId(),
                        ((UserDetailsImpl) userDetails).getNumber(),
                        ((UserDetailsImpl) userDetails).getPhone(),
                        myAuthenticationToken.getPassword(), typeString,
                        simpleGrantedAuthority);
            }else{
                return new MyAuthenticationToken(((UserDetailsImpl) userDetails).getOpenid(),
                        ((UserDetailsImpl) userDetails).getId(),
                        ((UserDetailsImpl) userDetails).getNumber(),
                        ((UserDetailsImpl) userDetails).getPhone()
                        , typeString,
                        simpleGrantedAuthority);
            }

        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (MyAuthenticationToken.class
            .isAssignableFrom(aClass));
    }
}
