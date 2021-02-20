package com.gaoao.web.servlet.privilege;

import com.gaoao.service.MenuService;
import com.gaoao.service.impl.MenuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePrivilegeServlet")
public class UpdatePrivilegeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String[] id = request.getParameterValues("id");//获取id的值,值对应menu表中的权限
        String rid = request.getParameter("rid");
        //遍历查看数据:
        for (int i = 0; i < id.length; i++) {
            System.out.println(id[i]);
        }
        System.out.println("===========");
        System.out.println(rid);
        MenuService menuService = new MenuServiceImpl();
        menuService.deletePrivilegeByRid(Integer.parseInt(rid));
        System.out.println("删除成功");
        menuService.updatePrivilege(rid, id);//根据情况改成插入操作,和修改差不多
        response.sendRedirect(request.getContextPath() + "/privilege.html");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
