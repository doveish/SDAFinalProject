package com.example.FinalProject.service;

import com.example.FinalProject.model.Account;
import com.example.FinalProject.model.Stock;
import com.example.FinalProject.model.Trade;
import com.example.FinalProject.model.Transaction;
import com.example.FinalProject.model.enums.TradeType;
import com.example.FinalProject.repository.AccountRepository;
import com.example.FinalProject.repository.StockRepository;
import com.example.FinalProject.repository.TradeRepository;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Trade save(Stock stock, Trade trade) {
        trade.setStock(stock);
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
        } else {
            if (trade.getTradeType().equalsIgnoreCase("SELL") && trade.getAmount().compareTo(stock.getTotalAmount()) > 0) {
                throw new IllegalStateException("Quantity of transaction exceeds available stock amount");
            }
            totalStockAmount = stock.getTotalAmount().subtract(trade.getAmount());
        }

        Trade newTrade = new Trade();
        newTrade.setTradeType(trade.getTradeType());
        newTrade.setAmount(trade.getAmount());
        newTrade.setStock(stock);
        newTrade.setDate(LocalDate.now());
        newTrade.setUnitPrice(trade.getUnitPrice());
        newTrade.setCommission(trade.getCommission());
        newTrade.setComment(trade.getComment());
        newTrade.setTradeSum(trade.getTradeSum());

        BigDecimal averagePrice = (trade.getUnitPrice().multiply(trade.getAmount())).divide(trade.getAmount());

        stock.setTotalAmount(totalStockAmount);
        stock.setAccount(account);

        stock.setAveragePrice(averagePrice);
        stock.setCurrentPrice(trade.getUnitPrice());//
        stock.setCurrentValue(totalStockAmount.multiply(trade.getUnitPrice()));//UnitPrice should come from an external API

        return trade;
    }
}
