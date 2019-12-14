package com.monkey.service;

import com.monkey.dao.BaseDao;
import com.monkey.entity.MONKEY_CATEGORY;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MONKEY_CATEGORYDao {

    /**
     * 获取所有分类
     *
     * @return
     */
    public static ArrayList<MONKEY_CATEGORY> selectAll() {
        ArrayList<MONKEY_CATEGORY> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = BaseDao.getconn();

        PreparedStatement ps = null;

        try {
            String sql = "select * from MONKEY_CATEGORY";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MONKEY_CATEGORY cate = new MONKEY_CATEGORY(
                        rs.getInt("CATE_ID"),
                        rs.getString("CATE_NAME"),
                        rs.getInt("CATE_PARENT_ID")
                );
                list.add(cate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }

        return list;
    }

    /**
     * 查询分类,子分类和父分类
     *
     * @param flag == "father"   "child"
     * @return
     */
    public static ArrayList<MONKEY_CATEGORY> selectCat(String flag) {
        ArrayList<MONKEY_CATEGORY> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = BaseDao.getconn();

        PreparedStatement ps = null;

        try {
            String sql = "";
            if (flag != null && flag.equals("father")) {
                sql = "select * from MONKEY_CATEGORY where CATE_PARENT_ID = 0";

            } else {
                sql = "select * from MONKEY_CATEGORY where CATE_PARENT_ID != 0";

            }
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MONKEY_CATEGORY cate = new MONKEY_CATEGORY(
                        rs.getInt("CATE_ID"),
                        rs.getString("CATE_NAME"),
                        rs.getInt("CATE_PARENT_ID")
                );
                list.add(cate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }

        return list;
    }

    /**
     * 添加分类
     *
     * @param cate
     * @return
     */
    public static int insert(MONKEY_CATEGORY cate) {
        String sql = "insert into MONKEY_CATEGORY values(null,?,?)";

        Object[] params = {
                cate.getCATE_NAME(),
                cate.getCATE_PARENT_ID()
        };
        return BaseDao.exectuIUD(sql, params);

    }

    //修改
    public static int update(MONKEY_CATEGORY cate) {
        String sql = "update MONKEY_CATEGORY set CATE_NAME = ?, CATE_PARENT_ID = ? where CATE_ID = ?";

        Object[] params = {
                cate.getCATE_NAME(),
                cate.getCATE_PARENT_ID(),
                cate.getCATE_ID()

        };

        return BaseDao.exectuIUD(sql, params);

    }

    //删除
    public static int del(int id) {
        String sql = "delete from MONKEY_CATEGORY where CATE_ID = ?";

        Object[] params = {id};

        return BaseDao.exectuIUD(sql, params);
    }

    //通过id查询
    public static MONKEY_CATEGORY selectById(int id) {
        MONKEY_CATEGORY cate = null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = BaseDao.getconn();

        PreparedStatement ps = null;

        try {
            String sql = "select * from MONKEY_CATEGORY where CATE_ID = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);


            rs = ps.executeQuery();

            while (rs.next()) {
                cate = new MONKEY_CATEGORY(rs.getInt("CATE_ID"),
                        rs.getString("CATE_NAME"),
                        rs.getInt("CATE_PARENT_ID")

                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }

        return cate;
    }


}
