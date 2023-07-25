package com.example.FinalProject.controller;

import com.example.FinalProject.model.Account;
import com.example.FinalProject.model.Stock;
import com.example.FinalProject.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Stock stock = stockService
                .getStockByStockSymbol(symbol);
        return stock;
    }

}
