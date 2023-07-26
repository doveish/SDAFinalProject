package com.example.FinalProject.repository;

import com.example.FinalProject.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findStockBySymbol(String symbol);

}
