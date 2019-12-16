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


}
