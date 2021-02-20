package com.gaoao.web.servlet.privilege;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaoao.service.RoleService;
import com.gaoao.service.impl.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

//查询全部用户角色
@WebServlet("/findAllUserRoleServlet")
public class FindAllUserRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoleService roleService = new RoleServiceImpl();

       List<Map<String, Object>> list = roleService.findAllUserRole();

        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
//        System.out.println("===========");
//        System.out.println(list);
        ObjectMapper mapper = new ObjectMapper();

        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), list);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
