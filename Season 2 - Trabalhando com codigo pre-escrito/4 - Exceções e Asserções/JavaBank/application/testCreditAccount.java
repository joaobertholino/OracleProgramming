package application;

import model.entities.Account;
import model.entities.BankAccount;
import model.entities.CreditAccount;

public class testCreditAccount {
	public static void main(String[] args) {
		Account A1 = new Account("Sanjay Gupta", 11556, 300);
		Account A2 = new Account("He Xai", 22338, 500);
		Account A3 = new Account("Ilya Mustafana", 44559, 1000);

		BankAccount C1 = new CreditAccount("A.N Other", 88776, 500);
		BankAccount C2 = new CreditAccount("Another", 66778, 500);

		System.out.println(A1 + "\n");
		System.out.println(A2 + "\n");
		System.out.println(A3 + "\n");
		System.out.println(C1 + "\n");
		System.out.println(C2 + "\n");
	}
}
