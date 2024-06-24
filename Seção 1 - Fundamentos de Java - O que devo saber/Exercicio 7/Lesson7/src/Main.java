import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(Arrays.toString(methodOne(in)));
		in.close();
	}

	public static int[] methodOne(Scanner in) {
		int[] numbers = new int[5];
		int num;
		int numValues = 0;
		boolean valid;

		while (numValues < numbers.length) {
			do {
				valid = true;
				System.out.print("Enter a valid unique number: ");
				num = in.nextInt();
				for (int i = 0; i < numbers.length; i++) {
					if (num == numbers[i]) {
						System.err.println("This number already exists");
						valid = false;
						break;
					}
				}
			} while (!valid);
			numbers[numValues] = num;
			numValues++;
		}
		return numbers;
	}
}