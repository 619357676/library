package com.gaoao.web.servlet.privilege;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaoao.domain.Menu;
import com.gaoao.service.MenuService;
import com.gaoao.service.impl.MenuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//
@WebServlet("/findAllMenuByRidServlet")
public class FindAllMenuByRidServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String rid = request.getParameter("rid");
        MenuService menuService = new MenuServiceImpl();
        List<Menu> list = menuService.findAllMenuByRid(rid);
        System.out.println("list:"+list);
        ObjectMapper mapper = new ObjectMapper();

        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), list);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
