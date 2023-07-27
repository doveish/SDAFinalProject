package com.example.FinalProject.service;

import com.example.FinalProject.model.Stock;
import com.example.FinalProject.model.Trade;
import com.example.FinalProject.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeService {
    @Autowired
    private TradeRepository tradeRepository;

    public TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public List<Trade> getFullTradeList() {
        return tradeRepository.findAll();
    }

    public Trade save(Trade trade) {
        Trade savedTrade = toTrade(trade);
        return tradeRepository.save(trade);
    }

    private Trade toTrade(Trade trade) {
        return Trade.builder()
                .id(trade.getId())
                .tradeType(trade.getTradeType())
                .stock(trade.getStock())
                .date(trade.getDate())
                .amount(trade.getAmount())
                .unitPrice(trade.getUnitPrice())
                .commission(trade.getCommission())
                .tradeSum(trade.getTradeSum())
                .comment(trade.getComment())
                .build();
    }

    public List<Trade> getTradeListByStockSymbol(String symbol) {
        Trade trade = tradeRepository.findTradeByStockSymbol(symbol);
        List<Trade> tradeList = new ArrayList<>();
        tradeList.add(trade);
        return tradeList;
    }
}
