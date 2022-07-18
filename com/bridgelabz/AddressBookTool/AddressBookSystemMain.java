package com.bridgelabz.AddressBookTool;

public class AddressBookSystemMain {

	public static void main(String[] args) {
		
		System.out.println("Welcome To Address Book System.\n");
		
		AddressBookSystem addressBook = new AddressBookSystem();
		//using addressBook object to call display menu method
		addressBook.showAddressBookMenu();

	}

}
