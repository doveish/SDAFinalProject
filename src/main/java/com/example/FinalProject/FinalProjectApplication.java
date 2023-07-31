package com.example.FinalProject;

import com.example.FinalProject.model.Stock;
import com.example.FinalProject.model.Trade;
import com.example.FinalProject.repository.AccountRepository;
import com.example.FinalProject.repository.DividendRepository;
import com.example.FinalProject.repository.StockRepository;
import com.example.FinalProject.repository.TradeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class FinalProjectApplication implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final DividendRepository dividendRepository;
    private final StockRepository stockRepository;
    private final TradeRepository tradeRepository;

    public FinalProjectApplication(AccountRepository accountRepository, DividendRepository dividendRepository, StockRepository stockRepository, TradeRepository tradeRepository) {
        this.accountRepository = accountRepository;
        this.dividendRepository = dividendRepository;
        this.stockRepository = stockRepository;
        this.tradeRepository = tradeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {

    }
}
