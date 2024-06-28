import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your SSN: ");
		String ssn = in.next();

		if (ssnChecker(ssn)) {
			System.out.println("This SSN is valid!");
		} else {
			System.err.println("This SSN is not valid!");
		}

		in.close();
	}

	public static boolean ssnChecker(String ssn) {
		return ssn.matches("[0-9]{3}-[0-9]{2}-[0-9]{4}");
	}
}