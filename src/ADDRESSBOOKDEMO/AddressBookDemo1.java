package ADDRESSBOOKDEMO;

import java.util.List;

public class AddressBookDemo1 {

	static void printList(List<Contact> list) {
		for (Contact i : list) {
			System.out.println("Name: " + i.getName() + " Organisation: " + i.getOrganisation());
			System.out.println(i.getAddresses().toString());
			System.out.println(i.getPhoneNumbers().toString());
		}
	}

	public static void main(String[] args) throws LengthException {

		try {
			PhoneNumber p1 = new PhoneNumber();
			p1.setLabel("Office");
			p1.setPhoneNumber("8660175927");
			PhoneNumber p2 = new PhoneNumber();
			p2.setLabel("Home");
			p2.setPhoneNumber("8880582509");

			Address a1 = new Address();
			a1.setLabel("Home Address");
			a1.setAddress("Kolar");

			Address a2 = new Address();
			a2.setLabel("Office Address");
			a2.setAddress("RICHMOND");

			Contact c1 = new Contact();
			c1.setName("Umapathi K S");
			c1.setOrganisation("Maveric");
			c1.addAddress(a1);
			c1.addAddress(a2);
			c1.addPhoneNumber(p2);
			c1.addPhoneNumber(p1);

			PhoneNumber p3 = new PhoneNumber();
			p3.setLabel("Office");
			p3.setPhoneNumber("9898798769");
			PhoneNumber p4 = new PhoneNumber();
			p4.setLabel("Home");
			p4.setPhoneNumber("9988768512");

			Address a3 = new Address();
			a3.setLabel("HOME");
			a3.setAddress("Bangalore");

			Address a4 = new Address();
			a4.setLabel("Office");
			a4.setAddress("Mysore");

			Contact c2 = new Contact();
			c2.setName("Rakesh");
			c2.setOrganisation("Infosys");
			c2.addAddress(a3);
			c2.addAddress(a4);
			c2.addPhoneNumber(p3);
			c2.addPhoneNumber(p4);

			// adding to addressbook
			AddressBook addressBook = new AddressBook();
			addressBook.addContact(c1);
			addressBook.addContact(c2);

			// Printing if Contacts are present in contactList
			List<Contact> contactList = addressBook.contactList;

			printList(contactList);
			System.out.println(
					"====================================================================================================================");
			/*
			 * Testing Methods searchByName() searchByOrganisation() updateContact()
			 * deleteContact()
			 *
			 * //
			 */
			List<Contact> filteredList = addressBook.searchByName("Umapt");
			System.out.println(
					"=====================================searchByName==================================================");
			printList(filteredList);

			// List<Contact> filteredList1 = addressBook.searchByOrganisation("Info");
			// System.out.println(
			// "=====================================searchByOrganisation==================================================");
			// printList(filteredList1);

			// addressBook.updateContact("Rakesh", c2); // should throw exception
			addressBook.updateContact("Ramesh", c2); // works
			System.out.println(
					"======================================AfterUpdating======================================");

			printList(addressBook.contactList);

			addressBook.deleteContact("Umapathi K S");
			System.out.println(
					"======================================AfterDeleting======================================");

			printList(addressBook.contactList);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
