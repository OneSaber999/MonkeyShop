package com.monkey.servlet.cart;

import com.monkey.entity.MONKEY_CART;
import com.monkey.entity.MONKEY_USER;
import com.monkey.service.MONKEY_CARTDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/orderselect")
public class OrderSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session =  request.getSession();

        String isLogin = (String)session.getAttribute("isLogin");

        MONKEY_USER user=(MONKEY_USER)session.getAttribute("name");


        String eids = request.getParameter("eids");



        if(user!=null && isLogin.equals("1")) {
            int totalprice = 0;

            String ids[] = eids.split(",");

            ArrayList<MONKEY_CART> list = new ArrayList<MONKEY_CART>();

            for(int i=0; i<ids.length; i++) {
                MONKEY_CART es = MONKEY_CARTDao.getCartShop(ids[i]);

                int dprice = es.getCART_P_PRICE() * es.getCART_QUANTITY();

                totalprice += dprice;

                list.add(es);
            }

            request.setAttribute("shoplist", list);
            request.setAttribute("totalprice", totalprice);
            request.getRequestDispatcher("order.jsp").forward(request, response);

        }else{

            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('登录后，再购买');");
            out.write("location.href='login.jsp'");
            out.write("</script>");
            out.close();
        }
    }
}
