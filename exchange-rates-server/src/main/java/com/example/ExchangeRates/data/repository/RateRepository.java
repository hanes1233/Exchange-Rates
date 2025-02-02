package com.example.ExchangeRates.data.repository;

import com.example.ExchangeRates.data.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    boolean existsByCountry(String country);
}