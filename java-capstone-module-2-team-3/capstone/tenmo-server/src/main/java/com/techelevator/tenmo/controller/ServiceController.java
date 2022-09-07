package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.UserServiceDao;
import com.techelevator.tenmo.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class ServiceController {

    @Autowired
    private UserServiceDao serviceDao;

    @Autowired
    public ServiceController(UserServiceDao serviceDao){
        this.serviceDao = serviceDao;
    }

    @RequestMapping(path = "/allTransfers", method = RequestMethod.GET)
    public List<Service> getAllTransfers() {
        List<Service> output = serviceDao.getAllTransfers();
        return output;
    }

    @RequestMapping(path = "/service/{id}", method = RequestMethod.GET)
    public Service getSelectedTransfer(@PathVariable int id) {
        return serviceDao.getTransferById(id);

    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @RequestMapping(path = "/sendingTransfers", method = RequestMethod.POST)
    public  String sendTransferRequest(@RequestBody Service service) {
       return  serviceDao.sendTransfers(service.getAccountFrom(), service.getAccountTo(), service.getAmount());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @RequestMapping(path = "/requestTransfers", method = RequestMethod.POST)
    public String requestMoney(@RequestBody Service service) {
        return  serviceDao.requestTransfers(service.getAccountFrom(), service.getAccountTo(), service.getAmount());
    }

    @RequestMapping(path="/pending/{userId}", method = RequestMethod.GET)
    public List<Service> getPendingTransfersByUserId(@PathVariable int userId) {
        return serviceDao.getPendingRequests(userId);
    }

}