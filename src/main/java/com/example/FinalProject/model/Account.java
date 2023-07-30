package com.example.FinalProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountName;
    private BigDecimal balance;
    private String currency;
    private Boolean status;

    public Account(String accountName, BigDecimal balance, String currency, Boolean status) {
        this.accountName = accountName;
        this.balance = balance;
        this.currency = currency;
        this.status = status;
    }
}
