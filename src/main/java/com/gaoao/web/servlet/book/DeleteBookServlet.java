package com.gaoao.web.servlet.book;

import com.gaoao.service.BookService;
import com.gaoao.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//用于删除
@WebServlet("/deleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        int bid = Integer.parseInt(request.getParameter("bid"));
        String[] bid = request.getParameterValues("bid");
        System.out.println("bid的值:"+bid[0]);
       /* BookDao bookDao = new BookDaoImpl();
        boolean delete = bookDao.delete(bid);*/
        BookService bookService = new BookServiceImpl();
        boolean delete = bookService.delete(bid);
        if (delete){
            //request.setAttribute("flag","dff");
            System.out.println("已删除");
            response.sendRedirect(request.getContextPath()+"/main.html");
        }
        else{
            System.out.println("未删除");
            response.sendRedirect(request.getContextPath()+"/main.html");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
