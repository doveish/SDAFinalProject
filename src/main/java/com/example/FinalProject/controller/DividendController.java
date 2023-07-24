package com.example.FinalProject.controller;

import com.example.FinalProject.service.DividendService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DividendController {
    private final DividendService dividendService;

    public DividendController(DividendService dividendService) {
        this.dividendService = dividendService;
    }
}
