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
import java.util.Map;

//查找全部书籍，并分页显示在页面上，也可以进行书名和作者查找  为main.jsp  现已弃用
@WebServlet("/findBookServlet1")
public class FindBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if(currentPage == null || "".equals(currentPage)){

            currentPage = "1";
        }
        if(rows == null || "".equals(rows)){
            rows = "10";
        }
        Map<String,String[]> map = request.getParameterMap();

        BookService bookService = new BookServiceImpl();
        PageBean<Book> bookPageBean = bookService.findBookByPage(currentPage,rows,map);
        //System.out.println(bookPageBean);
        System.out.println("PageBean的list为："+bookPageBean.getList());

        request.setAttribute("books",bookPageBean.getList());
        request.setAttribute("page",bookPageBean);

        request.setAttribute("map",map);

        request.getRequestDispatcher("/main.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
