package model.entities;

public class Account implements InterfaceBankAccount {
	private String accountName;
	private Integer accountNum;
	private Integer balance;

	public Account() {
		this.accountName = "EMPTY";
		this.accountNum = 0;
		this.balance = 0;
	}

	public Account(String accountName, int accountNum, int balance) {
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

	@Override
	public void deposit(int amt) {

	}

	@Override
	public void withdraw(int amt) {

	}

	@Override
	public String getBankName() {
		return InterfaceBankAccount.BANK;
	}

	public String print() {
		return "Bank Name: " + this.getBankName() + "\n" + "Account Holder: " + this.getAccountName() + "\n"
				+ "Account Number: " + this.getAccountNum() + "\n" + "Account Balance: " + this.getBalance();
	}
}
