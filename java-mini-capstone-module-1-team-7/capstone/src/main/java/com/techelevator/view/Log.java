package com.techelevator.view;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {


    private static PrintWriter pw = null; //replace with dispense() ?

    public static void log(String message) {
        try {
            if (pw == null) { //replace with dispense();?
                String logFileDateTime = "logs/" + LocalDate.now().format(DateTimeFormatter.ISO_DATE) + ".log";
                pw = new PrintWriter(new FileOutputStream(logFileDateTime));
            }
            pw.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + " " + message);
            pw.flush();
        }
        catch (FileNotFoundException e) {
            throw new LogExceptions(e.getMessage());
        }
    }
    public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Files in Java might by tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}

    //method where we remove count from map in a loop
    //cannot have more than one key value
    //how would we have 5 diff?

    ///reading fom file

    //add to map
    //slotnumber

    //create reference type to hold
        //price
        //itemname
        //itemType


    //String product = price + itemName + itemType;
    //application read from vending machine file

    //add to key value
    //slotnumber

   // Map <String, product> slotNumberAndProduct = new
    //string = slotnumber
    //product = reference to rest of info
