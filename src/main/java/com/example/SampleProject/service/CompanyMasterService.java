package com.example.SampleProject.service;

import com.example.SampleProject.entity.CompanyMaster;
import com.example.SampleProject.repository.CompanyMasterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyMasterService {

    @Autowired
    private CompanyMasterRepository companyMasterRepository;

    public CompanyMaster getCompanyById(Long id){
        return companyMasterRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("company not found"+ id));
    }

    public List<CompanyMaster> getAllCompany(){
        return companyMasterRepository.findAll();
    }

    public CompanyMaster createCompany(CompanyMaster companyMaster){
        return companyMasterRepository.save(companyMaster);
    }
}
