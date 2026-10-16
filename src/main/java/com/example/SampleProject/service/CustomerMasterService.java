package com.example.SampleProject.service;

import com.example.SampleProject.entity.CustomerMaster;
import com.example.SampleProject.repository.CustomerMasterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerMasterService {

    @Autowired
    private CustomerMasterRepository customerMasterRepository;

    public CustomerMasterService(CustomerMasterRepository customerMasterRepository){
        this.customerMasterRepository = customerMasterRepository;
    }

    public List<CustomerMaster> getAllCustomer(){
        return customerMasterRepository.findAll();
    }

    public CustomerMaster getCustomerById(Long id ){
        return customerMasterRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Customer not found" + id));

    }

    public CustomerMaster createCustomer(CustomerMaster customerMaster) {
        return customerMasterRepository.save(customerMaster);
    }

}
