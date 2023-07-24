package com.example.FinalProject.model;

import com.example.FinalProject.model.enums.TradeType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private TradeType tradeType;
    @ManyToOne
    @JoinColumn(name = "stock_stock_id")
    private Stock stock;
    private LocalDate date;
    private BigDecimal amount;
    private BigDecimal unitPrice;
    private BigDecimal commission;
    private BigDecimal tradeSum;
    private String comment;
}
