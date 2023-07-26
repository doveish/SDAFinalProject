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
    private Long id;
    private LocalDate date;
    @ManyToOne
    private Stock stock;
    @ManyToOne
    private Account account;
    private BigDecimal grossAmount;
    private BigDecimal withholdingTax;
    private BigDecimal netAmount;

    public Dividend(LocalDate date, Stock stock, Account account, BigDecimal grossAmount, BigDecimal withholdingTax, BigDecimal netAmount) {
        this.date = date;
        this.stock = stock;
        this.account = account;
        this.grossAmount = grossAmount;
        this.withholdingTax = withholdingTax;
        this.netAmount = netAmount;
    }
}
