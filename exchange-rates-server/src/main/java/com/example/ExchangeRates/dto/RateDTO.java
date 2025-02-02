package com.example.ExchangeRates.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class RateDTO {

    private Long id;

    private String shortName;

    private Timestamp validFrom;

    private String name;

    private String country;

    private double move;

    private int amount;

    private double valBuy;

    private double valSell;

    private double valMid;

    private double currBuy;

    private double currSell;

    private double currMid;

    private int version;

    private double cnbMid;

    private double ecbMid;
}
