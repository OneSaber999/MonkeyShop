package com.monkey.servlet.product;

import com.monkey.entity.MONKEY_PRODUCT;
import com.monkey.service.MONKEY_CATEGORYDao;
import com.monkey.service.MONKEY_PRODUCTDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manage/admin_doproductdel")
public class DoProductDel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MONKEY_PRODUCTDao.del(id);
        response.sendRedirect("admin_productselect");
    }
}
