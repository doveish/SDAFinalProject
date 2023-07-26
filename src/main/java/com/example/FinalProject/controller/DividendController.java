package com.example.FinalProject.controller;

import com.example.FinalProject.model.Account;
import com.example.FinalProject.model.Dividend;
import com.example.FinalProject.model.Trade;
import com.example.FinalProject.service.DividendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dividend")
public class DividendController {

    @Autowired
    private DividendService dividendService;

    @GetMapping
    public List<Dividend> getFullDividendList() {
        return dividendService.getFullDividendList();
    }

    @PostMapping("/add-dividend")
    public Dividend addDividend(Dividend dividend) {
        return dividendService.save(dividend);
    }

}
