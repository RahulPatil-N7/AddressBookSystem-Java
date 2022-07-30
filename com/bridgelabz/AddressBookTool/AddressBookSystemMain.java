package com.bridgelabz.AddressBookTool;

public class AddressBookSystemMain {

	public static void main(String[] args) {
		
		System.out.println("Welcome To Address Book System.\n");
		
		UserInterface iUser = new UserInterface(); 
		//using addressBook object to call display menu method
		iUser.handleAddressBookMenu();

	}
	
}
