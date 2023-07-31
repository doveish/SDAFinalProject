package com.example.FinalProject.service;

import com.example.FinalProject.model.Account;
import com.example.FinalProject.model.Dividend;
import com.example.FinalProject.model.Stock;
import com.example.FinalProject.repository.DividendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DividendService {

    @Autowired
    private DividendRepository dividendRepository;

    public List<Dividend> getFullDividendList() {
        return dividendRepository.findAll();
    }

    public Dividend save (Dividend dividend) {
        Dividend savedDividend = toDividend(dividend);
        return dividendRepository.save(savedDividend);
    }

    public Dividend save (Dividend dividend, Stock stock) {
        dividend.setStock(stock);
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
}
