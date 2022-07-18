package com.bridgelabz.AddressBookTool;

import java.util.Scanner;


public class AddressBookSystem {

    Scanner scanner = new Scanner(System.in);
	
    /* Ability to create contact by taking input
     * from user */
    public void addContact() {
        Contact contact = new Contact();
        System.out.println("Enter a first name:");
        String firstName = scanner.next();
        contact.setFirstName(firstName);
        
        System.out.println("Enter a last name:");
        String lastName = scanner.next();
        contact.setLastName(lastName);
        
        System.out.println("Enter a Address:");
        String address = scanner.next();
        contact.setAddress(address);
        
        System.out.println("Enter a City name:");
        String city = scanner.next();
        contact.setCity(city);
        
        System.out.println("Enter a state:");
        String state = scanner.next();
        contact.setState(state);
        
        System.out.println("Enter a email:");
        String email = scanner.next();
        contact.setEmail(email);
        
        System.out.println("Enter a zip code:");
        int zip = scanner.nextInt();
        contact.setZip(zip);
        
        System.out.println("Enter a phone number:");
        int mobileNumber = scanner.nextInt();
        contact.setMobileNumber(mobileNumber);
        
        System.out.println("Contact added successfully");
    }
}	
