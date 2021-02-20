package com.gaoao.web.servlet.privilege;


import com.gaoao.service.RoleService;
import com.gaoao.service.impl.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/updateRoleServlet")
public class UpdateRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String _uid= request.getParameter("uid");
      String _rid = request.getParameter("rid");
      int uid= Integer.parseInt(_uid);
      int rid = Integer.parseInt(_rid);
        RoleService roleService = new RoleServiceImpl();
      boolean flag = roleService.updateRole(uid,rid);
      if(flag){
          System.out.println("修改success");
      }
      else System.out.println("fail");

      response.sendRedirect(request.getContextPath()+"role.html");
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
