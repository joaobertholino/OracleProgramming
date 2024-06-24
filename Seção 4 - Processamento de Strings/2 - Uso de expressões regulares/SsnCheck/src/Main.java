import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your SSN: ");
		String ssn = in.next();

		if (ssnChecker(ssn)) {
			System.out.println("SSN is valid!");
		} else {
			System.out.println("SSN not valid!");
		}
	}

	public static boolean ssnChecker(String ssn) {
		return ssn.matches("[0-9]{3}-[0-9]{2}-[0-9]{4}");
	}
}