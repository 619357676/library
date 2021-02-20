package com.gaoao.interceptor;

import com.gaoao.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrivilegeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user1");
        if(user==null){
            response.sendRedirect(request.getContextPath()+"/login.html");
            return true;
        }
        return true;
    }
}
