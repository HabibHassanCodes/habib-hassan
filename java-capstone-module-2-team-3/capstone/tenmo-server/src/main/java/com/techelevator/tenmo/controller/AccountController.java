package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.UserAccountDao;
import com.techelevator.tenmo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/account")
public class AccountController {
        @Autowired
        private UserAccountDao accountDao;


        @Autowired
        public AccountController(UserAccountDao accountDao){
            this.accountDao = accountDao;

        }

    @RequestMapping(path ="/{userId}", method = RequestMethod.GET)
    public BigDecimal getBalance(@PathVariable int userId){
            return accountDao.getBalance(userId);
    }


    @RequestMapping(path ="/add/{accountId}", method = RequestMethod.PUT)
    public boolean addBalance(@PathVariable int accountId, BigDecimal money){
             return accountDao.addBalanceUpdate2(accountId,money);
    }
    @RequestMapping(path ="/subtract/{userId}", method = RequestMethod.PUT)
    public boolean subtractBalance(@PathVariable int userId, BigDecimal money){
            return accountDao.subtractBalanceUpdate2(userId,money);
    }
    @RequestMapping(path ="/find/{accountId}", method = RequestMethod.GET)
    public Account findAccountById(@PathVariable int accountId) {
            return accountDao.findAccountById(accountId);
    }

    @RequestMapping(path ="/user/{userId}", method = RequestMethod.GET)
    public Account findUserById(@PathVariable int userId){
            return accountDao.findUserById(userId);
    }

    @RequestMapping(path ="/find/{userId}", method = RequestMethod.GET)
    public Account getUserId(@PathVariable int userId){
        return accountDao.findAccountById(userId);
    }

    @RequestMapping(path ="/accountById/{accountId}", method = RequestMethod.GET)
    public Account getAccountByAccountId(@PathVariable int accountId){
        return accountDao.findUserById(accountId);
    }
}
