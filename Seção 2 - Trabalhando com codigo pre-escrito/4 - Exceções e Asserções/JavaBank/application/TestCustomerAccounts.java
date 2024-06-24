package application;

import model.entities.Account;
import model.entities.BankAccount;
import model.entities.CreditAccount;

public class TestCustomerAccounts {

	public static void main(String[] args) {
		BankAccount[] bankAccounts = new BankAccount[5];
		bankAccounts[0] = new Account("Sanjay Gupta", 11556, 300);
		bankAccounts[1] = new Account("He Xai", 22338, 500);
		bankAccounts[2] = new Account("Ilya Mustafana", 44559, 1000);
		bankAccounts[3] = new CreditAccount("A.N Other", 88776, 500);
		bankAccounts[4] = new CreditAccount("Another", 66778, 500);

		System.err.println("Accounts");
		for (BankAccount acc : bankAccounts) {
			if (acc instanceof Account) {
				System.out.println(acc);
				System.out.println();
			}
		}

		System.err.println("Credit Accounts");
		for (BankAccount acc : bankAccounts) {
			if (acc instanceof CreditAccount) {
				System.out.println(acc);
				System.out.println();
			}
		}

		BankAccount credAct1 = new CreditAccount("Ilya Mustafana", 44559, 1000);
		((CreditAccount) credAct1).getCreditLimit();
	}
}
