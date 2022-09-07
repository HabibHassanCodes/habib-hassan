package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Service;

import java.math.BigDecimal;
import java.util.List;

public interface UserServiceDao {

    List<Service> getAllTransfers();
    Service getTransferById(int id);
    String sendTransfers(int userFrom, int userTo, BigDecimal amount);
    String requestTransfers(int userFrom, int userTo, BigDecimal amount);
    List<Service> getPendingRequests(int userId);

}
