package com.example.SampleProject.repository;

import com.example.SampleProject.entity.FinanceMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceMasterRepository extends JpaRepository<FinanceMaster, Long> {
}
