package com.example.FinalProject.repository;

import com.example.FinalProject.model.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {
    CurrencyRate findByCurrency(String currency);


    // CurrencyRate findByCurrency(String currency);

}
