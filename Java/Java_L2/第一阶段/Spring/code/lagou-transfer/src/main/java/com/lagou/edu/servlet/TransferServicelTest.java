package com.lagou.edu.servlet;

import com.lagou.edu.config.MyService;
import com.lagou.edu.dao.AccountDao;
import com.lagou.edu.factory.BeanFactory;
import com.lagou.edu.pojo.Account;

@MyService
public class TransferServicelTest {

    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");


    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {

        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);

        from.setMoney(from.getMoney()-money);
        to.setMoney(to.getMoney()+money);

        accountDao.updateAccountByCardNo(to);
//            int c = 1/0;
        accountDao.updateAccountByCardNo(from);
    }

}
