package com.gaoao.web.filter;

import com.gaoao.domain.Menu;
import com.gaoao.domain.User;
import com.gaoao.service.MenuService;
import com.gaoao.service.RoleService;
import com.gaoao.service.impl.MenuServiceImpl;
import com.gaoao.service.impl.RoleServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebFilter("/*")
public class PrivilegeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user1");
        String path = request.getRequestURI();
        MenuService menuService = new MenuServiceImpl();
//这些请求在过滤器2仍旧要放行
        //login.html,loginServlet;register.html,registerServlet;退出请求,成功界面,js,css,img,验证码
        if (path.contains("login") || path.contains("index.html") || path.contains("bookServlet") || path.contains("register") || path.contains("userExitServlet") || path.contains("/success.html")|| path.contains("/hint.html") || path.contains("/js/") || path.contains("/css/") || path.contains("/img/") || path.contains("/checkCode")) {
            chain.doFilter(req, resp);//转发下一组件
        } else {
            if (user != null) {//用户登录
                if (path.contains("findUserServlet")) {//登录后，能够查看当前用户
                    chain.doFilter(req, resp);//转发下一组件
                } else {
                    RoleService roleService = new RoleServiceImpl();
                    int rid = roleService.findUserRoleByUid(user.getUid());
                    System.out.println(rid);
                    if (rid == 1) {//是管理员，全部放行
                        System.out.println("2超级管理员登录，直接放行");
                        chain.doFilter(req, resp);
                    } else {
                        System.out.println("2非超级管理员非馆长登录...");
                        List<Menu> list = menuService.findAllMenuByRid(String.valueOf(rid));
                        //                System.out.println("2list:"+list);
                        if (isExist(list, 1)) {//管理用户
                            System.out.println("2存在权限1");
                            if (path.contains("user_add") || path.contains("/addUserServlet") || path.contains("user_all.html") || path.contains("user_detail.html") || path.contains("user_update.html") || path.contains("User") || path.contains("/header.html")) {

                                chain.doFilter(req, resp);
                                return;
                            }/* else {
                            response.sendRedirect(request.getContextPath() + "/success.html");
                            System.out.println("2存在权限1");
                        }*/
                        }
                        if (isExist(list, 2)) {//管理图书
                            System.out.println("2存在权限2");
                            if (path.contains("add_book.html") || path.contains("/addBookServlet") || path.contains("main.html") || path.contains("deleteBookServlet") || path.contains("findBookByIdServlet") || path.contains("book_detail.html") || path.contains("update_book.html") || path.contains("bookDetailServlet") || path.contains("findBookServlet") || path.contains("/header.html")) {

                                chain.doFilter(req, resp);
                                return;
                            }
                        }
                        if (isExist(list, 3)) {//查找用户
                            System.out.println("2存在权限3");
                            if (path.contains("user_all.html") || path.contains("user_detail.html") || path.contains("findAllUserServlet") || path.contains("findUserByIdServlet") || path.contains("/header.html")) {

                                chain.doFilter(req, resp);
                                return;
                            }
                        }
                        if (isExist(list, 4)) {//查找图书
                            System.out.println("2存在权限4");
                            if (path.contains("findBookByIdServlet") || path.contains("book_detail.html") || path.contains("main.html") || path.contains("bookDetailServlet") || path.contains("findBookServlet") || path.contains("/header.html")) {

                                chain.doFilter(req, resp);
                                return;
                            }
                        }
                        if (isExist(list, 5)) {//借阅图书
                            System.out.println("2存在权限5");
                            if (path.contains("borrow") || path.contains("return") || path.contains("findWhetherServlet") || path.contains("findBookByIdServlet") || path.contains("book_detail.html") || path.contains("bookDetailServlet") || path.contains("findBookServlet") || path.contains("/header.html")) {

                                chain.doFilter(req, resp);
                                return;
                            }
                        }
                        if (isExist(list, 6)) {//查看借阅记录
                            System.out.println("2存在权限6");
                            if (path.contains("book_detail.html") || path.contains("findBookByIdServlet")|| path.contains("findBorrowInfo") || path.contains("book_detail.html") || path.contains("bookDetailServlet") || path.contains("findBookServlet") || path.contains("/header.html")) {

                                chain.doFilter(req, resp);
                                return;
                            }
                        }
                        if (isExist(list, 7)) {//角色管理
                            System.out.println("2存在权限7");
                            if (path.contains("Role") || path.contains("role") || path.contains("Privilege") || path.contains("/addBookServlet") || path.contains("/header.html")) {

                                chain.doFilter(req, resp);
                                return;
                            }
                        }
                        if (isExist(list, 8)) {//权限管理
                            System.out.println("2存在权限8");
                            if (path.contains("privilege")||path.contains("Menu") || path.contains("findRole") || path.contains("/header.html")) {

                                chain.doFilter(req, resp);
                                return;
                            }
                        }


                        //跳转
                        else {
                            response.sendRedirect(request.getContextPath() + "/hint.html");
                            System.out.println("所有都不满足，拦截并跳转");
                        }
                    }
                }
            } else {
                chain.doFilter(req, resp);
                System.out.println("2无用户，直接放行");
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

    private boolean isExist(List<Menu> list, int mid) {
        for (Menu l : list) {
            if (l.getId() == mid) {
                return true;
            }
        }
        return false;
    }
}

 /* if (isExist(list, 1)) {//添加用户
                    if (path.contains("user_add") || path.contains("/addUserServlet")) {
                        System.out.println("添加用户权限测试成功");
                        chain.doFilter(req, resp);
                    } else {
//                        response.sendRedirect(request.getContextPath() + "/login.html");
                        System.out.println("添加用户权限测试失败");
                    }

                }*/

//                if(path.contains(""));

//                response.sendRedirect(request.getContextPath() + "/success.html");


                /* else {
                response.sendRedirect(request.getContextPath() + "/header.html");
            }*/


//            System.out.println(user.getName() + "登录了");
//        if(role[0].user_role_emp.rid)

//            MenuService menuService = new MenuServiceImpl();
//            List<Map<String, Object>> list = menuService.findMenuByUid(user.getUid());
//            System.out.println(list);
//            chain.doFilter(req, resp);