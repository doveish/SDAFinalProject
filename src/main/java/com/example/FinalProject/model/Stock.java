package com.example.FinalProject.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String symbol;
    private String stockName;
    @ManyToOne
    private Account account;
    private BigDecimal currentPrice;
    private BigDecimal totalAmount;
    private BigDecimal averagePrice;
    private BigDecimal currentValue;
    private BigDecimal profitLoss;

    public Stock(String symbol, String stockName, Account account, BigDecimal currentPrice, BigDecimal totalAmount, BigDecimal averagePrice, BigDecimal currentValue, BigDecimal profitLoss) {
        this.symbol = symbol;
        this.stockName = stockName;
        this.account = account;
        this.currentPrice = currentPrice;
        this.totalAmount = totalAmount;
        this.averagePrice = averagePrice;
        this.currentValue = currentValue;
        this.profitLoss = profitLoss;
    }
}
