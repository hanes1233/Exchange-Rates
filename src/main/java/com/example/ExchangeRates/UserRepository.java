package com.example.ExchangeRates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Rates, Long> {
    Optional<Rates> findByCountry(String name);
}