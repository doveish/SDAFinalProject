package com.example.FinalProject.service;

import com.example.FinalProject.model.Account;
import com.example.FinalProject.model.Dividend;
import com.example.FinalProject.model.Stock;
import com.example.FinalProject.repository.AccountRepository;
import com.example.FinalProject.repository.DividendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DividendService {

    @Autowired
    private DividendRepository dividendRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<Dividend> getFullDividendList() {
        return dividendRepository.findAll();
    }

    public Dividend save (Dividend dividend) {
        Dividend savedDividend = toDividend(dividend);
        return dividendRepository.save(savedDividend);
    }

    public Dividend save (Dividend dividend, Stock stock) {
        dividend.setStock(stock);
        updateAccountBalanceByReceivedDividend(dividend.getStock().getAccount().getId(), dividend);
        return dividendRepository.save(dividend);
    }

    private Dividend toDividend(Dividend dividend) {
        return Dividend.builder()
                .id(dividend.getId())
                .date(dividend.getDate())
                .stock(dividend.getStock())
                .grossAmount(dividend.getGrossAmount())
                .withholdingTax(dividend.getWithholdingTax())
                .netAmount(dividend.getNetAmount())
                .build();
    }

    public List<Dividend> getDividendListByStockId(Long id) {
        return dividendRepository.findAllByStockId(id);
    }

    private Account updateAccountBalanceByReceivedDividend(Long id, Dividend dividend) {
        Account account = accountRepository.findById(id).orElse(null);
        BigDecimal total;
        BigDecimal net = dividend.getGrossAmount().subtract(dividend.getWithholdingTax());
        total = account.getBalance().add(dividend.getGrossAmount().subtract(dividend.getWithholdingTax()));
        dividend.setNetAmount(dividend.getGrossAmount().subtract(dividend.getWithholdingTax()));
        account.setBalance(total);
        return accountRepository.save(account);
    }


}
