package com.monkey.service;

import com.monkey.dao.BaseDao;
import com.monkey.entity.MONKEY_USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MONKEY_USERDao {
    /**
     * 加入数据库
     *
     * @param
     * @return
     */
    public static int insert(MONKEY_USER u) {
        String sql = "insert into MONKEY_USER (USER_ID,USER_NAME,USER_PASSWORD,USER_SEX,USER_BIRTHDAY,USER_IDENTITY_CODE,USER_EMAIL,USER_MOBILE,USER_ADDRESS,USER_STATUS) values(?, ?, ?, ?, DATE_FORMAT(?, '%Y-%m-%d'), ?, ?, ?, ?, ?)";

        Object[] params = new Object[]{
                u.getUSER_ID(),
                u.getUSER_NAME(),
                u.getUSER_PASSWORD(),
                u.getUSER_SEX(),
                u.getUSER_BIRTHDAY(),
                u.getUSER_IDENTITY_CODE(),
                u.getUSER_EMAIL(),
                u.getUSER_MOBILE(),
                u.getUSER_ADDRESS(),
                u.getUSER_STATUS()
        };

        return BaseDao.exectuIUD(sql, params);

    }

    /**
     * 获取总页数和总记录数
     *
     * @param count
     * @return
     */

    public static int[] totalPage(int count) {
        //0 总记录数  1 总页数
        int[] arr = {0, 1};
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from MONKEY_USER";
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

    public static ArrayList<MONKEY_USER> selectAll(int cpage, int count, String keywords) {
        ArrayList<MONKEY_USER> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = BaseDao.getconn();

        PreparedStatement ps = null;

        try {
            String sql = "";
            if (keywords != null) {
                sql = "select * from MONKEY_USER where USER_ID like ? order by USER_ID asc limit ?, ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keywords + "%");
                ps.setInt(2, (cpage - 1) * count);
                ps.setInt(3, count);
            } else {
                sql = "select * from MONKEY_USER order by USER_UPDATETIME asc limit ?, ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, (cpage - 1) * count);
                ps.setInt(2, count);
            }


            rs = ps.executeQuery();

            while (rs.next()) {
                MONKEY_USER u = new MONKEY_USER(rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("USER_BIRTHDAY"),
                        rs.getString("USER_IDENTITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),
                        rs.getString("USER_ADDRESS"),
                        rs.getInt("USER_STATUS"),
                        rs.getString("USER_UPDATETIME")

                );
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }

        return list;
    }
}
