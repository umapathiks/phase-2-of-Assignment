package JAVADEMOBANKAPP;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BankAccount {
	private static AtomicInteger TRANSACTION_ID_GENERATOR = new AtomicInteger(0);
	private String accountNumber;
	private long minimumBalance;
	private long currentBalance;
	private double interestRate;
	private List<Transaction> transactions;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(long minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public long getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(long currentBalance) {
		this.currentBalance = currentBalance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public List<Transaction> getTransactionHistory() {
		return transactions;
	}

	public void withDraw(long withdrawAmount) throws BankException {
		if (this.getType().equals(BankAccountType.SAVINGS.toString())) {
			if ((currentBalance - withdrawAmount) < BankConstants.SAVING_ACCOUNT_MINIMUM_BALANCE) {
				throw new BankException(
						"Unable to withdraw, Please maintain minimum balance always: " + currentBalance);
			}
		} else {
			if ((currentBalance - withdrawAmount) < BankConstants.CURRENT_ACCOUNT_MINIMUM_BALANCE) {
				throw new BankException(
						"Unable to withdraw, Please maintain minimum balance always: " + currentBalance);
			}
		}

		synchronized (this) {
			currentBalance -= withdrawAmount;
			Transaction transaction = new Transaction();
			String transactionId = BankConstants.WITHDRAW_OPERATION + TRANSACTION_ID_GENERATOR.incrementAndGet();
			transaction.setTransactionId(transactionId);
			transaction.setAmount(withdrawAmount);
			transaction.setType(TransactionType.WITHDRAW);
			addToTransactions(transaction);
		}
	}

	public void deposit(long depositAmount) throws Exception {
		if (depositAmount < 0) {
			throw new Exception("Deposit amount should be greater than 0, deposit amount: " + depositAmount);
		}
		synchronized (this) {
			currentBalance += depositAmount;
			Transaction transaction = new Transaction();
			String transactionId = BankConstants.DEPOSIT_OPERATION + TRANSACTION_ID_GENERATOR.incrementAndGet();
			transaction.setTransactionId(transactionId);
			transaction.setType(TransactionType.DEPOSIT);
			transaction.setAmount(depositAmount);
			addToTransactions(transaction);
		}
	}

	public void addToTransactions(Transaction transaction) {
		if (transactions == null) {
			transactions = new ArrayList<>();
		}
		transactions.add(transaction);
	}

	public List<Transaction> getMiniStatement() {
		List<Transaction> miniStatement = new ArrayList<>();
		int count = 0;
		ListIterator<Transaction> listIterator = transactions.listIterator(transactions.size());
		while (listIterator.hasPrevious()) {
			miniStatement.add(listIterator.previous());
			count++;
			if (count > BankConstants.MINI_STATEMENT_COUNT) {
				break;
			}
		}
		return miniStatement;
	}

	public abstract String getType();

}
