import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		byte myByte = in.nextByte();
		System.out.println("Byte: " + myByte);

		short myShort = in.nextShort();
		System.out.println("Short: " + myShort);

		int myInt = in.nextInt();
		System.out.println("Int: " + myInt);

		long myLong = in.nextLong();
		System.out.println("Long: " + myLong);

		char myChar = in.next().charAt(0);
		System.out.println("Char: " + myChar);

		boolean myBoolean = in.nextBoolean();
		System.out.println("Boolean: " + myBoolean);

		in.close();
	}
}