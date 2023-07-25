package com.example.FinalProject.service;

import com.example.FinalProject.model.Stock;
import com.example.FinalProject.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
   private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getFullPortfolio() {
        return stockRepository.findAll();
    }

    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock getStockByStockSymbol(String symbol) {
        Stock stock = stockRepository.findStockByStockSymbol(symbol);
        return stock;
    }
}
