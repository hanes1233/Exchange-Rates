package com.example.ExchangeRates.mapper;

import com.example.ExchangeRates.data.entity.Rate;
import com.example.ExchangeRates.dto.RateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RateMapper {

    RateDTO mapToRateDTO(Rate rate);

    Rate mapToRate(RateDTO rateDTO);
}
