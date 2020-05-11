package com.lagou.edu.test;

import com.lagou.edu.service.impl.TransferServiceImpl;
import com.lagou.edu.utils.MyApplicationContext;

public class TestServlet {

    public static void main(String[] args) throws Exception {
        MyApplicationContext app = new MyApplicationContext("com.lagou.edu.test");
//        TransferServiceImpl transferService = (TransferServiceImpl) app.getBean("transferServiceImpl");
//        transferService.transfer("6029621011000","6029621011001",100);
        TestService testService = (TestService) app.getBean("testService");
        testService.add();
        System.out.println(testService);
    }


}
