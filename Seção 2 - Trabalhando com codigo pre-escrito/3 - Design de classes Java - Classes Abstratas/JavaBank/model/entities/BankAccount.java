package model.entities;

public abstract class BankAccount {
	public final String bank = "JavaBank";
	private String accountName;
	private Integer accountNum;
	private Integer balance;
	
	public BankAccount(String accountName, Integer accountNum, Integer balance) {
		this.accountName = accountName;
		this.accountNum = accountNum;
		this.balance = balance;
	}
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Integer getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(Integer accountNum) {
		this.accountNum = accountNum;
	}

	public Integer getBalance() {
		return this.balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	public abstract void deposit(int amt);
	
	public abstract void withdraw(int amt);
	
	public abstract String getBankName();

	@Override
	public String toString() {
		return "Bank Name: " + this.getBankName() + "\n" + "Account Holder: " + this.getAccountName() + "\n"
				+ "Account Number: " + this.getAccountNum() + "\n" + "Account Balance: " + this.getBalance();
	}
}
