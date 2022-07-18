package com.bridgelabz.AddressBookTool;

import java.util.ArrayList;
import java.util.Scanner;


public class AddressBookSystem {
    
	Scanner scanner = new Scanner(System.in);
	static ArrayList<Contact> contactList = new ArrayList<Contact>();
	
    /* Ability to add multiple contacts using 
     * ArrayList collection by taking input from user */
    public void addContact() {
        
    	System.out.println("Add Contact Detatils:\n");
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
	        
    	contactList.add(contact);
    	System.out.println("\nContact added Successfully");
        
    }
    
    
    /* This method checks if entered name is available in contact list
     *  by equals method. If contact is available,it return true &
     *  proceeds with update of contact */
    public void editContact() {
        System.out.println("\nEnter first name to edit existing contact:");
        String editName = scanner.next();
        Contact contact = new Contact();
        for (int i = 0; i < contactList.size(); i++) {
	        if (contactList.get(i).getFirstName().equalsIgnoreCase(editName)) {
	            System.out.println("Select field:");
	            System.out.println("\n1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip\n7.Phone Number\n8.Email");
	            int option = scanner.nextInt();
	            switch (option) {
	                case 1:
	                    System.out.println("Enter First name :");
	                    String editFirstName = scanner.next();
	                    contactList.get(i).setFirstName(editFirstName);
	                    break;
	                case 2:
	                    System.out.print("Enter Last name :");
	                    contactList.get(i).setLastName(scanner.next());
	                    break;
	                case 3:
	                    System.out.print("Enter Address :");
	                    contactList.get(i).setAddress(scanner.next());
	                    break;
	                case 4:
	                    System.out.print("Enter city :");
	                    contactList.get(i).setCity(scanner.nextLine());
	                    break;
	                case 5:
	                    System.out.print("Enter state :");
	                    contactList.get(i).setState(scanner.nextLine());
	                    break;
	                case 6:
	                    System.out.print("Enter zip code :");
	                    contactList.get(i).setZip(scanner.nextInt());
	                    break;
	                case 7:
	                    System.out.print("Enter mobile number :");
	                    contactList.get(i).setMobileNumber(scanner.nextInt());
	                    break;
	                case 8:
	                    System.out.print("Enter a email:");
	                    contactList.get(i).setEmail(scanner.nextLine());
	                    break;
	                default:
	                    System.out.println("Contact does not exist.");
	            }
	        }
        }
    }

    /* This method checks if entered name is available in contact list
     *  by equals method. If contact is available,it make contact null*/
    public void deleteContact() {
        System.out.println("Enter first name to delete contact :");
        String deleteName = scanner.next();
        Contact contact = new Contact();
        for (int i = 0; i < contactList.size(); i++) {
	        if (contactList.get(i).getFirstName().equals(deleteName)) {
	        	Contact contactName = contactList.get(i);
	            contactList.remove(contactName);
	            System.out.println("Contact removed successfully.");
	        }
        }
    }
    
    //display menu for contact operations
    void showMenu() {
    	boolean exit = false;
    	while(!exit) {
    		System.out.println("1. Add Contact.\n2. Edit Contact.\n3. Delete Contact.\n4. Display Contact\n5. Exit.");
    		int choice = scanner.nextInt();
    		switch(choice) {
    			case 1:
    				addContact();
    				break;
    			case 2:
    				editContact();
    				break;
    			case 3:
    				deleteContact();
    				break;
    			case 4:
    				for (int i = 0; i < contactList.size(); i++) {
    				System.out.println(contactList.get(i) + "");
    				}
    				break;
    			case 5:
    				exit = true;
    				System.out.println("Thanks,exiting menu.");
    				break;
    			default:
    				System.out.println("Invalid Choice.");
    		}
    	}
    }
}	

