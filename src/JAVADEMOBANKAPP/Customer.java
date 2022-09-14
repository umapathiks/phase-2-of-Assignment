package JAVADEMOBANKAPP;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private List<BankAccount> bankAccounts;
	private String panNumber;

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(BankAccount bankAccount) {
		if (bankAccounts == null) {
			bankAccounts = new ArrayList<>();
		}
		bankAccounts.add(bankAccount);
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
}
