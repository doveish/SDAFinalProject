package com.example.FinalProject.service;

import com.example.FinalProject.model.Account;
import com.example.FinalProject.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account save(Account account) {
        Account savedAccount = toAccount(account);
        return accountRepository.save(savedAccount);
    }

    private Account toAccount(Account account) {
        return Account.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .accountName(account.getAccountName())
                .currency(account.getCurrency())
                .build();
    }

}
