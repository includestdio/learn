package com.lagou.edu.test;

import com.lagou.edu.utils.MyApplicationContext;

public class TestServlet {

    public static void main(String[] args) throws Exception {
        MyApplicationContext app = new MyApplicationContext("com.lagou.edu.test");
        TestService userService = (TestService) app.getBean("testService");
        userService.add();
        System.out.println(userService);
    }
}
