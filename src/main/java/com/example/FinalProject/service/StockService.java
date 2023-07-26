package com.example.FinalProject.service;

import com.example.FinalProject.model.Dividend;
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
        Stock savedStock = toStock(stock);
        return stockRepository.save(stock);
    }

    private Stock toStock(Stock stock) {
        return Stock.builder()
                .id(stock.getId())
                .symbol(stock.getSymbol())
                .stockName(stock.getStockName())
                .account(stock.getAccount())
                .currentPrice(stock.getCurrentPrice())
                .totalAmount(stock.getTotalAmount())
                .averagePrice(stock.getAveragePrice())
                .currentValue(stock.getCurrentValue())
                .profitLoss(stock.getProfitLoss())
                .build();
    }

    public Stock getStockByStockSymbol(String symbol) {
        Stock stock = stockRepository.findStockBySymbol(symbol);
        return stock;
    }



}
