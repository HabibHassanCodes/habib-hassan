package com.techelevator.model;

public class Beer {
    private int beerId;
    private String beerName;
    private String beerDescription;
    private int beerPrice;
    private String beerType;

    public Beer(){

    }

    public String getBeerType() {
        return beerType;
    }

    public void setBeerType(String beerType) {
        this.beerType = beerType;
    }

    public Beer(int beerId, String beerName, String beerDescription, int beerPrice, String beerType) {
        this.beerId = beerId;
        this.beerName = beerName;
        this.beerDescription = beerDescription;
        this.beerPrice = beerPrice;
        this.beerType = beerType;
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public String getBeerDescription() {
        return beerDescription;
    }

    public void setBeerDescription(String beerDescription) {
        this.beerDescription = beerDescription;
    }

    public int getBeerPrice() {
        return beerPrice;
    }

    public void setBeerPrice(int beerPrice) {
        this.beerPrice = beerPrice;
    }
}
