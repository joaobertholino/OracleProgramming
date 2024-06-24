package application;

import model.exception.ElementFound;
import model.exception.ElementNotFound;

public class Main {
	public static void main(String[] args) {
		int[] numbers = {2, 10, 16, 34, 37, 56, 57, 76, 81, 83, 85};

		displayNumbers(numbers);
		try {
			if (binarySearchOne(numbers, 77)) System.out.println("Valor encontrado!");
		} catch (ElementFound | ElementNotFound e) {
			System.err.println(e.getMessage());
		}
	}

	public static boolean binarySearchOne(int[] numbers, int value) {
		int low = 0;
		int high = numbers.length - 1;
		while (high >= low) {
			int middle = (low + high) / 2;
			if (numbers[middle] == value) {
				return true;
			}
			if (numbers[middle] < value) {
				low = middle + 1;
			}
			if (numbers[middle] > value) {
				high = middle - 1;
			}
		}
		throw new ElementNotFound("The number \"" + value + "\" is not in the list");
	}

	public static void displayNumbers(int[] numbers) {
		for (int num : numbers) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}