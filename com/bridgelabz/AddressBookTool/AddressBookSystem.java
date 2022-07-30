package com.bridgelabz.AddressBookTool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class AddressBookSystem {
	
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Contact> contactList = new ArrayList<Contact>();
	static Map<String, ArrayList<Contact>> addressBookSet = new HashMap<>();
	public static ArrayList<Contact> addressBook;
	
	/* Ability to add multiple contacts using 
    * ArrayList collection by taking input from user */
	public void addContact() {
		System.out.println("Add Contact Detatils:\n");
		Contact contact = new Contact();
		
		System.out.println("Enter first name :");
		String firstName = scanner.next();
		contact.setFirstName(firstName);
		/*Using java stream to check if contact with
		*  same name is already available */
		boolean isPresent = contactList.stream().anyMatch(n->n.getFirstName().equalsIgnoreCase(firstName));
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
        for (int i = 0; i < contactList.size(); i++) {
	        if (contactList.get(i).getFirstName().equalsIgnoreCase(editName)) {
	            System.out.println("Select field:");
	            System.out.println("\n1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip\n7.Phone Number\n8.Email");
	            int option = scanner.nextInt();
	            switch (option) {
	                case 1:
	                    System.out.println("Enter First name :");
	                    String editFirstName = scanner.next();
	                    boolean isPresent = contactList.stream().anyMatch(n->n.getFirstName().equalsIgnoreCase(editFirstName));
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
        for (int i = 0; i < contactList.size(); i++) {
	        if (contactList.get(i).getFirstName().equals(deleteName)) {
	        	Contact contactName = contactList.get(i);
	            contactList.remove(contactName);
	            System.out.println("Contact removed successfully.");
	        }
        }
    }
    
    //Ability to add multiple contacts
    public void addMultipleContacts() {
        System.out.println("Enter Number of Contacts to Add into Contact List : ");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            addContact();
            System.out.println(i + 1 + " Contact added Successfully.. ");
        }
    }
   
    //Add address books with unique name using hash map 
    public void addAddressBook() {
	    System.out.println("\nEnter The New Address Book name :");
	    String bookName = scanner.next();
	    ArrayList<Contact> address = addressBookSet.get(bookName);
	    if(address == null) {
	    	addressBook = new ArrayList<>();
	    	addressBookSet.put(bookName,addressBook);
            System.out.println(addressBookSet.entrySet());
	        System.out.println("Address Book added successfully.\n");
	    }
	    else {
	        System.out.println("AddressBook with this name already exists.\n");
	    }
    }
    
    public void selectAddressBook() {
    	displayAddressBookList();
    	UserInterface userInterface = new UserInterface();
        System.out.println("Enter Address Book System Name :");
        String bookName = scanner.next();
        ArrayList<Contact> address = addressBookSet.get(bookName);
        if(addressBookSet.containsKey(bookName)) {
        	userInterface.handleConatctMenu();
        	addressBookSet.put(bookName,address);
        }
        else {
        	System.out.println("Address book not found");
        }
    }    
    
    //method to edit address book name
    public void editAddressBook() {
    	displayAddressBookList(); 
    	System.out.println("\nSelect the Address Book to update it :");
	    String bookName = scanner.next();
	    for(int i = 0;i < addressBookSet.size();i++) {
	    	if(addressBookSet.containsKey(bookName)) {
	    		System.out.println("Enter Address Book name :");
	    		String editBookName = scanner.next();
	    		addressBookSet.put(editBookName, addressBookSet.remove(bookName));
	    		System.out.println("Address book updated succesfully.");
	    	}
	    	else {
	    		System.out.println("Please select available address book from list.\n");
	    	}
	    }
    }
	    
    //method to delete address book 
    public void deleteAddressBook() {
    	displayAddressBookList(); 
    	System.out.println("\nSelect Address Book to delete it :");
	    String bookName = scanner.next();
	    ArrayList<Contact> address = addressBookSet.get(bookName);
	    for(int i = 0;i < addressBookSet.size();i++) {
	    	if(addressBookSet.containsKey(bookName)) {
	    		addressBookSet.remove(bookName,address);
	    		System.out.println("Address book removed succesfully.");
	    	}
	    	else {
	    		System.out.println("Address book does not exist.");
	    	}
	    }
    }
    
    //method to show all available address books
    public void displayAddressBookList() {
    	System.out.println("\n---------- List of Address Books availble ---------- :");
    	Set<String> keys = addressBookSet.keySet();
		Iterator<String> set = keys.iterator();
		while (set.hasNext()) {
			System.out.println(set.next());
		}
    }
    
    //show all address book contacts
    public void showAddressBookDetails() {
    	UserInterface userInterface = new UserInterface();
    	displayAddressBookList();
    	System.out.println("\n---------- List of all contacts ---------- :\n");
		if (contactList.isEmpty()) {
			System.out.println("No Contact Added!");
		} else {
			for (Contact list : contactList) {
				System.out.println(list);
			}
		}
		userInterface.handleSortMenu();
	}    
    
    //Ability to search contact by city
    public void searchContactByCity() {
        System.out.println("Enter the city to show Contact count :");
        AtomicInteger counter = new AtomicInteger(0);
        String city = scanner.next();
        contactList.stream().forEach(i -> {
                    if (i.getCity().equals(city)) {
                        counter.getAndIncrement();
                    }
        });
        System.out.println("Number of contacts having City "+city+" are "+counter+" .");
    }
	
	//Ability to search contact by state
	public void searchContactByState() {
	    System.out.println("Enter the State to show Contact count :");
	    AtomicInteger counter = new AtomicInteger(0);
	    String state = scanner.next();
	    System.out.println("Contacts matching State "+ state +" are :"); 
	    contactList.stream().forEach(i -> {
	                if (i.getState().equals(state)) {
	                    counter.getAndIncrement();
	                }
	    });
	    System.out.println("Number of contacts having State "+state+" are "+counter+" .");
	}
	
	//view contact by searching city
	public void viewByCity() {
		System.out.println("Enter the city to search Contact :");
	    String city = scanner.next();
	    System.out.println("Contacts matching State "+ city +" are :");
	    for (Contact list : contactList) {
	        if (list.getCity().equals(city)) {
	            System.out.println(list);
	        }
	    }
	}
	
	//view contact by searching state
	public void viewByState() {
		System.out.println("Enter the city to search Contact :");
		String state = scanner.next();
		System.out.println("Contacts matching State "+ state +" are :");
	    for (Contact list : contactList) {
	        if (list.getState().equals(state)) {
	            System.out.println(list);
	        }
	    }
	}
	
	//sorting contacts by name
	public void sortByName() {
		contactList.stream().sorted(Comparator.comparing(Contact::getFirstName)).forEach(System.out::println);
	}
	
}


