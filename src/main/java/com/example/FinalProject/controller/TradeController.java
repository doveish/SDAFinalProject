package com.example.FinalProject.controller;

import com.example.FinalProject.service.TradeService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {
    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }
}
