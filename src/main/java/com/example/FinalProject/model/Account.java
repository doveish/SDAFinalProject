package com.example.FinalProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountName;
    private BigDecimal balance;
    private String currency;

    public Account(String accountName, BigDecimal balance, String currency) {
        this.accountName = accountName;
        this.balance = balance;
        this.currency = currency;
    }
}
