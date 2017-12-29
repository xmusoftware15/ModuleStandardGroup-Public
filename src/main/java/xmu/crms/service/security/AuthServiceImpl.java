package xmu.crms.service.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import xmu.crms.dao.AuthDao;
import xmu.crms.dao.LoginDao;
import xmu.crms.security.MyAuthenticationProvider;
import xmu.crms.security.MyAuthenticationToken;
import xmu.crms.entity.User;
import xmu.crms.security.UserDetailsServiceImpl;
import xmu.crms.util.JwtTokenUtil;
import xmu.crms.util.MD5Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * LoginService 基于Spring Security的实现
 * @author LiuXuezhang
 * @date 2017/12/22 8:49
 */

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    MyAuthenticationProvider myAuthenticationProvider;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired(required = false)
    private LoginDao loginDao;

    @Value("appid")
    private String appid;

    @Value("secret")
    private String secret;


    @Autowired(required = false)
    private AuthDao authMapper;

    @Override
    public User register(User userToAdd) {
        final String username = userToAdd.getNumber();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword(MD5Utils.MD5encode(rawPassword));
        User user = loginDao.signUpPhone(userToAdd);
        return user;
    }


    @Override
    public String login(String username, String password) {
        MyAuthenticationToken upToken = new MyAuthenticationToken(username, password);
        final Authentication authentication = myAuthenticationProvider.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("type", ((MyAuthenticationToken)authentication).getType());
        final String token = jwtTokenUtil.doGenerateToken(claims, ((MyAuthenticationToken)authentication).getPhone(),null);
        return token;
    }

    @Override
    public String refresh(String oldToken) {
        return null;
    }

    @Override
    public Map<String, Object> weChatLogin(String code, Integer type) throws IOException{
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&grant_type=authorization_code";
        String reqUrl = url + "&js_code=" + code;
        StringBuffer json = new StringBuffer();
        try{
            URL oracle = new URL(reqUrl);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine = null;
            while((inputLine = in.readLine()) != null){
                json.append(new String(inputLine.getBytes(),"utf-8"));
            }
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(json.toString());
        Map<String, Object> auth = new ObjectMapper().readValue(json.toString(), Map.class);
        if(auth.get("errcode") != null){
            throw new IllegalArgumentException("参数错误");
        }
        User user = loginDao.getUserByOpenId((String)auth.get("openid"));
        // 用户还没有注册， 帮他注册一个只有openid的账号，小程序端跳到绑定页面，然后补全其他信息

        User userNew = new User();
        userNew.setOpenid((String)auth.get("openid"));
        userNew.setType(type);

        if(user == null){
            loginDao.signUpPhone(userNew);
            auth.put("status", "unbind");
        }
        User userF = loginDao.getUserByOpenId((String)auth.get("openid"));
        BigInteger userId = userF.getId();
        auth.put("userId", userId);

        MyAuthenticationToken upToken = new MyAuthenticationToken((String)auth.get("openid"), type);
        final Authentication authentication = myAuthenticationProvider.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("type", ((MyAuthenticationToken)authentication).getType());
        final String token = jwtTokenUtil.doGenerateToken(claims, ((MyAuthenticationToken)authentication).getOpenid(),"miniprogram");
        auth.put("jwt", token);

        return auth;
    }
}
