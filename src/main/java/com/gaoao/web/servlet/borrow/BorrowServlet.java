package com.gaoao.web.servlet.borrow;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaoao.domain.Book;
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

@WebServlet("/borrowServlet")
public class BorrowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String bid = request.getParameter("bid");
//        String id=request.getParameter("id");
        Object _uid = request.getSession().getAttribute("uid");
        int uid = (int) _uid;

        Book book = new Book();
        book.setBid(Integer.parseInt(bid));
        BorrowService borrowService = new BorrowServiceImpl();
        Borrow borrow = new Borrow();
        borrow.setBid(Integer.parseInt(bid));
        borrow.setUid(uid);
        List<Borrow> list = borrowService.findWhether(borrow);
/*//需要事务控制
        boolean flag = borrowService.borrow(book);//是否可借  有书且书减1
        boolean flag1 = borrowService.add(borrow);//添加借阅记录  是否添加成功
        boolean flag2 = list.size()==0;
        if (flag&&flag1&&flag2) {
            System.out.println("借阅成功");
        } else {
            System.out.println("借阅失败");
            //借阅失败回滚事务
        }*/
        boolean result = false;
        boolean flag2 = list.size() == 0;
        if (flag2) {
            boolean flag = borrowService.borrow(book);//是否可借  有书且书减1
            if (flag) {
                boolean flag1 = borrowService.add(borrow);//添加借阅记录  是否添加成功 添加一定会成功的，所以可以解决问题
                if (flag1) {
                    result = true;
                }
            }
        }

        System.out.println(bid);
        System.out.println(uid);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), result);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
