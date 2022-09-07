package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private Menu menu;
	private MainMenu mainMenu = new MainMenu();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				//mainmenutransfers here somehow
				//how to call class and use itsmethod in a diff class method
				//displayItems();
				//access mainmenu
				mainMenu.displayItems();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase;
				Purchase pay= new Purchase();


				//mainMenu.displayItems();
				pay.displayPurchaseMenu();
				//pay.setProductMap();
				//pay.selectProduct();
				//pay.countInventory();
				// if countInventoy < 6 true  
				//pay.feedMoney();

				//choose dispense, return message, and return money

				//pay.getChange();


			} else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
				//return to main menu

			}
		}
	}


	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

}
