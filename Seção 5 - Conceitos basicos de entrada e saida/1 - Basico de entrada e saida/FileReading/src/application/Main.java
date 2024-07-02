package application;

import model.services.FileReading;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> employees = new ArrayList<>();

		try {
			FileReading.readFile(employees);
			displayEmployees(employees);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void displayEmployees(ArrayList<String> employees) {
		for(int i = 0; i < employees.size(); i++) {
			System.out.println((i + 1) + ". " + employees.get(i));
		}
	}
}