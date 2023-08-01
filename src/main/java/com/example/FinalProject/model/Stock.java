package com.example.FinalProject.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DynamicInsert//
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String symbol;
    private String stockName;
    @ManyToOne
    private Account account;
    private BigDecimal currentPrice;
    //    private BigDecimal totalAmount;
    private BigDecimal totalAmount = BigDecimal.ZERO;
    private BigDecimal averagePrice = BigDecimal.ZERO;
    private BigDecimal currentValue = BigDecimal.ZERO;
    private BigDecimal profitLoss = BigDecimal.ZERO;

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
