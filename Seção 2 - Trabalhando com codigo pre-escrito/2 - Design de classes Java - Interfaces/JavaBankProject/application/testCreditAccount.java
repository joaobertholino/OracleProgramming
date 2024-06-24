package application;

import model.entities.Account;
import model.entities.CreditAccount;

public class testCreditAccount {
	public static void main(String[] args) {
		Account A1 = new Account("Sanjay Gupta", 11556, 300);
		Account A2 = new Account();
		Account A3 = new Account();

		Account C1 = new CreditAccount();
		Account C2 = new CreditAccount("Another", 66778, 1000, 500);

		A2.setAccountName("He Xai");
		A2.setAccountNum(22338);
		A2.setBalance(500);

		A3.setAccountName("Ilya Mustafana");
		A3.setAccountNum(44559);
		A3.setBalance(1000);

		C1.setAccountName("A.N Other");
		C1.setAccountNum(88776);
		C1.setBalance(500);

		A1.print();
		A2.print();
		A3.print();
		C1.print();
		C2.print();
	}
}
