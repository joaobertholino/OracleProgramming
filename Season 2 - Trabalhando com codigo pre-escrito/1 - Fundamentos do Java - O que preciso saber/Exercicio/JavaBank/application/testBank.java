package application;

import model.entities.Account;

public class testBank {
	public static void main(String[] args) {
		Account A1 = new Account("Sanjay Gupta", 11556, 300);
		Account A2 = new Account();
		Account A3 = new Account();

		A2.setAccountName("He Xai");
		A2.setAccountNum(22338);
		A2.setBalance(500);

		A3.setAccountName("Ilya Mustafana");
		A3.setAccountNum(44559);
		A3.setBalance(1000);

		A1.print();
		A2.print();
		A3.print();
	}
}
