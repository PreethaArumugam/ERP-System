package com.example.SampleProject.controller;


import com.example.SampleProject.entity.StockMaster;
import com.example.SampleProject.repository.StockMasterRepository;
import com.example.SampleProject.service.StockMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/stock-master")
public class StockMasterController {

    public static final Logger log = LoggerFactory.getLogger(StockMasterController.class);
    @Autowired
    private StockMasterService stockMasterService;

    @GetMapping("/list-view")
    private List<StockMaster> getAllStock(){
        log.info("Fetched all Stock Entries");
        return stockMasterService.getAllStock();
    }

    @GetMapping("/")
    private List<StockMaster> getAllStocks(){
        log.info("Fetched all Stock Entries");
        return stockMasterService.getAllStock();
    }

    @GetMapping("/item")
    private StockMaster getStockByItemName(@RequestParam String itemName){
        return stockMasterService.getStockByItemName(itemName);
    }

    @GetMapping("/by-id/{id}")
    private StockMaster getStockById(@PathVariable Long id){
        return stockMasterService.getStockById(id);
    }

    @PostMapping("/save")
    private ResponseEntity<StockMaster> createStock(@RequestBody StockMaster stockMaster){
        StockMaster createStock = stockMasterService.createStock(stockMaster);
        log.info("Entry logged successfully" + stockMaster);
        return new ResponseEntity<> (createStock, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<StockMaster> updateStock(@PathVariable Long id, @RequestBody StockMaster stockMaster){
        StockMaster updateStock = stockMasterService.updateStock(id, stockMaster);
        if(updateStock != null){
            log.info("Entry updated successfully" + stockMaster);
            return new ResponseEntity<>(updateStock, HttpStatus.OK);
        }
        else{
            log.info("Entry not found" + stockMaster);
            return new ResponseEntity<>(updateStock, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Void> deleteStock(@PathVariable Long id){
        stockMasterService.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
