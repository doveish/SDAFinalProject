package com.example.FinalProject.model;

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
public class Dividend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dividendId;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "stock_stock_id")
    private Stock stock;
    private BigDecimal grossAmount;
    private BigDecimal withholdingTax;
    private BigDecimal netAmount;
}
