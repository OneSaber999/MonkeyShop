package com.monkey.service;

import com.monkey.dao.BaseDao;
import com.monkey.entity.MONKEY_USER;

public class MONKEY_USERDao {
    public static int insert(MONKEY_USER u){
        String sql = "insert into MONKEY_USER values(?, ?, ?, ?, DATE_FORMAT(?, '%Y-%m-%d'), ?, ?, ?, ?, ?)";

        Object[] params = {
                            u.getUSER_ID(),
                            u.getUSER_NAME(),
                            u.getUSER_PASSWORD(),
                            u.getUSER_SEX(),
                            u.getUSER_BIRTHDAY(),
                            u.getUSER_IDENITY_CODE(),
                            u.getUSER_EMAIL(),
                            u.getUSER_MOBILE(),
                            u.getUSER_ADDRESS(),
                            u.getUSER_STSTUS()
        };

        return BaseDao.exectuIUD(sql,params);

    }
}
