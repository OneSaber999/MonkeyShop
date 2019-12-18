package com.monkey.service;

import com.monkey.dao.BaseDao;
import com.monkey.entity.MONKEY_CART;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MONKEY_CARTDao {
    public static int insert(MONKEY_CART cart){
        String sql = "insert into MONKEY_cart values(null,?,?,?,?,?,?,?,1)";

        Object[] params = {
                cart.getCART_P_FILENAME(),
                cart.getCART_P_NAME(),
                cart.getCART_P_PRICE(),
                cart.getCART_QUANTITY(),
                cart.getCART_P_STOCK(),
                cart.getCART_P_ID(),
                cart.getCART_U_ID()

        };

        return BaseDao.exectuIUD(sql, params);
    }


    public static MONKEY_CART getCartShop(String id) {
        MONKEY_CART es =null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = BaseDao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select * from MONKEY_CART where CART_ID=? and CART_VALID=1 order by CART_ID desc";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            rs = ps.executeQuery();

            while(rs.next()) {
                es = new MONKEY_CART(
                        rs.getInt("CART_ID"),
                        rs.getString("CART_P_FILENAME"),
                        rs.getString("CART_P_NAME"),
                        rs.getInt("CART_P_PRICE"),
                        rs.getInt("CART_QUANTITY"),
                        rs.getInt("CART_P_STOCK"),
                        rs.getInt("CART_P_ID"),
                        rs.getString("CART_U_ID"),
                        rs.getInt("CART_VALID")
                );






            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }



        return es;
    }



    public static MONKEY_CART getCartShop(String uid, String pid) {
        MONKEY_CART es =null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = BaseDao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select * from MONKEY_CART where CART_U_ID=? and CART_P_ID=? and CART_VALID=1 order by CART_ID desc";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uid);
            ps.setInt(2, Integer.parseInt(pid));
            rs = ps.executeQuery();

            while(rs.next()) {
                es = new MONKEY_CART(
                        rs.getInt("CART_ID"),
                        rs.getString("CART_P_FILENAME"),
                        rs.getString("CART_P_NAME"),
                        rs.getInt("CART_P_PRICE"),
                        rs.getInt("CART_QUANTITY"),
                        rs.getInt("CART_P_STOCK"),
                        rs.getInt("CART_P_ID"),
                        rs.getString("CART_U_ID"),
                        rs.getInt("CART_VALID")
                );






            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }



        return es;
    }


    public static ArrayList<MONKEY_CART> getCart(String id){
        ArrayList<MONKEY_CART> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = BaseDao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select * from MONKEY_CART where CART_U_ID=? and CART_VALID=1 order by CART_ID desc";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while(rs.next()) {
                MONKEY_CART c = new MONKEY_CART(
                        rs.getInt("CART_ID"),
                        rs.getString("CART_P_FILENAME"),
                        rs.getString("CART_P_NAME"),
                        rs.getInt("CART_P_PRICE"),
                        rs.getInt("CART_QUANTITY"),
                        rs.getInt("CART_P_STOCK"),
                        rs.getInt("CART_P_ID"),
                        rs.getString("CART_U_ID"),
                        rs.getInt("CART_VALID")
                );





                list.add(c);

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }



        return list;
    }

    public static int updatenum(int esid, int count){

        String sql = "update MONKEY_CART set CART_QUANTITY=? where CART_ID=? ";

        Object[] params = {count, esid};

        return BaseDao.exectuIUD(sql, params);

    }

    public static int getDeleteDD(int id) {
        String sql="delete from MONKEY_CART where CART_ID=?";

        Object[] params={id};

        return BaseDao.exectuIUD(sql, params);
    }
}
