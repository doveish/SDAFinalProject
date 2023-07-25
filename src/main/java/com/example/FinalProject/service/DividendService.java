package com.example.FinalProject.service;

import com.example.FinalProject.model.Dividend;
import com.example.FinalProject.repository.DividendRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DividendService {
    private final DividendRepository dividendRepository;

    public DividendService(DividendRepository dividendRepository) {
        this.dividendRepository = dividendRepository;
    }

    public List<Dividend> getFullDividendList() {
        return dividendRepository.findAll();
    }

    public Dividend save (Dividend dividend) {
        return dividendRepository.save(dividend);
    }
}
