package com.bridgelabz.AddressBookTool;

import java.util.Scanner;


public class AddressBookSystem {

    Scanner scanner = new Scanner(System.in);
	
    /* Ability to create & add contact by taking input
     * from user */
    public void addContact() {
        Contact contact = new Contact();
        System.out.println("Enter first name :");
        String firstName = scanner.next();
        contact.setFirstName(firstName);
        
        System.out.println("Enter last name :");
        String lastName = scanner.next();
        contact.setLastName(lastName);
        
        System.out.println("Enter address :");
        String address = scanner.next();
        contact.setAddress(address);
        
        System.out.println("Enter city name:");
        String city = scanner.next();
        contact.setCity(city);
        
        System.out.println("Enter state :");
        String state = scanner.next();
        contact.setState(state);
        
        System.out.println("Enter email :");
        String email = scanner.next();
        contact.setEmail(email);
        
        System.out.println("Enter pin code :");
        int zip = scanner.nextInt();
        contact.setZip(zip);
        
        System.out.println("Enter mobile number :");
        int mobileNumber = scanner.nextInt();
        contact.setMobileNumber(mobileNumber);
        
        System.out.println("Contact added successfully.");
    }
    
    //display menu for contact operations
    void showMenu() {
    	boolean exit = false;
    	while(!exit) {
    		System.out.println("1. Add Contact.\n2. Exit.");
    		int choice = scanner.nextInt();
    		switch(choice) {
    			case 1:
    				addContact();
    				break;
    			case 2:
    				exit = true;
    				System.out.println("Thanks,exiting menu.");
    				break;
    			default:
    				System.out.println("Invalid Choice.");
    		}
    	}
    }
}	

