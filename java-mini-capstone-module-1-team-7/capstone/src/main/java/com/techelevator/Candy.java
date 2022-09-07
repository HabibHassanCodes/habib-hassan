package com.techelevator;

public class Candy {
    //att
    private int price = 100;
    private String candyName = "ki-kat-sourCream";


    //constructor
    public Candy(int price, String candyName) {
        this.price = price;
        this.candyName = candyName;
    }
    //getters
    public int getPrice() {
        return price;
    }

    public String getCandyName() {
        return candyName;
    }
}



