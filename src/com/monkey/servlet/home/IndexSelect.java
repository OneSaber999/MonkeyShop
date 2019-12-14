package com.monkey.servlet.home;

import com.monkey.entity.MONKEY_CATEGORY;
import com.monkey.service.MONKEY_CATEGORYDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/indexselect")
public class IndexSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        ArrayList<MONKEY_CATEGORY> flist = MONKEY_CATEGORYDao.selectCat("father");
        request.setAttribute("flist",flist);
        ArrayList<MONKEY_CATEGORY> clist = MONKEY_CATEGORYDao.selectCat("child");
        request.setAttribute("clist",clist);

        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
