package com.example.FinalProject.service;

import com.example.FinalProject.repository.TradeRepository;
import org.springframework.stereotype.Service;

@Service
public class TradeService {
    private final TradeRepository tradeRepository;

    public TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }
}
