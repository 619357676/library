package com.gaoao.web.servlet.other;

import com.gaoao.domain.Book;
import com.gaoao.service.BookService;
import com.gaoao.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//用于修改时，通过id查找数据，将数据显示在修改页  用于update_jsp  现已弃用
@WebServlet("/findBookByIdServlet1")
public class FindBookByIdServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int bid = Integer.parseInt(request.getParameter("bid"));
        BookService bookService = new BookServiceImpl();
        Book book = bookService.findBookByBid(bid);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/update_book.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
