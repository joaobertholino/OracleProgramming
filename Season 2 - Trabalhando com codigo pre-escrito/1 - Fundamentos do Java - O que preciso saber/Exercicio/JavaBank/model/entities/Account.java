package model.entities;

public class Account {
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
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public void print() {
		System.out.println(this.accountName + " " + this.accountNum + " " + this.balance);
	}
}
