package com.monkey.servlet.cart;

import com.monkey.entity.MONKEY_CART;
import com.monkey.entity.MONKEY_PRODUCT;
import com.monkey.entity.MONKEY_USER;
import com.monkey.service.MONKEY_CARTDao;
import com.monkey.service.MONKEY_PRODUCTDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cartadd")
public class CartAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MONKEY_PRODUCT p = null;

        String pid = request.getParameter("id");
        String count = request.getParameter("count");
        String url = request.getParameter("url");

        HttpSession session =  request.getSession();

        String isLogin = (String)session.getAttribute("isLogin");

        MONKEY_USER user=(MONKEY_USER)session.getAttribute("name");

        if(user!=null && isLogin.equals("1")) {

            String uid = (String)user.getUSER_ID();


            //通过用户ID和购物车中的商品ID 查看有没有这条记录

            MONKEY_CART srcsp = MONKEY_CARTDao.getCartShop(uid, pid);

            if(srcsp != null) {
                int srccount = srcsp.getCART_QUANTITY();

                int newcount = srccount + Integer.parseInt(count);

                if(newcount >=5) {
                    newcount =5;
                }

                MONKEY_CARTDao.updatenum(srcsp.getCART_ID(), newcount);

            }else{


                if(pid !=null) {
                    p  = MONKEY_PRODUCTDao.selectById(Integer.parseInt(pid));
                }

                //assert p != null;
                MONKEY_CART cart = new MONKEY_CART(
                        0,
                        p.getPRODUCT_FILENAME(),
                        p.getPRODUCT_NAME(),
                        p.getPRODUCT_PRICE(),
                        Integer.parseInt(count),
                        p.getPRODUCT_STOCK(),
                        p.getPRODUCT_ID(),
                        uid,
                        1

                );

                MONKEY_CARTDao.insert(cart);
            }

        }else{

            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('登录后，再购买')");
            out.write("location.href='login.jsp'");
            out.write("</script>");
            out.close();
            return;
        }

        if(url.equals("z")) {
            response.sendRedirect("showcart");
        }else{
            response.sendRedirect("selectproductview?id="+pid);
        }

    }

}
