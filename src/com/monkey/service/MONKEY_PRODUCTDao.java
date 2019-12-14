package com.monkey.service;

import com.monkey.dao.BaseDao;
import com.monkey.entity.MONKEY_PRODUCT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MONKEY_PRODUCTDao {
    public static int insert(MONKEY_PRODUCT p){
        String sql = "insert into MONKEY_PRODUCT values(null,?,?,?,?,?,?,?)";

        Object[] params = {
                p.getPRODUCT_NAME(),
                p.getPRODUCT_DESCRIPTION(),
                p.getPRODUCT_PRICE(),
                p.getPRODUCT_STOCK(),
                p.getPRODUCT_FID(),
                p.getPRODUCT_CID(),
                p.getPRODUCT_FILENAME()
        };

        return BaseDao.exectuIUD(sql,params);

    }


    public static ArrayList<MONKEY_PRODUCT> selectAll() {
        ArrayList<MONKEY_PRODUCT> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = BaseDao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select * from MONKEY_PRODUCT";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                MONKEY_PRODUCT p = new MONKEY_PRODUCT(
                        rs.getInt("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"),
                        rs.getString("PRODUCT_DESCRIPTION"),
                        rs.getInt("PRODUCT_PRICE"),
                        rs.getInt("PRODUCT_STOCK"),
                        rs.getInt("PRODUCT_FID"),
                        rs.getInt("PRODUCT_CID"),
                        rs.getString("PRODUCT_FILENAME")
                );


                list.add(p);

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }



        return list;
    }

    public static MONKEY_PRODUCT selectById(int id) {
        MONKEY_PRODUCT p = null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = BaseDao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select * from MONKEY_PRODUCT where PRODUCT_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while(rs.next()) {
                p = new MONKEY_PRODUCT(
                        rs.getInt("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"),
                        rs.getString("PRODUCT_DESCRIPTION"),
                        rs.getInt("PRODUCT_PRICE"),
                        rs.getInt("PRODUCT_STOCK"),
                        rs.getInt("PRODUCT_FID"),
                        rs.getInt("PRODUCT_CID"),
                        rs.getString("PRODUCT_FILENAME")
                );




            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }



        return p;
    }
    
    

    /**
     * 根据fid查询
     */
    public static ArrayList<MONKEY_PRODUCT> selectAllByFid(int fid) {
        ArrayList<MONKEY_PRODUCT> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = BaseDao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select * from MONKEY_PRODUCT where PRODUCT_FID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,fid);

            rs = ps.executeQuery();

            while(rs.next()) {
                MONKEY_PRODUCT p = new MONKEY_PRODUCT(
                        rs.getInt("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"),
                        rs.getString("PRODUCT_DESCRIPTION"),
                        rs.getInt("PRODUCT_PRICE"),
                        rs.getInt("PRODUCT_STOCK"),
                        rs.getInt("PRODUCT_FID"),
                        rs.getInt("PRODUCT_CID"),
                        rs.getString("PRODUCT_FILENAME")
                );


                list.add(p);

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }



        return list;
    }
    /**
     * 根据cid查询
     */
    public static ArrayList<MONKEY_PRODUCT> selectAllByCid(int cid) {
        ArrayList<MONKEY_PRODUCT> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = BaseDao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select * from MONKEY_PRODUCT where PRODUCT_CID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,cid);

            rs = ps.executeQuery();

            while(rs.next()) {
                MONKEY_PRODUCT p = new MONKEY_PRODUCT(
                        rs.getInt("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"),
                        rs.getString("PRODUCT_DESCRIPTION"),
                        rs.getInt("PRODUCT_PRICE"),
                        rs.getInt("PRODUCT_STOCK"),
                        rs.getInt("PRODUCT_FID"),
                        rs.getInt("PRODUCT_CID"),
                        rs.getString("PRODUCT_FILENAME")
                );


                list.add(p);

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }



        return list;
    }

    public static ArrayList<MONKEY_PRODUCT> selectAllById(ArrayList<Integer> ids) {
        ArrayList<MONKEY_PRODUCT> lastlylist = new ArrayList<MONKEY_PRODUCT>();

        MONKEY_PRODUCT p = null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = BaseDao.getconn();

        PreparedStatement ps = null;



        try {
            for(int i=0; i<ids.size(); i++) {

                String sql = "select * from MONKEY_PRODUCT where PRODUCT_ID=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, ids.get(i));
                rs = ps.executeQuery();

                while(rs.next()) {
                    p = new MONKEY_PRODUCT(
                            rs.getInt("PRODUCT_ID"),
                            rs.getString("PRODUCT_NAME"),
                            rs.getString("PRODUCT_DESCRIPTION"),
                            rs.getInt("PRODUCT_PRICE"),
                            rs.getInt("PRODUCT_STOCK"),
                            rs.getInt("PRODUCT_FID"),
                            rs.getInt("PRODUCT_CID"),
                            rs.getString("PRODUCT_FILENAME")
                    );


                    lastlylist.add(p);

                }
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }



        return lastlylist;
    }
}
