package com.example.FinalProject.controller;

import com.example.FinalProject.model.Account;
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
}
