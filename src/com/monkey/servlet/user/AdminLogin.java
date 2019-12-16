package com.monkey.servlet.user;

import com.monkey.entity.MONKEY_USER;
import com.monkey.service.MONKEY_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/adminlogin")
public class AdminLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        int count = MONKEY_USERDao.selectByNM(username, password);

        if (count > 0) {

            MONKEY_USER user = MONKEY_USERDao.selectAdmin(username,password);
            HttpSession session = request.getSession();
            session.setAttribute("name",user);
            session.setAttribute("isLogin","1");
            session.setAttribute("isAdminLogin","1");
            if (user.getUSER_STATUS() == 2){

                session.setAttribute("isAdminLogin","1" );
                response.sendRedirect("/manage/admin_index.jsp");

            }else {
                response.sendRedirect("/index.jsp");

            }

        } else {
            PrintWriter out = response.getWriter();
            out.write("<Script>");
            out.write("alert('用户登陆失败');");
            out.write("location.href='login.jsp';");
            out.write("</Script>");
            out.close();

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
