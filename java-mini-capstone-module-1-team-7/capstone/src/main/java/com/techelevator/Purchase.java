package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Purchase {
    private Map<String, Double> productMap = new HashMap<String, Double>();
    private double moneyInserted;
    private double cost;
    private int totalCount = 5;
    private double aaquantity;
    private String choice;
    private double change;
    private String continueFeeding2;

    public Purchase() {
        Map<String, Double> productMap = new HashMap<String, Double>();


    }

    public void setProductMap() {
        productMap.put("A1", 3.05);
        productMap.put("A2", 1.45);
        productMap.put("A3", 2.75);
        productMap.put("A4", 3.65);
        productMap.put("B1", 1.80);
        productMap.put("B2", 1.50);
        productMap.put("B3", 1.50);
        productMap.put("B4", 1.75);
        productMap.put("C1", 1.25);
        productMap.put("C2", 1.50);
        productMap.put("C3", 1.50);
        productMap.put("C4", 1.50);
        productMap.put("D1", 0.85);
        productMap.put("D2", 0.95);
        productMap.put("D3", 0.75);
        productMap.put("D4", 0.75);
    }

    public double getDoublequantity() {
        return aaquantity;
    }

    public String getChoice() {
        return choice;
    }

    public double feedMoney() {

        //1. feed money
        ////ask for money input amount
        ////whole dollar amounts
        ////store as a doubles for change purpose potentially
        Scanner userInput = new Scanner(System.in);
        System.out.println("Insert Money");
        double moneyInsertedInitial = userInput.nextDouble();
        userInput.nextLine();
        System.out.println("Current Money Provided: " + "$" + moneyInsertedInitial);
        moneyInserted = moneyInsertedInitial;
        System.out.println("Would you like to add more?\n 1. Yes! 2. No!");
        String continueFeeding = userInput.nextLine();


        //System.out.println(continueFeeding);
        while (continueFeeding.equals("1")) {
            System.out.println("Insert More Money");
            double moreMoney = userInput.nextDouble();
            moneyInserted += moreMoney;
            System.out.println("Current Money Provided: " + "$" + moneyInserted);
            break;
//            System.out.println("Would you like to add more?\n 1. Yes! 2. No!");
//            continueFeeding2 = userInput.nextLine();
//            if(continueFeeding2.equals("1")) {
//                continueFeeding.equals("1");
            //}



        }
        return moneyInserted;


    }


    public double getMoneyInserted() {
        return moneyInserted;
    }

    public double getCost() {
        return cost;
    }
    public double getChangeChange() { return change;}

    //2. select product
    ////show product available
    ////input code
    ////if code doesn't exist, tell customer,  return to purchase menu
    ////if productis sold out, tell customer, return to purchase menu
    ////if product is valid, DISPENSE ITEM


    public void selectProduct() {

        //MainMenu.displayItems();
        Scanner userInput = new Scanner(System.in);
        System.out.print("Select Item: ");
        choice = userInput.nextLine().toUpperCase();
        String product = "0";

        if (choice.equals("A1")) {
            product = String.valueOf(productMap.get("A1"));
        }
        if (choice.equals("A2")) {
            product = String.valueOf(productMap.get("A2"));
        }
        if (choice.equals("A3")) {
            product = String.valueOf(productMap.get("A3"));
        }
        if (choice.equals("A4")) {
            product = String.valueOf(productMap.get("A4"));
        }
        if (choice.equals("B1")) {
            product = String.valueOf(productMap.get("B1"));
        }
        if (choice.equals("B2")) {
            product = String.valueOf(productMap.get("B2"));
        }
        if (choice.equals("B3")) {
            product = String.valueOf(productMap.get("B3"));
        }
        if (choice.equals("B4")) {
            product = String.valueOf(productMap.get("B4"));
        }
        if (choice.equals("C1")) {
            product = String.valueOf(productMap.get("C1"));
        }
        if (choice.equals("C2")) {
            product = String.valueOf(productMap.get("C2"));
        }
        if (choice.equals("C3")) {
            product = String.valueOf(productMap.get("C3"));
        }
        if (choice.equals("C4")) {
            product = String.valueOf(productMap.get("C4"));
        }
        if (choice.equals("D1")) {
            product = String.valueOf(productMap.get("D1"));
        }
        if (choice.equals("D2")) {
            product = String.valueOf(productMap.get("D2"));
        }
        if (choice.equals("D3")) {
            product = String.valueOf(productMap.get("D3"));
        }
        if (choice.equals("D4")) {
            product = String.valueOf(productMap.get("D4"));
        }
        if (choice.equals("")) {
            System.out.println("You did not choose a valid item. Please try again.");
            selectProduct();
        }
        if (choice.equals(null)) {
            System.out.println("You did not choose a valid item. Please try again.");
            selectProduct();
        }
        System.out.println(choice + " costs $" + product + ".");
        System.out.println("How many would you like of " + choice + "?");
        String quantity = userInput.nextLine();
        aaquantity = Double.parseDouble(quantity);

        cost = aaquantity * Double.parseDouble(product);

    }


    public String dispenseItem() {
        //System.out.println("Your cost is " + cost + "$");
        //Gum gumObject = new Gum();
        //String message = gumObject.getGumMessage();
        //System.out.println( message +productMap.get("A2"));
        File menuFile = new File("C:/Users/Student/workspace/java-mini-capstone-module-1-team-7/capstone/iteam");
        String lineOfText = null;
        try (Scanner fileInput = new Scanner(menuFile)) {
            while (fileInput.hasNextLine()) {
                lineOfText = fileInput.nextLine();
                if (lineOfText.contains(choice)) {
                    System.out.println(lineOfText);
                    //line below should display quantity remaining
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("This File Was NOT Found: " + menuFile.getAbsolutePath());
        }
        return "";
    }

    public String returnMessage() {
        File menuFile = new File("C:/Users/Student/workspace/java-mini-capstone-module-1-team-7/capstone/vendingmachine.csv");
        String message = "Before loop";
        try (Scanner fileInput = new Scanner(menuFile)) {
            while (fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();

                if (lineOfText.contains("Chip")) {
                    message = "Crunch Crunch,Yum";
                    //line below should display quantity remaining
                } else if (lineOfText.contains("Gum")) {
                    //message = "Chew Chew,Yum";
                    //line below should display quantity remaining
                } else if (lineOfText.contains("Drink")) {
                    message = "Glug Glug, Yum";
                } else if (lineOfText.contains("Candy")) {
                    message = "Munch Munch, Yum";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("This File Was NOT Found: " + menuFile.getAbsolutePath());
        }
        return message;
    }

    public void displayPurchaseMenu() {
        System.out.println("(1) Feed Money\n(2) Select Product\n(3) Finish Transaction");
        Scanner userInput = new Scanner(System.in);
        System.out.print("Select Function: ");
        int choice = userInput.nextInt();
        if (choice == 1) {
            feedMoney();
            System.out.println("Your current credits are $" + moneyInserted + ".");
            //not sure how to make feed money accessible in whole thing

            displayPurchaseMenu();


        }
        if (choice == 2) {
            System.out.println("Your current credits are $" + moneyInserted + ".");
            setProductMap();
            selectProduct();
            getTotalCount();
            countInventory();

            //store decision
            //decision is stored in get cost

        }
        if (choice == 3) {
            // getChange();
            System.out.println(dispenseItem());
            System.out.println(returnMessage());
            System.out.println("Your change is " + getChange());
            //fix quarter change etc
            System.out.println(changeDispensed());
            System.out.println("Enjoy your treat!!!!");

        }
    }

    public boolean countInventory() {

        for (int i = 0; i < totalCount; i++) {
            totalCount = totalCount - (int) getDoublequantity();//replace 1 with userInput quantity of type get product thing;
            if (totalCount == 0) {
                String soldOut = "Product is SOLD OUT.";
                System.out.println(soldOut);
                selectProduct();
                return false;
            } else if (totalCount < 0) {
                String notEnough = "The quantity chosen is invalid. Not enough in Log.txt.";
                System.out.println(notEnough);
                selectProduct();
                return false;
            } else {
                System.out.println("The current cost is $" + getCost() + ".");
                //cost += getCost();
                displayPurchaseMenu();

                //System.out.println("Dispensing item below, please take your change.");


                //insert dispense items and amount action method thing
            }
        }
        return true;
    }

    public double getChange() {
        double change = moneyInserted - (cost);
        //System.out.println("Your change is $" + change);
        return change;

    }

    public String changeDispensed() {
        double newChange = getChange();
        double getchangeQ = 0;
        double totalquarters =0;
        double getchangeD = 0;
        double totaldimes = 0;
        double getchangeN = 0;
        double totalnickels =0;

        while (newChange > 0) {

            if (newChange >= .25) {
                getchangeQ = newChange % .25;
                totalquarters = (newChange - getchangeQ) / .25;
                newChange = getchangeQ;
            }
            if (newChange >= .10) {
                getchangeD =  newChange % .10;
                totaldimes = (newChange - getchangeD) / 0.10;
                newChange = getchangeD;
            }
            if (newChange >= .05) {
                getchangeN = newChange % .05;
                totalnickels = (newChange - getchangeN) / 0.05;
               newChange = getchangeN;
            }
            if(newChange < 0.05) {
                newChange = 0;
            }
        }
            return totalquarters + " quarters, " + totaldimes + " dimes, and " + totalnickels + " nickels.";

    }


    public int getTotalCount(){
        return totalCount;
    }




    public Map<String, Double> getProductMap() {
        return productMap;
    }

}


        //3. finish transaction
        ////return change
        //    //asking for smallest amount of coins
        ////update machines current balance to 0
        ////return to main menu





