package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MainMenu {

/// display all available product in our vending Machine
//converted type of method so that it can be referenced in Vending Machine

    public void displayItems(){
        File machineFile = new File("C:/Users/Student/workspace/java-mini-capstone-module-1-team-7/capstone/vendingmachine.csv");
        try (Scanner fileInput = new Scanner(machineFile)) {
            while (fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();
                //line below should display quantity remaining
                System.out.println(lineOfText+"|Quantity="+5);
            }
        } catch (FileNotFoundException e) {
            System.out.println("This File Was NOT Found: " + machineFile.getAbsolutePath());

        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception.");
        }
    }

}
