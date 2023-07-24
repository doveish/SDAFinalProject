package com.example.FinalProject.service;

import com.example.FinalProject.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {
   private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
}
