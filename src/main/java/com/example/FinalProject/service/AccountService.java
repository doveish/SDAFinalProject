package com.example.FinalProject.service;

import com.example.FinalProject.model.Account;
import com.example.FinalProject.model.Dividend;
import com.example.FinalProject.model.Transaction;
import com.example.FinalProject.model.enums.TradeType;
import com.example.FinalProject.model.enums.TransactionType;
import com.example.FinalProject.repository.AccountRepository;
import com.example.FinalProject.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

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
                .status(account.getStatus())
                .build();
    }

    public Account updateAccountStatus(Long id) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null) {
            account.setStatus(true);
            accountRepository.save(account);
        }
        return account;
    }

    public Account updateAccountBalanceByReceivedDividend(Long id, Dividend dividend) {
        Account account = accountRepository.findById(id).orElse(null);
        BigDecimal total;
        total = account.getBalance().add(dividend.getNetAmount());
        account.setBalance(total);
        return accountRepository.save(account);
    }

    public Account updateAccountBalanceByTransactionType(Long id, Transaction transaction) {
        Account account = accountRepository.findById(id).orElse(null);
        BigDecimal total;
        if (transaction.getTransactionType().equalsIgnoreCase("DEPOSIT")) {
            total = account.getBalance().add(transaction.getAmount());
            account.setBalance(total);
        } else {
            if (transaction.getAmount().compareTo(account.getBalance()) > 0) {
                throw new IllegalStateException("Withdrawal amount exceeds account balance");
            }
            total = account.getBalance().subtract(transaction.getAmount());
            account.setBalance(total);
            transactionRepository.save(transaction);
            transaction.setTransactionType("WITHDRAW");
        }
        return account;
    }

}
