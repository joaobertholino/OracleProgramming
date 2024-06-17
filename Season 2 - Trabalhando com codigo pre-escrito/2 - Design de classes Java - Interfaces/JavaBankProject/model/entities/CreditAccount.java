package model.entities;

public class CreditAccount extends Account {
	private Integer creditLimit;

	public CreditAccount() {
		super();
		this.creditLimit = 100;
	}

	public CreditAccount(String accountName, int num, int balance, int creditLimit) {
		super(accountName, num, balance);
		this.creditLimit = creditLimit;
	}

	public Integer getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Integer creditLimit) {
		this.creditLimit = creditLimit;
	}

	@Override
	public String print() {
		return "Bank Name: " + this.getBankName() + "\n" + "Account Holder: " + this.getAccountName() + "\n"
				+ "Account Number: " + this.getAccountNum() + "\n" + "Account Balance: " + this.getBalance();
	}
}
