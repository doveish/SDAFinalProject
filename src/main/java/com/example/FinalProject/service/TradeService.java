package com.example.FinalProject.service;

import com.example.FinalProject.model.Stock;
import com.example.FinalProject.model.Trade;
import com.example.FinalProject.repository.TradeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeService {
    private final TradeRepository tradeRepository;

    public TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public List<Trade> getFullTradeList() {
        return tradeRepository.findAll();
    }

    public Trade save(Trade trade) {
        return tradeRepository.save(trade);
    }

    public List<Trade> getTradeListByStockSymbol(String symbol) {
        Trade trade = tradeRepository.findTradeByStockSymbol(symbol);
        List<Trade> tradeList = new ArrayList<>();
        tradeList.add(trade);
        return tradeList;
    }
}
