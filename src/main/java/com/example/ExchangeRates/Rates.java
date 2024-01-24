package com.example.ExchangeRates;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "usedb")
public class Rates {
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

    public Long getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public Timestamp getValidFrom() {
        return validFrom;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getMove() {
        return move;
    }

    public int getAmount() {
        return amount;
    }

    public double getValBuy() {
        return valBuy;
    }

    public double getValSell() {
        return valSell;
    }

    public double getValMid() {
        return valMid;
    }

    public double getCurrBuy() {
        return currBuy;
    }

    public double getCurrSell() {
        return currSell;
    }

    public double getCurrMid() {
        return currMid;
    }

    public int getVersion() {
        return version;
    }

    public double getCnbMid() {
        return cnbMid;
    }

    public double getEcbMid() {
        return ecbMid;
    }
}