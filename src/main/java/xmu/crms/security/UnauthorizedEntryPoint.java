package xmu.crms.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重写授权入口
 * @author LiuXuezhang
 * @date 2017/12/21 18:46
 */
@Component
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

    @Value("failure_page")
    String failPage;

    /**
     * 用于使用Ajax请求的小组
     * Ajax请求没有权限不跳转，而是返回错误信息的Json
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if(isAjaxRequest(request)){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage());
        }else{
            response.sendRedirect(failPage);
        }
    }

    /**
     * 判断请求是否为Ajax请求
     * @param request
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String ajaxFlag = request.getHeader("X-Requested-With");
        return ajaxFlag != null && "XMLHttpRequest".equals(ajaxFlag);
    }
}