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
}
