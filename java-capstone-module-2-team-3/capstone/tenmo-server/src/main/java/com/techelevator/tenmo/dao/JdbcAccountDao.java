package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.RowSet;
import java.math.BigDecimal;
@Component
public class JdbcAccountDao implements UserAccountDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BigDecimal getBalance(int userId)  {
        String Sql = "SELECT account_id, balance, user_id FROM account WHERE user_id = ?;";
        Account account =null;
        SqlRowSet result = jdbcTemplate.queryForRowSet(Sql, userId);
        if (result.next()) {
            account  = mapRowToAccount(result);
            account.getBalance();
        }

        return account.getBalance();
    }

//    public BigDecimal addBalance(int accountId,BigDecimal money){
//        String sql ="SELECT accountId, userId, balance FROM account WHERE account_id = ?;";
//        Account account = null;
//        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, accountId);
//        if (result.next()){
//            account =mapRowToAccount(result);
//
//        }
//        return account.getBalance().add(money);
//    }

//    public Account addBalanceUpdate(int accountId , BigDecimal money){
//        Account account =null;
//        String sql= "UPDATE account " +
//                    "SET balance = balance + ? " +
//                    "WHERE account_id = ? ;";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, money, accountId);
//        if(results.next()){
//            account = mapRowToAccount(results);
//        }
//        return account;
//    }

    @Override
    public boolean addBalanceUpdate2(int userId, BigDecimal money) {
        Account account = getAnAccountByUserId(userId);
        boolean updated = false;
        if(account.getUserId()== userId){
        String sql = "UPDATE account " +
                "SET balance = balance + ? " +
                "WHERE account_id = ? ;";
      jdbcTemplate.update(sql, money, userId);
      System.out.println("$"+money +" have been sent to User: "+ userId + "'s account");
      updated = true;
    }
        return updated;
    }


//    public BigDecimal subtractBalance(int accountId, BigDecimal money){
//        String sql ="SELECT balance FROM account WHERE account_id = ?;";
//        Account account = null;
//        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, accountId);
//        if (result.next()){
//            account =mapRowToAccount(result);
//        }
//        return account.getBalance().subtract(money);
//    }

//    public Account  subtractBalanceUpdate(int accountId , BigDecimal money) {
//        Account account = null;
//        String sql = "UPDATE account " +
//                "SET balance = balance - ? " +
//                "WHERE account_id = ?; ";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, money, accountId);
//        if(results.next()){
//            account = mapRowToAccount(results);
//        }
//        return account;
//    }

    @Override
    public boolean  subtractBalanceUpdate2(int userId , BigDecimal money) {
        Account account = getAnAccountByUserId(userId);
        boolean updated = false;
        if(account.getUserId()== userId){
        String sql = "UPDATE account " +
                "SET balance = balance - ? " +
                "WHERE account_id = ?; ";
        jdbcTemplate.update(sql, money, userId);
        System.out.println("$"+money +" have been transferred out User: "+ userId + "'s account");
        updated =true;
    }
        return updated;
    }

    @Override
    public Account getAnAccountByUserId(int userId){
        Account account = null;
        String sql ="SELECT account_id, balance, user_id " +
                "FROM account " +
                "WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if(results.next()){
            account =mapRowToAccount(results);
        }
        return  account;
    }

    @Override
    public Account findAccountById(int accountId) {
        String sql = "SELECT account_id, balance, user_id FROM account WHERE user_id = ?;";
        Account account = null;
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, accountId);
        if (result.next()) {
            account = mapRowToAccount(result);
        }
        return account;
    }

    @Override
    public Account findUserById(int userId){
        String sql="SELECT account_id, balance, user_id FROM account WHERE account_id = ?;";
        Account account =null;
        SqlRowSet result= jdbcTemplate.queryForRowSet(sql, userId);
        if(result.next()){
            account = mapRowToAccount(result);
        }
        return account;
    }

    private Account mapRowToAccount(SqlRowSet rs) {
        Account account = new Account();
        account.setAccountId(rs.getInt("account_id"));
        account.setBalance(rs.getBigDecimal("balance"));
        account.setUserId(rs.getInt("user_id"));
        return account;
}
}

