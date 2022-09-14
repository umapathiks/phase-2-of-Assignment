package JAVADEMOBANKAPP;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Branch {
	public static AtomicInteger BRANCH_ID_GENERATOR = new AtomicInteger(0);
	private List<BankAccount> bankAccounts;
	private List<Customer> customers;
	private String branchId;

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(BankAccount bankAccount) {
		if (bankAccounts == null) {
			bankAccounts = new ArrayList<>();
		}
		bankAccounts.add(bankAccount);
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customer) {
		if (customers == null) {
			customers = new ArrayList<>();
		}
		customers.add(customer);
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public void createBankAccount(String panNumber, String bankAccountType, long amount) {
		BankAccount bankAccount;
		if (bankAccountType.equals(BankAccountType.SAVINGS.toString())) {
			bankAccount = new SavingAccount();
			bankAccount.setMinimumBalance(BankConstants.SAVING_ACCOUNT_MINIMUM_BALANCE);
			bankAccount.setInterestRate(BankConstants.SAVING_ACCOUNT_INTEREST_RATE);
		} else {
			bankAccount = new CurrentAccount();
			bankAccount.setMinimumBalance(BankConstants.CURRENT_ACCOUNT_MINIMUM_BALANCE);
			bankAccount.setInterestRate(BankConstants.CURRENT_ACCOUNT_INTEREST_RATE);
		}

		String accountNumber = BankConstants.BANK_ACCOUNT_NUMBER_PREFIX + BRANCH_ID_GENERATOR.incrementAndGet();
		bankAccount.setAccountNumber(accountNumber);
		bankAccount.setCurrentBalance(amount);

		Customer alreadyCustomer = customerPresentWithPanNumber(panNumber);
		if (alreadyCustomer != null) {
			alreadyCustomer.setBankAccounts(bankAccount);
		} else {
			Customer customer = new Customer();
			customer.setBankAccounts(bankAccount);
			customer.setPanNumber(panNumber);
			setCustomers(customer);
		}
		setBankAccounts(bankAccount);

	}

	public Customer getCustomerByPanNumber(String panNumber) throws BankException {
		for (Customer customer : customers) {
			if (customer.getPanNumber().equals(panNumber)) {
				return customer;
			}
		}
		throw new BankException("No Customer present with given PAN number: " + panNumber);
	}

	public BankAccount getAccountByAccountNumber(String accountNumber) throws BankException {
		for (BankAccount bankAccount : bankAccounts) {
			if (bankAccount.getAccountNumber().equals(accountNumber)) {
				return bankAccount;
			}
		}
		throw new BankException("No Account mapped with this account number: " + accountNumber);
	}

	private Customer customerPresentWithPanNumber(String panNumber) {
		if (customers != null) {
			for (Customer customer : customers) {
				if (customer.getPanNumber().equals(panNumber)) {
					return customer;
				}
			}
		}
		return null;
	}
}
