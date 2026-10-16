package com.example.SampleProject.controller;

import com.example.SampleProject.entity.CustomerMaster;
import com.example.SampleProject.entity.FinanceMaster;
import com.example.SampleProject.service.FinanceMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api-finance-master")
public class FinanceMasterController {

    public static final Logger log = LoggerFactory.getLogger(FinanceMasterController.class);
    @Autowired
    private FinanceMasterService financeMasterService;

    public FinanceMasterController(FinanceMasterService financeMasterService){
        this.financeMasterService = financeMasterService;
    }

    @GetMapping("/{id}")
    private FinanceMaster getFinanceId(@PathVariable Long id){
        return financeMasterService.getFinanceId(id);

    }

    @PostMapping
    private ResponseEntity<FinanceMaster> createFinance(@RequestBody FinanceMaster financeMaster){
        FinanceMaster createFinance = financeMasterService.createFinance(financeMaster);
        log.info("Entry logged successfully" + financeMaster);
        return new ResponseEntity<>(createFinance, HttpStatus.CREATED);
    }

}
