package com.example.FinalProject.controller;

import com.example.FinalProject.service.StockService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
}
