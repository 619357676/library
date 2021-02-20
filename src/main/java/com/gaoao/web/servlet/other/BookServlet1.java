package com.gaoao.web.servlet.other;

import com.gaoao.domain.Book;
import com.gaoao.domain.PageBean;
import com.gaoao.service.BookService;
import com.gaoao.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//已弃用
@WebServlet("/bookServlet1")
public class BookServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        List<Book> list = bookService.findAll();

//        将list存入request域中

        request.setAttribute("books",list);

        PageBean<Book> pageBean = new PageBean<Book>();
        pageBean.setTotalCount(list.size());
       int totalPage = (list.size()%10) == 0 ? list.size() / 10 : (list.size() / 10) + 1;

        pageBean.setTotalPage(totalPage);
        request.setAttribute("page",pageBean);

        request.getRequestDispatcher("/main.jsp").forward(request,response);
        System.out.println("打开主页");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
