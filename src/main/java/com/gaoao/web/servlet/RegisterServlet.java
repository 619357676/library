package com.gaoao.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaoao.domain.Result;
import com.gaoao.domain.User;
import com.gaoao.service.UserService;
import com.gaoao.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

//注册
@Controller
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String check = req.getParameter("check");

        HttpSession session = req.getSession();
        String checkCode = (String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        Result result = new Result();
        if (checkCode == null || !checkCode.equalsIgnoreCase(check)) {
//            Result result = new Result();
            result.setFlag(false);
            result.setErrorMsg("验证码错误!");
            /*ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(result);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(json);
            return;*/
        } else {
            UserService userService = new UserServiceImpl();
//        String username = req.getParameter("username");

            Map<String, String[]> map = req.getParameterMap();

            User user = new User();

            try {
                BeanUtils.populate(user, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            boolean register = userService.register(user.getUsername());

//            Result result = new Result();

            if (register) {
                System.out.println(user.getUsername() + "注册成功");
                //resp.sendRedirect(req.getContextPath()+"/success.html");
                userService.save(user);
                result.setFlag(true);
            } else {
                System.out.println(user.getUsername() + "注册失败，已存在此用户");
                //resp.sendRedirect(req.getContextPath()+"/fail.html");
                result.setFlag(false);
                result.setErrorMsg("注册失败，已存在此用户");
            }
        }

//        将data对象序列化为json对象
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);

        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
