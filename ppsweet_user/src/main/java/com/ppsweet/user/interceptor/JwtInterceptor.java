package com.ppsweet.user.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("经过了拦截器");

        //无论如何都要放行，具体能不能操作还是具体中判断
        //拦截器只是负责把头请求中包含token的令牌进行解析
        String header=request.getHeader("Authorization");
        if (header!=null &&  !"".equals(header))
        {
            if (header.startsWith("Bearer "))
            {
                String token = header.substring(7);
                try {
                    Claims claims = jwtUtil.parseJWT(token);
                    String role = (String) claims.get("roles");
                    if (role != null && role.equals("admin")) {
                        request.setAttribute("claims_admin", token);
                    }
                    if (role != null && role.equals("user")) {
                        request.setAttribute("claims_user", token);
                    }
                } catch (Exception e) {
                    throw new RuntimeException("令牌不正确");
                }
            }
        }

        return true;
    }
}
