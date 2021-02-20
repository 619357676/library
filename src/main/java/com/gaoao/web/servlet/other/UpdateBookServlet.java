package com.gaoao.web.servlet.other;


import com.gaoao.domain.Book;
import com.gaoao.service.BookService;
import com.gaoao.service.impl.BookServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

//为
// update_book.jsp准备   用于删除操作，现已弃用
@WebServlet("/updateBookServlet1")
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String,String[]> map = request.getParameterMap();
        Book book = new Book();
        try {
            BeanUtils.populate(book,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        BookService bookService = new BookServiceImpl();
        bookService.updateBook(book);
        response.sendRedirect(request.getContextPath()+"/findBookServlet");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
