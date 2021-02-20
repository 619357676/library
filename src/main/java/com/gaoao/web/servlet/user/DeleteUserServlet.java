package com.gaoao.web.servlet.user;

import com.gaoao.service.UserService;
import com.gaoao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String[] id = request.getParameterValues("id");
//        System.out.println("id的值:"+id[0]);
        UserService userService = new UserServiceImpl();
        boolean delete = userService.delete(id);
        if (delete){
            System.out.println("已删除");
        }
        else{
            System.out.println("未删除");
        }
        response.sendRedirect(request.getContextPath()+"/user_all.html");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
