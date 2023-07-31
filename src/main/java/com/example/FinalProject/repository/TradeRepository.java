package com.example.FinalProject.repository;

import com.example.FinalProject.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findTradeByStockSymbol(String symbol);

    List<Trade> findAllByStockId(Long id);
}
