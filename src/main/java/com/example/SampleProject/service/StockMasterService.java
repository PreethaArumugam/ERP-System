package com.example.SampleProject.service;

import com.example.SampleProject.entity.StockMaster;
import com.example.SampleProject.repository.StockMasterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockMasterService {

    @Autowired
    private StockMasterRepository stockMasterRepository;

    public StockMasterService(StockMasterRepository stockMasterRepository){
        this.stockMasterRepository = stockMasterRepository;
    }

    public List<StockMaster> getAllStock(){
        return stockMasterRepository.findAll();
    }

    public StockMaster getStockByItemName(String itemName){
        return stockMasterRepository.findByItemNameIgnoreCase(itemName).orElseThrow(()->
                new EntityNotFoundException("Stock not found" + itemName));
    }

    public StockMaster getStockById(Long id){
        return stockMasterRepository.findById(id).orElseThrow(()->
                new RuntimeException("Stock ID not found" + id));
    }

    public StockMaster createStock(StockMaster stockMaster){
        return stockMasterRepository.save(stockMaster);
    }

    public StockMaster updateStock(Long id, StockMaster stockMaster){
        if(stockMasterRepository.existsById(id)){
            stockMaster.setId(id);
            return stockMasterRepository.save(stockMaster);
        }else {
            throw new RuntimeException("Stock id not found" + id);
        }
    }

    public void deleteStock(Long id){
        stockMasterRepository.deleteById(id);
    }
}
