package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import java.math.BigDecimal;

public interface UserAccountDao {
     BigDecimal getBalance(int userId);
     boolean  addBalanceUpdate2(int userId , BigDecimal money);
     boolean  subtractBalanceUpdate2(int userId , BigDecimal money);
     Account findAccountById(int accountId);
     Account findUserById(int userId);
     Account getAnAccountByUserId(int userId);
}
