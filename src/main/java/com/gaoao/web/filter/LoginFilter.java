package com.gaoao.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;

        HttpSession session = request.getSession();
        Object user = session.getAttribute("user1");
        String path = request.getRequestURI();
//        String servletPath = String.valueOf(req.getRequestURL());
//        System.out.println("servletPath:"+servletPath);
//        req.setAttribute("return_uri", servletPath);
        System.out.println("1请求URL:" + path);


//        if(servletPath!=null&&(servletPath.equals("/login.html"))||("/register.html".equals(servletPath))){
        if (path.contains("login") || path.contains("index.html")|| path.contains("bookServlet")|| path.contains("register") || path.contains("userExitServlet")|| path.contains("/success.html")|| path.contains("/hint.html") || path.contains("/js/") || path.contains("/css/") || path.contains("/img/") || path.contains("/checkCode")) {
            chain.doFilter(req, resp);//转发下一组件

        }else {
            if (user != null) {//有用户
                chain.doFilter(req, resp);
            } else {
                System.out.println("1未登录");
                response.sendRedirect(request.getContextPath() + "/login.html");
            }

        }

    }


    @Override
    public void destroy() {

    }
}
