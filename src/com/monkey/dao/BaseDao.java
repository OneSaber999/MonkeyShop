package com.monkey.dao;

import java.sql.*;

public class BaseDao {

    static {
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getconn()  {
        //创建一个连接对象
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/monkeyshop?useSSL=false&serverTimezone=UTC","root","123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static int exectuIUD(String sql,Object[] params) {
        int count = 0;

        Connection conn = BaseDao.getconn();

        //准备sql
        PreparedStatement ps = null;

        //insert into user()
        try {
            //准备sql
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1,params[i]);
            }

            count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeall(null,ps,conn);
        }

        return count;

    }
    public static void closeall(ResultSet rs,PreparedStatement ps,Connection conn) {

            try {
                if (rs != null){
                    rs.close();
                }

                if (ps != null){
                    ps.close();
                }

                if (conn != null){
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }



    }
}
