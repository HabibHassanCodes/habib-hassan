package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Service;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcServiceDao implements UserServiceDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JdbcAccountDao jdbcAccountDao;

    public JdbcServiceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Service> getAllTransfers() {
        List<Service> list = new ArrayList<>();

        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount "+
                "FROM transfer;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Service service = mapRowToService(results);
            list.add(service);
        }
        return list;
    }

    @Override
    public Service getTransferById(int id) {
        Service service = null;

        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount " +
                "FROM transfer "+
                "WHERE transfer_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
        if (rowSet.next()){
            service = mapRowToService(rowSet);
        }

        return service;
    }

    @Override
    public String sendTransfers(int userFrom, int userTo, BigDecimal amount) {
        if (userFrom == userTo) {
            return "You are not allowed to send money to yourself";
        }
//        if (amount.compareTo(jdbcAccountDao.getBalance(userFrom)) == -1 || amount.compareTo(jdbcAccountDao.getBalance(userFrom)) == 0) {
//
//            String sql = "INSERT INTO transfer(transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
//                    "VALUES(2,2,?,?,?);";
//            jdbcTemplate.update(sql, userFrom, userTo, amount); //to update the table by inserting or adding another row in the table without dropping any value.
//            jdbcAccountDao.addBalanceUpdate2(userTo, amount); //instantiating account dao and using add balance method.
//            jdbcAccountDao.subtractBalanceUpdate2(userFrom, amount);
//
//            return "You successfully Completed transaction.";
//        } else {
//            return "Not enough fund to send";
//        }

        else{
            try{
                String sql = "INSERT INTO transfer(transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                        "VALUES(2,2,?,?,?);";
                jdbcTemplate.update(sql, userFrom, userTo, amount);
//                jdbcAccountDao.addBalanceUpdate2(userTo, amount); //instantiating account dao and using add balance method.
//                jdbcAccountDao.subtractBalanceUpdate2(userFrom, amount);
                return "You successfully Sent";
            }catch(NullPointerException e){
                return e.getMessage();
            }
        }
    }

    @Override
    public String requestTransfers(int userFrom, int userTo, BigDecimal amount) {
        if (userFrom == userTo) {
            return "You are not allowed to request money to yourself";
        }
        else {
            String sql = "INSERT INTO transfer(transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                    "VALUES(1,1,?,?,?);";
            jdbcTemplate.update(sql, userFrom, userTo, amount);
            return "You successfully Requested";
        }
    }


    @Override
    public List<Service> getPendingRequests(int userId) {
        String sql = "SELECT transfer_id, transfer_type_id, transfer.transfer_status_id, account_from, account_to, amount " +
        "FROM transfer " +
        "JOIN account ON account.account_id = transfer.account_from "+
        "JOIN transfer_status ON transfer.transfer_status_id = transfer_status.transfer_status_id "+
        "WHERE account.user_id = ? AND transfer_status_desc = 'Pending';";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        List<Service> transfers = new ArrayList<>();

        while(results.next()) {
            transfers.add(mapRowToService(results));
        }
        return transfers;
    }

    private Service mapRowToService(SqlRowSet results) {
        Service service = new Service();
        service.setTransferId(results.getInt("transfer_id"));
        service.setTransferTypeId(results.getInt("transfer_type_id"));
        service.setTransferStatusId(results.getInt("transfer_status_id"));
        service.setAccountFrom(results.getInt("account_from"));
        service.setAccountTo(results.getInt("account_to"));
        service.setAmount(results.getBigDecimal("amount"));
         return service;
}
    }