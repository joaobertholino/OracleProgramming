package model.entities;

public class CreditAccount extends BankAccount {
	private Integer creditLimit;

	public CreditAccount(String accountName, Integer accountNum, Integer balance) {
		super(accountName, accountNum, balance);
		this.creditLimit = CreditAccount.calculateCreditLimit(balance);
	}

	public Integer getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Integer creditLimit) {
		this.creditLimit = creditLimit;
	}

	@Override
	public void deposit(int amt) {
		this.setBalance(this.getBalance() + amt);
	}

	@Override
	public void withdraw(int amt) {
		this.setBalance(this.getBalance() - amt);
	}

	@Override
	public String getBankName() {
		return this.bank;
	}
	
	public static Integer calculateCreditLimit(Integer value) throws IllegalArgumentException {
		if (value >= 1 && value <= 2000) {
			return 100;
		} else if (value >= 2001 && value <= 4000) {
			return 200;
		} else if (value > 4000) {
			return 300;
		} else {
			throw new IllegalArgumentException("Valor Invalido!");
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" + "Credit Limit: " + this.creditLimit;
	}
}
