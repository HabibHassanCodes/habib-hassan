package com.techelevator;

public class Beverage {
    //att
    private int price = 100;
    private String beverageName = "sourCreamSoda";


    //constructor
    public Beverage(int price, String beverageName) {
        this.price = price;
        this.beverageName = beverageName;
    }
    //getters
    public int getPrice() {
        return price;
    }

    public String getBeverageName() {
        return beverageName;
    }
}





