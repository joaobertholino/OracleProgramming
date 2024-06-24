package application;

import model.exception.ElementFound;
import model.exception.ElementNotFound;

public class Main {
	public static void main(String[] args) {
		String[] names = {"Joao", "Ellen", "Nicolas", "Fabio", "Irineu", "Lucas", "Adriano"};

		displayNames(names);
		try {
			sequentialSearchOne(names, "Ellen");
			sequentialSearchTwo(names, "Nicolas");
		} catch (ElementFound | ElementNotFound e) {
			System.err.println(e.getMessage());
		}
	}

	public static void sequentialSearchOne(String[] names, String value) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(value)) {
				throw new ElementFound("The name \"" + value + "\" is at position " + i + " in the list");
			}
		}
		throw new ElementNotFound("The name \"" + value + "\" is not in the list");
	}

	public static void sequentialSearchTwo(String[] names, String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(name)) {
				System.out.println("The name \"" + name + "\" is at position " + i + " in the list");
				return;
			}
		}
		System.out.println("The name \"" + name + "\" is not in the list");
	}

	public static void displayNames(String[] names) {
		for (String name : names) {
			System.out.print(name + " ");
		}
		System.out.println();
	}
}