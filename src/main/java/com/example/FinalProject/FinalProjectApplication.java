package com.example.FinalProject;

import com.example.FinalProject.model.Account;
import com.example.FinalProject.model.Stock;
import com.example.FinalProject.repository.AccountRepository;
import com.example.FinalProject.repository.DividendRepository;
import com.example.FinalProject.repository.StockRepository;
import com.example.FinalProject.repository.TradeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

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


        Account account1 = new Account();
        Account account2 = new Account();

        System.out.println("List of all accounts: " + accountRepository.findAll());
        accountRepository.save(account1);
        accountRepository.save(account2);
        System.out.println("List of all accounts: " + accountRepository.findAll());

        Stock stock1 = new Stock();
        Stock stock2 = new Stock();

        stockRepository.save(stock1);
        stockRepository.save(stock2);

        System.out.println(stockRepository.findAll());


    }
}
