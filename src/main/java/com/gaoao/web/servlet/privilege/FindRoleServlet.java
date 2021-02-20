package com.gaoao.web.servlet.privilege;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaoao.domain.Role;
import com.gaoao.service.RoleService;
import com.gaoao.service.impl.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//查询角色菜单列表
@WebServlet("/findRoleServlet")
public class FindRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        RoleService roleService= new RoleServiceImpl();
        List<Role> allRole = roleService.findAllRole();
        ObjectMapper mapper = new ObjectMapper();

        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), allRole);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
