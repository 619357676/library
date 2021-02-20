package com.gaoao.web.servlet.borrow;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaoao.domain.Borrow;
import com.gaoao.service.BorrowService;
import com.gaoao.service.impl.BorrowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findBorrowInfoServlet")
public class FindBorrowInfoServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        BorrowService borrowService = new BorrowServiceImpl();
        List<Borrow> list =  borrowService.findBorrowInfo(uid);


        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), list);
        System.out.println("list:"+list);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
