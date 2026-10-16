package com.example.SampleProject.repository;

import com.example.SampleProject.entity.FinanceAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceAccountRepository extends JpaRepository<FinanceAccount, Long> {
}
