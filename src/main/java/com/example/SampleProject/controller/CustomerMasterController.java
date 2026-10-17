package com.example.SampleProject.controller;

import com.example.SampleProject.entity.CustomerMaster;
import com.example.SampleProject.service.CustomerMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1/customer-master")
public class CustomerMasterController {
    public static final Logger log = LoggerFactory.getLogger(CustomerMasterController.class);
    @Autowired
    private  CustomerMasterService customerMasterService;

    public CustomerMasterController(CustomerMasterService customerMasterService){
        this.customerMasterService = customerMasterService;
    }

    @GetMapping("/list-view")
    private List<CustomerMaster> getAllCustomer(){
        log.info("Fetched all entries");
        return customerMasterService.getAllCustomer();
    }

    @GetMapping
    private CustomerMaster getCustomerById(@RequestParam Long id){
        return customerMasterService.getCustomerById(id);
    }


    @PostMapping
    private ResponseEntity<CustomerMaster> createCustomer(@RequestBody CustomerMaster customerMaster){
        CustomerMaster createCustomer = customerMasterService.createCustomer(customerMaster);
        log.info("Entry logged successfully" + customerMaster);
        return new ResponseEntity<>(createCustomer, HttpStatus.CREATED);
    }


}
