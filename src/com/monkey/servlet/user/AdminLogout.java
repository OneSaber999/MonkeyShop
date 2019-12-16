package com.monkey.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/adminlogout")
public class AdminLogout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        session.removeAttribute("name");
        session.removeAttribute("isLogin");
        session.removeAttribute("isAdminLogin");

        PrintWriter out = response.getWriter();
        out.write("<Script>");
        out.write("alert('退出成功！');");
        out.write("location.href='/manage/login.jsp';");
        out.write("</Script>");
        out.close();
    }
}
