package com.bridgelabz.AddressBookTool;

import java.util.Scanner;

public class UserInterface {
	
	static Scanner scanner = new Scanner(System.in);
	
	//Menu for contact operations
	public void handleConatctMenu() {
		AddressBookSystem addessBook = new AddressBookSystem();
		boolean exit = false;
    	while(!exit) {
    		System.out.println("\n****************************Contact List Menu ****************************\n1. Add Contact.\n2. Edit Contact.\n3. Delete Contact.\n4. Display Contact.\n5. Add Multiple Contacts."
    				+ "\n6. Return To Main Menu.");
    		int choice = scanner.nextInt();
    		switch(choice) {
    			case 1:
    				addessBook.addContact();
    				break;
    			case 2:
    				addessBook.editContact();
    				break;
    			case 3:
    				addessBook.deleteContact();
    				break;
    			case 4:
    				addessBook.showAddressBookDetails();
    				break;
    			case 5:
    				addessBook.addMultipleContacts();
    				break;
    			case 6:
    				handleAddressBookMenu();
    				break;
    			default:
    				System.out.println("Invalid Choice.");
    		}
    	}
    }
	
	//search menu
	public void handleSearchMenu() {
		AddressBookSystem addressBook = new AddressBookSystem();
		boolean exit = false;
    	while(!exit) {
    		System.out.println("\n1.Count By City.\n2.Count By State.\n3.View By City.\n4.View by State.\n5.Return.");
    		int choice = scanner.nextInt();
    		switch(choice) {
    			case 1:
    				addressBook.searchContactByCity();
    				break;
    			case 2:
    				addressBook.searchContactByState();
    				break;
    			case 3:
    				addressBook.viewByCity();
    				break;
    			case 4:
    				addressBook.viewByState();
    				break;
    			case 5:
    				handleAddressBookMenu();
    				break;
    			default:
    				System.out.println("Invalid choice.");
    		}
    	}
	}
	
	//Main menu for Address book system
	public void handleAddressBookMenu() {
		AddressBookSystem addressBook = new AddressBookSystem();
		boolean exit = false;
	    while (!exit) {
	        System.out.println("\n ****************************Addess Books Menu ****************************\n1-->Add New Address Book."
	        		+ "\n2-->Select Address Book.\n3-->Edit Address Book.\n4-->Delete Address Book.\n5-->Search Contact.\n6-->Show Address Book Details.\n7-->-->Exit<--<--");
	        int choice = scanner.nextInt();
	        switch (choice) {
	            case 1:
	            	addressBook.addAddressBook();
	                break;
	            case 2:
	            	addressBook.selectAddressBook();
	            	break;
	            case 3:
	            	addressBook.editAddressBook();
	            	break;
	            case 4:
	            	addressBook.deleteAddressBook();
	            	break;
	            case 5:
	            	handleSearchMenu();
	            	break;
	            case 6:
	            	addressBook.showAddressBookDetails();
	            	break;
	            case 7:
	            	exit = true;
	            	System.out.println("Thanks , exiting address book system");
	            	break;
	            default:
	            	System.out.println("Invalid Choice.");
	        }
	    }
	}
	
}