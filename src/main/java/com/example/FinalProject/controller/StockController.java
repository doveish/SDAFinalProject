package com.example.FinalProject.controller;

import com.example.FinalProject.model.Account;
import com.example.FinalProject.model.Dividend;
import com.example.FinalProject.model.Stock;
import com.example.FinalProject.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getFullPortfolio() {
        return stockService.getFullPortfolio();
    }

    @GetMapping(path = "/{symbol}")
    public Stock getStockByStockSymbol(@PathVariable("symbol") String symbol) {
        Stock stock = stockService.getStockByStockSymbol(symbol);
        return stock;
    }

    @PostMapping("/add-stock")
    public Stock addStock(Stock stock) {
        return stockService.save(stock);
    }

}
