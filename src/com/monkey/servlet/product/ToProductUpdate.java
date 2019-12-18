package com.monkey.servlet.product;

import com.monkey.entity.MONKEY_CATEGORY;
import com.monkey.entity.MONKEY_PRODUCT;
import com.monkey.entity.MONKEY_USER;
import com.monkey.service.MONKEY_CATEGORYDao;
import com.monkey.service.MONKEY_PRODUCTDao;
import com.monkey.service.MONKEY_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manage/admin_toproductupdate")
public class ToProductUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //通过ID到数据里查找
        int id = Integer.parseInt(request.getParameter("id"));
        MONKEY_PRODUCT p = MONKEY_PRODUCTDao.selectById(id);

        ArrayList<MONKEY_CATEGORY> flist = MONKEY_CATEGORYDao.selectCat("father");
        request.setAttribute("flist",flist);
        ArrayList<MONKEY_CATEGORY> clist = MONKEY_CATEGORYDao.selectCat("child");
        request.setAttribute("clist",clist);

        request.setAttribute("p1",p);
        request.setAttribute("cpage",request.getParameter("cpage"));

        request.getRequestDispatcher("admin_productmodify.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
