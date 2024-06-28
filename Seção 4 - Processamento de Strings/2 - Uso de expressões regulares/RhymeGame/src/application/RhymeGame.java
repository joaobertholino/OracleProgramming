package application;

import java.util.Scanner;

public class RhymeGame {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String animal = getAnimal(in);

		if (rhymningAnimal(animal)) {
			System.out.println("This animal rhymes with \"cat\"!");
		} else {
			System.out.println("This animal doesn't rhyme!");
		}

		in.close();
	}

	private static boolean rhymningAnimal(String animal) {
		return animal.matches("[a-zA-Z]{1,2}(at|AT)");
	}

	private static String getAnimal(Scanner in) {
		System.out.print("Please enter the name of the animal: ");
		return in.nextLine();
	}
}