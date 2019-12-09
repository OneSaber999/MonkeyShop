package com.monkey.servlet.user;

import com.monkey.entity.MONKEY_USER;
import com.monkey.service.MONKEY_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manage/admin_touserupdate")
public class ToUserUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("id");

        //通过ID到数据里查找
        MONKEY_USER user = MONKEY_USERDao.selectById(id);

        request.setAttribute("user",user);
        request.setAttribute("cpage",request.getParameter("cpage"));
        request.getRequestDispatcher("admin_usermodify.jsp").forward(request,response);

    }
}
