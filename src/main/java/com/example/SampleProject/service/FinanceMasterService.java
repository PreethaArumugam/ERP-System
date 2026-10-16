package com.example.SampleProject.service;

import com.example.SampleProject.entity.CustomerMaster;
import com.example.SampleProject.entity.FinanceMaster;
import com.example.SampleProject.repository.CustomerMasterRepository;
import com.example.SampleProject.repository.FinanceMasterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinanceMasterService {

    @Autowired
    private FinanceMasterRepository financeMasterRepository;

    public FinanceMasterService(FinanceMasterRepository financeMasterRepository){
        this.financeMasterRepository = financeMasterRepository;
    }

    public FinanceMaster getFinanceId(Long id ){
        return financeMasterRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Customer not found" + id));

    }

    public FinanceMaster createFinance(FinanceMaster financeMaster) {
        return financeMasterRepository.save(financeMaster);
    }
}
