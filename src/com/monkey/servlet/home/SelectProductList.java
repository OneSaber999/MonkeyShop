package com.monkey.servlet.home;

import com.monkey.entity.MONKEY_CATEGORY;
import com.monkey.entity.MONKEY_PRODUCT;
import com.monkey.service.MONKEY_CATEGORYDao;
import com.monkey.service.MONKEY_PRODUCTDao;

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
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        ArrayList<MONKEY_CATEGORY> flist = MONKEY_CATEGORYDao.selectCat("father");
        request.setAttribute("flist",flist);
        ArrayList<MONKEY_CATEGORY> clist = MONKEY_CATEGORYDao.selectCat("child");
        request.setAttribute("clist",clist);

        String fid = request.getParameter("fid");
        String cid = request.getParameter("cid");

        int id = 0;
        ArrayList<MONKEY_PRODUCT> list = null;
        if (fid != null){
            id = Integer.parseInt(fid);
            list = MONKEY_PRODUCTDao.selectAllByFid(id);
        }

        if (cid != null){
            id = Integer.parseInt(cid);
            list = MONKEY_PRODUCTDao.selectAllByCid(id);

        }

        request.setAttribute("title",MONKEY_CATEGORYDao.selectById(id).getCATE_NAME());

        request.setAttribute("list", list);
        request.getRequestDispatcher("productlist.jsp").forward(request,response);
    }
}
