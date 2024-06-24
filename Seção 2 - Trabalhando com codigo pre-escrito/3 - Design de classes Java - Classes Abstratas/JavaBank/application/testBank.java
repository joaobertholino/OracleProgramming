package application;

import model.entities.Account;

public class testBank {
	public static void main(String[] args) {
		Account A1 = new Account("Sanjay Gupta", 11556, 300);
		Account A2 = new Account("He Xai", 22338, 500);
		Account A3 = new Account("Ilya Mustafana", 44559, 1000);

		System.out.println(A1 + "\n");
		System.out.println(A2 + "\n");
		System.out.println(A3 + "\n");
	}
}
