package com.example.SampleProject.controller;

import com.example.SampleProject.entity.CompanyMaster;
import com.example.SampleProject.service.CompanyMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company-master")
public class CompanyMasterController {

    private static final Logger log = LoggerFactory.getLogger(CompanyMasterController.class);

    @Autowired
    private CompanyMasterService companyMasterService;

    public CompanyMasterController(CompanyMasterService companyMasterService){
        this.companyMasterService = companyMasterService;
    }

    @GetMapping("/{id}")
    private CompanyMaster getCompanyById(@PathVariable Long id){
        return companyMasterService.getCompanyById(id);
    }

    @GetMapping("/list-view")
    private List<CompanyMaster> getAllCompany(){
        log.info("fetched all entries");
        return companyMasterService.getAllCompany();
    }

    @PostMapping
    private ResponseEntity<CompanyMaster> createCompany(@RequestBody CompanyMaster companyMaster){
        CompanyMaster createCompany = companyMasterService.createCompany(companyMaster);
        log.info("Company updated successfully " + companyMaster);
        return new ResponseEntity<>(createCompany, HttpStatus.CREATED);
    }

}
