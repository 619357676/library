package com.gaoao.web.servlet.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaoao.domain.Book;
import com.gaoao.service.BookService;
import com.gaoao.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//用于修改时，通过id查找数据，将数据显示在修改页  用于update_book.html  回显数据
@WebServlet("/findBookByIdServlet")
public class FindBookByIdServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int bid = Integer.parseInt(request.getParameter("bid"));
        BookService bookService = new BookServiceImpl();
        Book book = bookService.findBookByBid(bid);
        System.out.println("请求修改界面");
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), book);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
