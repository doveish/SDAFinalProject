package com.example.FinalProject.controller;

import com.example.FinalProject.model.Account;
import com.example.FinalProject.model.Dividend;
import com.example.FinalProject.model.Stock;
import com.example.FinalProject.service.AccountService;
import com.example.FinalProject.service.StockService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private AccountService accountService;

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
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
        stockService.save(stock);
        return ResponseEntity.ok(stock);
    }

    @PostMapping("/{id}/stock")
    public ResponseEntity<Stock> createStock(@PathVariable("id") Long accountId, @RequestBody Stock stock) {
        Account account = accountService.getAccountById(accountId);
        Stock savedStock = stockService.save(account,stock);
        return ResponseEntity.ok(savedStock);
    }

}
