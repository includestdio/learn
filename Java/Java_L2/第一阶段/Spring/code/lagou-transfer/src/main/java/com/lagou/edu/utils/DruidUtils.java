package com.lagou.edu.utils;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author 应癫
 */
public class DruidUtils {

    private DruidUtils(){
    }

    private static DruidDataSource druidDataSource = new DruidDataSource();


    static {
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://123.56.242.6:3306/learn");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("Wsf19960728@");

    }

    public static DruidDataSource getInstance() {
        return druidDataSource;
    }

}
