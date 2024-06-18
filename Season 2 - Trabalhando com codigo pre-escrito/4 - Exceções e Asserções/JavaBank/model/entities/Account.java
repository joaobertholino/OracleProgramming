package model.entities;

public class Account extends BankAccount {
	private Integer bonusValue;
	
	public Account(String accountName, Integer accountNum, Integer balance) {
		super(accountName, accountNum, (balance + calculateInitialBonusValue(balance)));
		this.bonusValue = calculateInitialBonusValue(balance);
	}

	@Override
	public void deposit(int amt) {
		if (amt > 100) {
			this.setBalance(this.getBalance() + amt + (int) (this.bonusValue * 0.1));
		} else {
			this.setBalance(this.getBalance() + amt);
		}
	}

	@Override
	public void withdraw(int amt) {
		this.setBalance(this.getBalance() - amt);
	}

	@Override
	public String getBankName() {
		return this.bank;
	}
	
	public static Integer calculateInitialBonusValue(Integer value) throws IllegalArgumentException {
		if (value >= 1 && value <= 100) {
			return 10;
		} else if (value >= 101 && value <= 300) {
			return 20;
		} else if (value > 300) {
			return 30;
		} else {
			throw new IllegalArgumentException("Valor Invalido!");
		}
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
