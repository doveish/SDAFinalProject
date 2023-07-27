package com.example.FinalProject.controller;

import com.example.FinalProject.model.Account;
import com.example.FinalProject.model.Dividend;
import com.example.FinalProject.model.Transaction;
import com.example.FinalProject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/add-account")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        accountService.save(account);
        return ResponseEntity.ok(account);
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<Account> activateAccount(@PathVariable("id") Long id) {
        return ResponseEntity.accepted().body(accountService.updateAccountStatus(id));
    }

    @PatchMapping("/{id}/balance-update-by-dividend")
    public ResponseEntity<Account> updateAccountBalanceByReceivedDividend(@PathVariable("id") Long id,
                                                                          @RequestBody Dividend dividend) {
        return ResponseEntity.accepted().body(accountService.updateAccountBalanceByReceivedDividend(id, dividend));
    }

    @PatchMapping("/{id}/balance-update-by-transaction")
    public ResponseEntity<Account> updateAccountBalanceByTransactionType(@PathVariable("id") Long id,
                                                                          @RequestBody Transaction transaction) {
        return ResponseEntity.accepted().body(accountService.updateAccountBalanceByTransactionType(id, transaction));
    }



}
