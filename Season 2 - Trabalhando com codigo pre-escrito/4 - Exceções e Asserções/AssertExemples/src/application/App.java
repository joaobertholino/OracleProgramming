package application;

public class App {
	public static void main(String[] args) {
		methodOne();
		methodTwo();
	}

	public static void methodOne() {
		int x = -10;

		if (x > 0) {
			System.out.println("Maior que zero!");
		} else {
			assert x == 0 : "Asserção executada caso a clausula retorne false.";
			System.out.println("Igual ou menor que zero!");
		}
	}

	public static void methodTwo() {
		String suit = "Card";
		switch (suit) {
		case "Clubs":
			System.out.println("Clubs");
			break;
		case "Diamonds":
			System.out.println("Diamonds");
			break;
		case "Hearts":
			System.out.println("Hearts");
			break;
		case "Spades":
			System.out.println("Spades");
			break;
		default:
			assert false : "Unknown playing card suit";
			break;
		}
	}
}
