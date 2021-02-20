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
import java.util.List;

//展示图书详情
@WebServlet("/bookDetailServlet")
public class BookDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
//        int bid =1;
        int bid = Integer.parseInt(request.getParameter("bid"));

//        System.out.println(bid);
        List<Book> books = bookService.findBookById(bid);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), books);

        System.out.println("请求查询详情页,进入借阅界面");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
