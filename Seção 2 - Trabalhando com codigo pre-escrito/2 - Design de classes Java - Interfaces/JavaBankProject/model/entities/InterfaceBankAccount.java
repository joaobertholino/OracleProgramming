package model.entities;

public interface InterfaceBankAccount {
	public final String BANK = "JavaBank";
	
	public void deposit(int amt);
	
	public void withdraw(int amt);
	
	public Integer getBalance();
	
	public String getBankName();
}
