package com.monkey.servlet.user;

import com.monkey.entity.MONKEY_USER;
import com.monkey.service.MONKEY_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manage/admin_douserselect")
public class DoUserSelect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int cpage = 1; //当前页
        int count = 5; //每页显示条数

        //获取用户指定页面
        String cp = request.getParameter("cp");

        //接受用户搜索的关键字
        String keywords = request.getParameter("keywords");

        if (cp != null){
            cpage = Integer.parseInt(cp);
        }

        int[] arr = MONKEY_USERDao.totalPage(count);


        //获取所有用户记录
        ArrayList<MONKEY_USER> list = MONKEY_USERDao.selectAll(cpage,count,keywords);

        //放到请求对象域里
        request.setAttribute("userlist",list);
        request.setAttribute("tsum",arr[0]);
        request.setAttribute("tpage",arr[1]);
        request.setAttribute("cpage",cpage);

        request.getRequestDispatcher("admin_user.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
