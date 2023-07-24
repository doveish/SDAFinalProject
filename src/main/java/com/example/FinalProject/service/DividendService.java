package com.example.FinalProject.service;

import com.example.FinalProject.repository.DividendRepository;
import org.springframework.stereotype.Service;

@Service
public class DividendService {
    private final DividendRepository dividendRepository;

    public DividendService(DividendRepository dividendRepository) {
        this.dividendRepository = dividendRepository;
    }
}
