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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectproductview")
public class SelectProductView extends HttpServlet {
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

        String id = request.getParameter("id");

        //获取最近访问
        HttpSession session = request.getSession();
        //从session获取ids
        ArrayList<Integer> ids = (ArrayList<Integer>) session.getAttribute("ids");

        if (ids == null){
            ids = new ArrayList<>();
        }
        //最多5 超出则将第一个删除
        if (ids.size() >= 5){
            ids.remove(0);
        }
        //添加到列表里 但只要一份
        if (id != null && (!ids.contains(Integer.parseInt(id)))){
            ids.add(Integer.parseInt(id));
        }

        session.setAttribute("ids",ids);

        ids = (ArrayList<Integer>) session.getAttribute("ids");
        if (ids != null){
            ArrayList<MONKEY_PRODUCT> lastlylist = MONKEY_PRODUCTDao.selectAllById(ids);
            request.setAttribute("lastlylist",lastlylist);
        }

        MONKEY_PRODUCT p = null;
        if (id != null){
            p = MONKEY_PRODUCTDao.selectById(Integer.parseInt(id));
            request.setAttribute("p",p);
        }

        if (p != null){
            int cid = p.getPRODUCT_CID();
            ArrayList<MONKEY_PRODUCT> classlist = MONKEY_PRODUCTDao.selectAllByCid(cid);
            request.setAttribute("classlist",classlist);

            MONKEY_CATEGORY cate = MONKEY_CATEGORYDao.selectById(cid);
            request.setAttribute("cate",cate);
        }



        request.getRequestDispatcher("productview.jsp").forward(request,response);

    }
}
