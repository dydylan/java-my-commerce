package com.example.mycommerce.dao;


import com.example.mycommerce.dao.MyProductDao;
import com.example.mycommerce.dao.jdbc.ConnectionManager;
import com.example.mycommerce.dao.jdbc.JdbcMyProductDao;
import com.example.mycommerce.dao.jpa.JpaMyProductDao;
import com.example.mycommerce.dao.jpa.PersistenceManager;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static MyProductDao getCarDao() {
//        return new MemoryCarDao();
//        return new JdbcCarDao(ConnectionManager.getConnection());
        return new JpaMyProductDao(PersistenceManager.getConnection());
    }


//    public static SellerDao getSellerDao() {
//        return new JdbcSellerDao();
//    }
}