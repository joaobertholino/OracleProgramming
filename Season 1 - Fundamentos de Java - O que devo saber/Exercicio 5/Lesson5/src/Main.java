import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter a random number: ");
		int randomNumber = in.nextInt();

		System.err.println(methodOne(randomNumber));
	}

	public static String methodOne(int number) {
		if (number == 7) {
			return "That’s lucky!";
		} else if (number == 13) {
			return "That’s unlucky!";
		} else {
			return "That number is neither lucky nor unlucky!";
		}
	}
}