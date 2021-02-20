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

@WebServlet("/findRoleByUidServlet")
public class FindRoleByUidServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoleService roleService = new RoleServiceImpl();

        String uid = request.getParameter("uid");
        List<Map<String, Object>> list = roleService.findRoleByUid(Integer.parseInt(uid));

        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }

        ObjectMapper mapper = new ObjectMapper();

        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), list);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
