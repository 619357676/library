package com.gaoao.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaoao.domain.Result;
import com.gaoao.domain.User;
import com.gaoao.service.UserService;
import com.gaoao.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

//登录

@Controller
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        String return_uri  = request.getParameter("return_uri");
        Result result = new Result();

        if (checkCode == null || !checkCode.equalsIgnoreCase(check)) {
            result.setFlag(false);
            result.setErrorMsg("验证码错误!");
        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println(username);
            System.out.println(password);
            Map<String, String[]> map = request.getParameterMap();

            User user = new User();
            try {
                BeanUtils.populate(user, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            UserService service = new UserServiceImpl();
            User u = service.login(user);

            if (u != null) {
                request.getSession().setAttribute("user1",u);//只为拦截器准备
                request.getSession().setAttribute("user", u.getName());
                request.getSession().setAttribute("uid", u.getUid());
                result.setFlag(true);
                result.setData(return_uri);
            } else {
                result.setFlag(false);
                result.setErrorMsg("用户名或密码错误!");
            }
            System.out.println("用户:" + user.getUsername() + "登录");
        }

        // 响应数据
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), result);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
