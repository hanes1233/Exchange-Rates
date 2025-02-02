package com.example.ExchangeRates.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "rates")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="SHORTNAME")
    private String shortName;

    @Column(name="VALIDFROM")
    private Timestamp validFrom;

    @Column(name="NAME")
    private String name;

    @Column(name="COUNTRY")
    private String country;

    @Column(name="MOVE")
    private double move;

    @Column(name="AMOUNT")
    private int amount;

    @Column(name="VALBUY")
    private double valBuy;

    @Column(name="VALSELL")
    private double valSell;

    @Column(name="VALMID")
    private double valMid;

    @Column(name="CURRBUY")
    private double currBuy;

    @Column(name="CURRSELL")
    private double currSell;

    @Column(name="CURRMID")
    private double currMid;

    @Column(name="VERSION")
    private int version;

    @Column(name="CNBMID")
    private double cnbMid;

    @Column(name="ECBMID")
    private double ecbMid;
}