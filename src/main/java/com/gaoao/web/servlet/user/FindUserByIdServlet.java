package com.gaoao.web.servlet.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaoao.domain.User;
import com.gaoao.service.UserService;
import com.gaoao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//查询user表,个人全部信息
@WebServlet("/findUserByIdServlet")
public class FindUserByIdServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int uid = Integer.parseInt(request.getParameter("uid"));
        UserService userService = new UserServiceImpl();
        User user = userService.findUserById(uid);
        System.out.println("请求修改用户界面");
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),user);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
