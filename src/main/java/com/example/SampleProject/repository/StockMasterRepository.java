package com.example.SampleProject.repository;

import com.example.SampleProject.entity.StockMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockMasterRepository extends JpaRepository<StockMaster, Long> {
    Optional<StockMaster> findByItemNameIgnoreCase(String itemName);
}
