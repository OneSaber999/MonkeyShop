package com.monkey.service;

import com.monkey.dao.BaseDao;
import com.monkey.entity.MONKEY_CATEGORY;
import com.monkey.entity.MONKEY_PRODUCT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MONKEY_PRODUCTDao {

    //插入
    public static int insert(MONKEY_PRODUCT p) {
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

        return BaseDao.exectuIUD(sql, params);

    }

    //修改
    public static int update(MONKEY_PRODUCT p) {
        String sql = "update MONKEY_PRODUCT set PRODUCT_NAME = ?, PRODUCT_DESCRIPTION = ?, PRODUCT_PRICE = ?, PRODUCT_STOCK = ?, PRODUCT_FID = ?, PRODUCT_CID = ?, PRODUCT_FILENAME = ? where PRODUCT_ID = ?";

        Object[] params = {
                p.getPRODUCT_NAME(),
                p.getPRODUCT_DESCRIPTION(),
                p.getPRODUCT_PRICE(),
                p.getPRODUCT_STOCK(),
                p.getPRODUCT_FID(),
                p.getPRODUCT_CID(),
                p.getPRODUCT_FILENAME(),
                p.getPRODUCT_ID()

        };

        return BaseDao.exectuIUD(sql, params);

    }

    //删除
    public static int del(int id) {
        String sql = "delete from MONKEY_PRODUCT where PRODUCT_ID = ?";

        Object[] params = {id};

        return BaseDao.exectuIUD(sql, params);
    }

    public static int[] totalPage(int count) {
        //0 总记录数  1 总页数
        int[] arr = {0, 1};
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from MONKEY_PRODUCT";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                arr[0] = rs.getInt(1);
                if (arr[0] % count == 0) {
                    arr[1] = arr[0] / count;
                } else {
                    arr[1] = arr[0] / count + 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }
        return arr;

    }


    public static ArrayList<MONKEY_PRODUCT> selectAll(int cpage, int count) {
        ArrayList<MONKEY_PRODUCT> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = BaseDao.getconn();

        PreparedStatement ps = null;


        try {
            String sql = "select * from MONKEY_PRODUCT limit ?,?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (cpage - 1) * count);
            ps.setInt(2, count);
            rs = ps.executeQuery();

            while (rs.next()) {
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

            while (rs.next()) {
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

    public static ArrayList<MONKEY_PRODUCT> selectByIds() {
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

            while (rs.next()) {
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
            ps.setInt(1, fid);

            rs = ps.executeQuery();

            while (rs.next()) {
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
            ps.setInt(1, cid);

            rs = ps.executeQuery();

            while (rs.next()) {
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
            for (int i = 0; i < ids.size(); i++) {

                String sql = "select * from MONKEY_PRODUCT where PRODUCT_ID=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, ids.get(i));
                rs = ps.executeQuery();

                while (rs.next()) {
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
