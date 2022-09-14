package ADDRESSBOOKDEMO;

public class Address {
	private String Label;
	private String address;

	public String getLabel() {
		return Label;
	}

	public String getAddress() {
		return address;
	}

	public void setLabel(String label) throws LengthException {
		if (label.length() != 0 && label.length() <= 255) {
			this.Label = label;
		} else {
			throw new LengthException("Invalid Label, length should be in the range of (1..255)");
		}
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [label=" + Label + ", address=" + address + "]";
	}

}
