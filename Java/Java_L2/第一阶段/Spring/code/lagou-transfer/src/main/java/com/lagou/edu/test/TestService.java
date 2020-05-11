package com.lagou.edu.test;

import com.lagou.edu.config.MyAutowired;
import com.lagou.edu.config.MyService;

@MyService
public class TestService {

    @MyAutowired
    private AgainService againService;

    public void add(){
        System.out.println("这是一个打印用语句,");
        againService.again();
    }
}
