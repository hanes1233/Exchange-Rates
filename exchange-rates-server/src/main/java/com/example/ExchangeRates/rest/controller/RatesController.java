package com.example.ExchangeRates.rest.controller;

import com.example.ExchangeRates.dto.RateDTO;
import com.example.ExchangeRates.service.api.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RatesController implements WebMvcConfigurer {

    private final RateService rateService;

    @GetMapping
    public Callable<ResponseEntity<List<RateDTO>>> getAllRates(@RequestParam boolean usedb) throws IOException {
        List<RateDTO> rates = usedb ? rateService.getAllRates() : rateService.fetchFromUrl();
        return () -> ResponseEntity.ok(rates);
    }
}