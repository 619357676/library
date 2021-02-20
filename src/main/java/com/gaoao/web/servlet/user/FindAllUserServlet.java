package com.gaoao.web.servlet.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaoao.domain.User;
import com.gaoao.domain.PageBean;
import com.gaoao.service.UserService;
import com.gaoao.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findAllUserServlet")
public class FindAllUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if(currentPage == null || "".equals(currentPage)){

            currentPage = "1";
        }
        if(rows == null || "".equals(rows)){
            rows = "10";
        }
        Map<String,String[]> map = request.getParameterMap();

        UserService userService = new UserServiceImpl();
        PageBean<User> userPageBean = userService.findUserByPage(currentPage,rows,map);
        //System.out.println(bookPageBean);
        System.out.println("PageBean的list为："+userPageBean.getList());

        request.setAttribute("books",userPageBean.getList());
        request.setAttribute("page",userPageBean);
        request.setAttribute("map",map);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), userPageBean);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
