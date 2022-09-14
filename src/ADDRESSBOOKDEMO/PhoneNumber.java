package ADDRESSBOOKDEMO;

public class PhoneNumber {

	private String Label;
	private String PhoneNumber;

	public String getLabel() {
		return Label;
	}

	public String getphoneNumber() {
		return PhoneNumber;
	}

	public void setLabel(String label) throws LengthException {
		if (label.length() != 0 && label.length() <= 255) {
			this.Label = label;
		} else {
			throw new LengthException("Invalid Label, length should be in the range of (1..255)");
		}
	}

	public void setPhoneNumber(String phoneNumber) throws PhoneNumberInvalid {
		if (phoneNumber.matches("\\d{10}")) {
			this.PhoneNumber = phoneNumber;
		} else {
			throw new PhoneNumberInvalid("PhoneNo should contain exactly 10 digits");
		}
	}

	@Override
	public String toString() {
		return "PhoneNumber [label=" + Label + ", phoneNumber=" + PhoneNumber + "]";
	}

}
