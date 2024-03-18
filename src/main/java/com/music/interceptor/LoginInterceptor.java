package com.music.interceptor;

import com.music.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        //复杂的请求浏览器会发送一个OPTION
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            System.out.println("chenggong");
            return true;
        }
        if (token == null) {
            PrintWriter writer = response.getWriter();
            writer.write("Token not found");
            writer.close();
            return false;
        }
        Claims claims = TokenUtil.parseToken(token);
        @SuppressWarnings("unchecked")
        LinkedHashMap<String, Object> user = (LinkedHashMap<String, Object>) claims.get("user");

        System.out.println(user);
        request.setAttribute("userId", user.get("userId"));

        return true;
    }
}
