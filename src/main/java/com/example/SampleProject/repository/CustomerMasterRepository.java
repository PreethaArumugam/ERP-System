package com.example.SampleProject.repository;

import com.example.SampleProject.entity.CustomerMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Long> {

}
