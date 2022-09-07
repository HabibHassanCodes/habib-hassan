package com.techelevator;

public class Chips{

private double price = 1.45;
private String chipName = "";
private String vendingNumber = "A2";





    //constructor
    public Chips(int price, String chipName) {
    this.price = price;
    this.chipName = chipName;
    }
    //getters
         public double getPrice() {
                return price;
              }

              public String getChipName() {
                 return chipName;
            }

}
