package com.monkey.servlet.user;

import com.monkey.entity.MONKEY_USER;
import com.monkey.service.MONKEY_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String ids[] = request.getParameterValues("id[]");

        //批量删除
        for (int i = 0; i < ids.length; i++) {
            MONKEY_USERDao.del(ids[i]);

        }

        //重定向
        response.sendRedirect("/manage/admin_douserselect");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("id");

        //删除
        int count = MONKEY_USERDao.del(id);

        //成功或失败重定向到哪里

        if(count > 0) {
            response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
        } else {
            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('用户删除失败')");
            out.write("location.href='manage/admin_douserselect?cp"+request.getParameter("cpage")+"'");
            out.write("</script>");

        }
    }
}
