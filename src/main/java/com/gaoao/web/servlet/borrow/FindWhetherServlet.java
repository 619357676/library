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
//查询是否可还
@WebServlet("/findWhetherServlet")
public class FindWhetherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _bid = request.getParameter("bid");
        Object _uid = request.getSession().getAttribute("uid");
        int bid = Integer.parseInt(_bid);
        int uid = (int) _uid;
        BorrowService borrowService = new BorrowServiceImpl();
        Borrow borrow = new Borrow();
        borrow.setUid(uid);
        borrow.setBid(bid);
        List<Borrow> list = borrowService.findWhether(borrow);
//长度为1表示：存在借阅记录，且未归还 ，  为可还书状态，不可借书
        boolean flag = list.size() == 1;
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), flag);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
