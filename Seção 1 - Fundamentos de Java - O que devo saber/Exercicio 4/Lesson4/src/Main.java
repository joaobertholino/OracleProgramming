import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(methodOne(in));

		in.close();
	}

	public static String methodOne(Scanner in) {
		System.out.print("Enter your age: ");
		int age = in.nextInt();

		System.out.print("Do you have a driver's license ? ");
		char response = in.next().charAt(0);

		if (age >= 21 && response == 'Y') {
			return "You are an adult and can hire a car!";
		} else {
			return "You are not an adult so cannot hire a car!";
		}
	}
}