package com.example.FinalProject.service;

import com.example.FinalProject.model.Account;
import com.example.FinalProject.model.Stock;
import com.example.FinalProject.model.Trade;
import com.example.FinalProject.model.Transaction;
import com.example.FinalProject.model.enums.TradeType;
import com.example.FinalProject.repository.AccountRepository;
import com.example.FinalProject.repository.StockRepository;
import com.example.FinalProject.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TradeService {
    @Autowired
    private TradeRepository tradeRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private StockRepository stockRepository;

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
        List<Trade> tradeList = tradeRepository.findTradeByStockSymbol(symbol);
        return tradeList;
    }

    public Trade updateStockBalanceByTradeType(Long id, String stockSymbol, Trade trade) {
        Account account = accountRepository.findById(id).orElse(null);
        Stock stock = stockRepository.findStockBySymbol(stockSymbol);
        BigDecimal totalStockAmount;

        if (trade.getTradeType().equalsIgnoreCase("BUY")) {
            totalStockAmount = trade.getAmount().add(stock.getTotalAmount());
            trade.setTradeType("BUY");

        } else {
            if (trade.getTradeType().equalsIgnoreCase("SELL") && trade.getAmount().compareTo(stock.getTotalAmount()) > 0) {
                throw new IllegalStateException("Quantity of transaction exceeds available stock amount");
            }
            trade.setTradeType("SELL");
            totalStockAmount = stock.getTotalAmount().subtract(trade.getAmount());
        }

        trade.setAmount(trade.getAmount());
        trade.setStock(stock);
        trade.setDate(LocalDate.now());
        trade.setUnitPrice(trade.getUnitPrice());
        trade.setCommission(trade.getCommission());
        trade.setComment(trade.getComment());
        trade.setTradeSum(trade.getTradeSum());

        stock.setTotalAmount(totalStockAmount);
        stock.setAccount(account);
        stockRepository.save(stock);

        return trade;
    }
}
