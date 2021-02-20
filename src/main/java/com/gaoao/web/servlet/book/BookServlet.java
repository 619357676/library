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

//图书展示页 index.html
@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BookService bookService = new BookServiceImpl();

       List<Book>  list= bookService.findAll();
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),list);
        System.out.println("请求查询详情");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
