package com.gaoao.web.servlet.other;

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

@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MenuService menuService = new MenuServiceImpl();
        List<Menu> list = menuService.findAllMenuByRid(String.valueOf(1));
        System.out.println(list);
        System.out.println(list.get(1).getId());
        for (Menu aList : list) {
            System.out.println(aList.getId());

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
