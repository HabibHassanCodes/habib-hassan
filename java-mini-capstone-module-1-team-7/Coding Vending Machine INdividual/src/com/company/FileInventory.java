package com.company;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileInventory {
    //open file path that was given
    File fileInventory = new File("insertFilePathForInventory");

    //allows reading of file inventory that was given
    try (Scanner dataInput = new Scanner(fileInventory)) {
        while(dataInput.hasNextLine();
        PrintWriter dataOutput = new PrintWriter("outputFilePathnamenew pathwe created")) {
            String lineOfInput = dataInput.nextLine();
            dataOutput.println(lineOfInput.replace("insertquantityoriginalhere", "insertquantityupdated after purchase is done");
        }
    } catch (Exception e) {
        System.err.println("File has an error.");
    }


    //after we read, then we must write certain things to a new file
}

