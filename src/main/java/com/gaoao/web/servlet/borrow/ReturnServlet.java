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

@WebServlet("/returnServlet")
public class ReturnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String bid = request.getParameter("bid");
        Object _uid = request.getSession().getAttribute("uid");
        int uid = (int) _uid;
        Book book = new Book();
        book.setBid(Integer.parseInt(bid));
        BorrowService borrowService = new BorrowServiceImpl();


        Borrow borrow = new Borrow();

        borrow.setUid(uid);
        borrow.setBid(Integer.parseInt(bid));


        List<Borrow> list = borrowService.findWhether(borrow);
        boolean flag2 = list.size()==1;
        boolean result = false;
        if(flag2){//可还书
            Borrow borrow1 = borrowService.findBorrow(borrow);//查询借阅记录
            boolean flag = borrowService.returnBook(book);//可借书籍加1
            boolean flag1 = borrowService.add1(borrow1);//添加还书记录
            if(flag&&flag1){
                result = true;
            }
        }


        if (result) {
            System.out.println("归还成功");
        } else {
            System.out.println("归还失败");
        }

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
