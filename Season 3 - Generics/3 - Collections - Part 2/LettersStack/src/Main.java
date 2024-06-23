import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList<String> lettersStack = new LinkedList<>();

		lettersStack.push("A");
		lettersStack.push("B");
		lettersStack.push("C");
		lettersStack.push("D");

		System.out.println("Linked List: " + lettersStack);
		System.out.println("Stack Size: " + lettersStack.size());

		while (!lettersStack.isEmpty()) {
			System.out.println(lettersStack.pop());
		}
		System.out.println("Linked List: " + lettersStack);
	}
}