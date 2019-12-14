package com.monkey.servlet.cate;

import com.monkey.entity.MONKEY_CATEGORY;
import com.monkey.service.MONKEY_CATEGORYDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manage/admin_docateadd")
public class DoCateAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int fid = Integer.parseInt(request.getParameter("parentId"));
        String name = request.getParameter("className");

        MONKEY_CATEGORY cate = new MONKEY_CATEGORY(0,name,fid);
        MONKEY_CATEGORYDao.insert(cate);

        response.sendRedirect("admin_tocateadd");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
