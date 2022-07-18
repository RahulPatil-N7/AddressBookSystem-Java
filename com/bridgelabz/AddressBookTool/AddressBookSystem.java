package com.bridgelabz.AddressBookTool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AddressBookSystem {
	
    
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Contact> contactList = new ArrayList<Contact>();
	static Map<String, AddressBookSystem> addressBookSet = new HashMap<>();
    /* Ability to add multiple contacts using 
    * ArrayList collection by taking input from user */
    public void addContact() {
        
    	System.out.println("Add Contact Detatils:\n");
    	Contact contact = new Contact();
    	System.out.println("Enter first name :");
    	String firstName = scanner.next();
    	contact.setFirstName(firstName);
        
    	/*Using java stream to check if contact with
    	*  same name is alreary avaiable */
    	boolean isPresent = contactList.stream()
        		.anyMatch(n->n.getFirstName().equalsIgnoreCase(firstName));
        if(isPresent) {
            System.out.println("Contact already added");
            addContact();
        }
        else {
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
	                    boolean isPresent = contactList.stream()
	                    		.anyMatch(n->n.getFirstName().equalsIgnoreCase(editFirstName));
	                    if(isPresent) {
	                        System.out.println("Contact already added");
	                    }
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
    
    //Ability to add multiple contacts
    public void addMultipleContact() {
        System.out.println("Enter Number of Contacts to Add into Contact List : ");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            addContact();
            System.out.println(i + 1 + " Contact added Successfully.. ");
        }
    }
    
    //display menu for contact operations
    public void showMenu() {
    	boolean exit = false;
    	while(!exit) {
    		System.out.println("1. Add Contact.\n2. Edit Contact.\n3. Delete Contact.\n4. Display Contact.\n5. Add Multiple Contacts.\n6. Exit.");
    		int choice = scanner.nextInt();
    		switch(choice) {
    			case 1:
    				addAddressBookContact();
    				break;
    			case 2:
    				editAddressBookContact();
    				break;
    			case 3:
    				deleteAddressBookContact();
    				break;
    			case 4:
    				showAddressBookDetails();
    				break;
    			case 5:
    				addMultipleContactsToAddressBook();
    			case 6:
    				showAddressBookMenu();
    				break;
    			default:
    				System.out.println("Invalid Choice.");
    		}
    	}
    }
    
	//Add address books with unique name using hash map 
    public void addAddressBook() {
	    System.out.println("\nEnter The New Address Book name :");
	    String bookName = scanner.next();
	    AddressBookSystem address = addressBookSet.get(bookName);
	    if(address == null) {
	        AddressBookSystem addressBookSystem = new AddressBookSystem();
	        addressBookSet.put(bookName,addressBookSystem);
	        System.out.println("Address Book added successfully.\n");
	    }
	    else {
	        System.out.println("AddressBook with this name already exists.\n");
	    }
    }
    
    //select address book & Add contacts by taking user input
	public  void addAddressBookContact() {
		System.out.println("\n----------List of Address Books availble---------- :");
		Set keys = addressBookSet.keySet();
		Iterator set = keys.iterator();
		while (set.hasNext()) {
			System.out.println(set.next());
		}
	    System.out.println("Enter Address Book System Name");
	    String bookName = scanner.next();
	    AddressBookSystem address = addressBookSet.get(bookName);
	    AddressBookSystem addressBookSystem = new AddressBookSystem();
	    if(address == null){
	        System.out.println("No book found this name");
	        addressBookSystem.showAddressBookMenu();
	    }
	    else {
	        addressBookSystem.addContact();
	    }
	}
	
	//select address book & edit contacts by taking user input
	public static void editAddressBookContact() {
		System.out.println("\n----------List of Address Books availble---------- :");
		Set keys = addressBookSet.keySet();
		Iterator set = keys.iterator();
		while (set.hasNext()) {
			System.out.println(set.next());
		}
		System.out.println("Enter Address Book System Name");
	    String bookName = scanner.next();
	    AddressBookSystem address = addressBookSet.get(bookName);
	    AddressBookSystem addressBookSystem = new AddressBookSystem();
	    if(address == null){
	        System.out.println("No book found this name");
	        addressBookSystem.showAddressBookMenu();
	    }
	    else{
	        addressBookSystem.editContact();
	    }
	}

	//select address book & delete contact by taking from user input
	public static void deleteAddressBookContact() {
		System.out.println("\n----------List of Address Books availble---------- :");
		Set keys = addressBookSet.keySet();
		Iterator set = keys.iterator();
		while (set.hasNext()) {
			System.out.println(set.next());
		}
		System.out.println("Enter Address Book System Name :");
	    String bookName = scanner.next();
	    AddressBookSystem address = addressBookSet.get(bookName);
	    AddressBookSystem addressBookSystem = new AddressBookSystem();
	    if(address == null){
	        System.out.println("Address book not fonud.");
	        addressBookSystem.showAddressBookMenu();
	    }
	    else{
	        addressBookSystem.deleteContact();
	    }
	}

	//select address book & Add mutltiple contacts by taking range from user 
	public void addMultipleContactsToAddressBook() {
		System.out.println("\n----------List of Address Books availble---------- :");
		Set keys = addressBookSet.keySet();
		Iterator set = keys.iterator();
		while (set.hasNext()) {
			System.out.println(set.next());
		}
		System.out.println("Enter Address Book System Name :");
	    String bookName = scanner.next();
	    AddressBookSystem address = addressBookSet.get(bookName);
	    AddressBookSystem addressBookSystem = new AddressBookSystem();
	    if(address == null){
	        System.out.println("Address book not fonud.");
	        addressBookSystem.showAddressBookMenu();
	    }
	    else{
	        addressBookSystem.addMultipleContact();
	    }
	}
	
    public void showAddressBook() {
        if (contactList.isEmpty()) {
            System.out.println("Address book is empty");
        } else {
            Set<Contact> set = contactList.stream()
            		.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Contact::toString))));
            	set.forEach(System.out::println);
        }
    }
    
    //show all address book contacts
	public void showAddressBookDetails() {
		System.out.println("\n----------List of Address Books availble---------- :");
		Set keys = addressBookSet.keySet();
		Iterator set = keys.iterator();
		while (set.hasNext()) {
			System.out.println(set.next());
		}
		System.out.println("Enter Address Book System Name :");
	    String bookName = scanner.next();
	    AddressBookSystem address = addressBookSet.get(bookName);
	    AddressBookSystem addressBookSystem = new AddressBookSystem();
	    if(address == null){
	        System.out.println("Address book not fonud.");
	        addressBookSystem.showAddressBookMenu();
	    }
	    else{
	        addressBookSystem.showAddressBook();
	    }
	}    
    
	//Ability to search contact by city
	public void searchContactCity() {
        System.out.println("Enter the city search Contact :");
        AtomicInteger counter = new AtomicInteger(0);
        String input = scanner.next();
        contactList.stream()
                .forEach(i -> {
                    if (i.getCity().equals(input)) {
                        counter.getAndIncrement();
                    }
                });
        System.out.println("Number of contacts having City "+input+" are "+counter);
    }
	
	//Ability to search contact by state
	public void searchContactState() {
        System.out.println("Enter the city search Contact :");
        AtomicInteger counter = new AtomicInteger(0);
        String input = scanner.next();
        contactList.stream()
                .forEach(i -> {
                    if (i.getState().equals(input)) {
                        counter.getAndIncrement();
                    }
                });
        System.out.println("Number of contacts having State "+input+" are "+counter);
    }
    //display address book system menu.
	public void showAddressBookMenu() {
	    boolean exit = false;
	    while (!exit) {
	        System.out.println("Addess Books Menu :\n1-->Add New Address Book.\n2-->Address Books Availabe  \n3-->Contact Operations Menu.\n4-->Exit");
	        int choice = scanner.nextInt();
	        switch (choice) {
	            case 1:
	                addAddressBook();
	                break;
	            case 2:
	            	System.out.println("\n----------List of Address Books availble---------- :");
	        		Set keys = addressBookSet.keySet();
	        		Iterator set = keys.iterator();
	        		while (set.hasNext()) {
	        			System.out.println(set.next());
	        		}
	            	break;
	            case 3:
	            	showMenu();
	            case 4:
	            	exit = true;
	            	System.out.println("Thanks , exiting address book system");
	            default:
	            	System.out.println("Invaid Choice.");
	        }
	    }	
    }
}


