package com.example.ExchangeRates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //Method returns all data from repository
    public List<Rates> getAllRates() {
        return userRepository.findAll();
    }

    //Method returns element by country name
    public Optional<Rates> getRateByCountry(String name) { return userRepository.findByCountry(name); }
}