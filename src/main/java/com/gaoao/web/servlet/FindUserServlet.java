package com.gaoao.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaoao.domain.Result;
import com.gaoao.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//查找用户数据，用于显示当前用户 header.html
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//从session中获取登录信息
        Object user = request.getSession().getAttribute("user");
        Object uid = request.getSession().getAttribute("uid");
        User u = new User();

//        写回客户端
        Result result = new Result();
        // System.out.println("数据:"+user);
        if (user != null) {
            result.setFlag(true);
        } else {
            result.setFlag(false);
        }
        u.setUid((Integer) uid);
        u.setName((String) user);
        result.setData(u);
//        System.out.println(result);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");


        mapper.writeValue(response.getOutputStream(), result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
