import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Lista de numeros: " + methodOne(in));
	}

	public static ArrayList<Integer> methodOne(Scanner in) {
		System.out.print("Enter a lucky number (Enter 0 to exit): ");
		ArrayList<Integer> list = new ArrayList<>();
		int number;
		do {
			number = in.nextInt();
			list.add(number);
		} while (number != 0);
		return list;
	}
}