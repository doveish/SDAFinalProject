package com.example.FinalProject.service;

import com.example.FinalProject.model.Account;
import com.example.FinalProject.model.Stock;
import com.example.FinalProject.model.Trade;
import com.example.FinalProject.repository.StockRepository;
import com.example.FinalProject.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private TradeRepository tradeRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getFullPortfolio() {
        return stockRepository.findAll();
    }

    public Stock findStockById(Long id) {
        return stockRepository.findById(id).orElseThrow();
    }

    public Stock save(Stock stock) {
        Stock savedStock = toStock(stock);
        return stockRepository.save(stock);
    }

    public Stock save(Account account, Stock stock) {
        stock.setAccount(account);
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

    //WILL BE CALCULATED IN FRONT-END!

//    public Stock getAveragePriceForStockBySymbol(String symbol) {
//        Stock stock = stockRepository.findStockBySymbol(symbol);
//        List<Trade> tradeList = tradeRepository.findTradeByStockSymbol(symbol);
//
//        BigDecimal totalTradeSum = BigDecimal.ZERO;
//
//        for (Trade trade : tradeList) {
//            BigDecimal tradeSum = trade.getTradeSum();
//            totalTradeSum = totalTradeSum.add(tradeSum);
//        }
//
//        BigDecimal totalAmount = stock.getTotalAmount();
//        BigDecimal averageBuyPrice = totalTradeSum.divide(totalAmount, 2, RoundingMode.HALF_UP);
//        stock.setAveragePrice(averageBuyPrice);
//        return stock;
//    }


}
