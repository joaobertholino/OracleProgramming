package application;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		String str = "Sample String";

		displayString(str);
		displayStringBackward(str);
		searchString(str, 'S');
		displayStringArray(str);
	}

	public static void displayString(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
	}

	public static void displayStringBackward(String str) {
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
	}

	public static void searchString(String str, char c) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				count++;
			}
		}
		System.out.println("The character " + c + " appears in the text " + count + " times.");
	}

	public static void displayStringArray(String string) {
		for (String str : string.split("S")) {
			System.out.print(str + " - ");
		}
	}
}