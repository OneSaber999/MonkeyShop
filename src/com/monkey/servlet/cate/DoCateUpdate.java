package com.monkey.servlet.cate;

import com.monkey.entity.MONKEY_CATEGORY;
import com.monkey.service.MONKEY_CATEGORYDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manage/admin_docateupdate")
public class DoCateUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(request.getParameter("id"));
        int fid = Integer.parseInt(request.getParameter("parentId"));
        String name = request.getParameter("className");

        MONKEY_CATEGORY cate = new MONKEY_CATEGORY(id,name,fid);
        MONKEY_CATEGORYDao.update(cate);

        response.sendRedirect("admin_cateselect");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
