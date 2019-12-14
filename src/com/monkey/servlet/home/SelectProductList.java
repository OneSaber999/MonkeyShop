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

@WebServlet("/selectproductlist")
public class SelectProductList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<MONKEY_CATEGORY> flist = MONKEY_CATEGORYDao.selectCat("father");
        request.setAttribute("flist",flist);
        ArrayList<MONKEY_CATEGORY> clist = MONKEY_CATEGORYDao.selectCat("child");
        request.setAttribute("clist",clist);

        String fid = request.getParameter("fid");
        String cid = request.getParameter("cid");

        int id = 0;
        if (fid != null){
            id = Integer.parseInt(fid);
        }

        if (cid != null){
            id = Integer.parseInt(cid);
        }

        request.setAttribute("title",MONKEY_CATEGORYDao.selectById(id).getCATE_NAME());


        request.getRequestDispatcher("productlist.jsp").forward(request,response);
    }
}
