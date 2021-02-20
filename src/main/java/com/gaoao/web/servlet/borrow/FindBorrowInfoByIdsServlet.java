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

@WebServlet("/findBorrowInfoByIdsServlet")
public class FindBorrowInfoByIdsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String _bid = request.getParameter("bid");
        int bid = Integer.parseInt(_bid);
        Object _uid = request.getSession().getAttribute("uid");
       int uid =(int)_uid;
       /* Borrow borrow = new Borrow();
        borrow.setBid(Integer.parseInt(bid));
        borrow.setId(id);*/
        BorrowService borrowService = new BorrowServiceImpl();
        List<Borrow> list = borrowService.findBorrowInfoByIds(uid,bid);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), list);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
