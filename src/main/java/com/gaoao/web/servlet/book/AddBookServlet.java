package com.gaoao.web.servlet.book;


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

//增加书籍
@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String,String[]> map=req.getParameterMap();
        Book book = new Book();
        try {
            BeanUtils.populate(book,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        BookService service = new BookServiceImpl();
        boolean flag = service.add(book);
        if(flag){
            System.out.println("添加成功");
            resp.sendRedirect(req.getContextPath()+"/success.html");
        }
        else{
            System.out.println("添加失败");
            resp.sendRedirect(req.getContextPath()+"/fail.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
