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
     * @param u
     * @return
     */
    public static int insert(MONKEY_USER u){
        String sql = "insert into MONKEY_USER values(?, ?, ?, ?, DATE_FORMAT(?, '%Y-%m-%d'), ?, ?, ?, ?, ?)";

        Object[] params = new Object[]{
                u.getUSER_ID(),
                u.getUSER_NAME(),
                u.getUSER_PASSWORD(),
                u.getUSER_SEX(),
                u.getUSER_BIRTHDAY(),
                u.getUSER_EMAIL(),
                u.getUSER_IDENITY_CODE(),
                u.getUSER_MOBILE(),
                u.getUSER_ADDRESS(),
                u.getUSER_STATUS()
        };

        return BaseDao.exectuIUD(sql,params);

    }

    /**
     * 获取总页数和总记录数
     * @param count
     * @return
     */

    public static int[] totalPage(int count){
        //0 总记录数  1 总页数
        int[] arr = {0,1};
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs= null;
        try {
            String sql = "select count(*) from MONKEY_USER";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
               arr[0] = rs.getInt(1);
               if (arr[0] % count == 0){
                   arr[1] = arr[0] / count;
               }else {
                   arr[1] = arr[0] / count + 1;
               }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeall(rs,ps,conn);
        }
        return arr;

    }

    public static ArrayList<MONKEY_USER> selectAll() {
        ArrayList<MONKEY_USER> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = BaseDao.getconn();

        PreparedStatement ps = null;

        try {
            String sql = "select * from MONKEY_USER order by USER_BIRTHDAY";
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                MONKEY_USER u = new MONKEY_USER(rs.getString("USER_ID"),
                                                rs.getString("UESR_NAME"),
                                                rs.getString("UESR_PASSWORD"),
                                                rs.getString("UESR_SEX"),
                                                rs.getString("UESR_BIRTHDAY"),
                                                rs.getString("UESR_IDENITY_CODE"),
                                                rs.getString("UESR_EMAIL"),
                                                rs.getString("UESR_MOBILE"),
                                                rs.getString("UESR_ADDRESS"),
                                                rs.getInt("UESR_STATUS"));
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeall(rs,ps,conn);
        }

        return list;
    }
}
