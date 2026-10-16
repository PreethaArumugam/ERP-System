package com.example.SampleProject.repository;

import com.example.SampleProject.entity.BranchMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchMasterRepository extends JpaRepository<BranchMaster, Long> {
}
