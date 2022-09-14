package ADDRESSBOOKDEMO;

import java.util.ArrayList;
import java.util.List;

public class Contact extends AddressBook {
	private String name;
	private String organisation;
	private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
	private List<Address> addresses = new ArrayList<Address>();

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public void setName(String name) throws LengthException {
		if (name.length() != 0 && name.length() <= 255) {
			this.name = name;
		} else {
			throw new LengthException("Invalid name, length should be in the range of (1..255)");
		}
	}

	// added setters
	public String getName() {
		return name;
	}

	public String getOrganisation() {
		return organisation;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void addPhoneNumber(PhoneNumber number) {
		phoneNumbers.add(number);
	}

	public void addAddress(Address addres) {
		addresses.add(addres);
	}

//	public void setOrganization(String organization) {
//	this.organisation = organization;
//}

//public void setName(String name) {
//this.name = name;
//}

//public void setPhoneNumList(List<PhoneNumber> phoneNumList) {
//this.phoneNumList = phoneNumList;
//}
//	public void setAddressList(List<Address> addressList) {
//		this.addressList = addressList;
//	}

}