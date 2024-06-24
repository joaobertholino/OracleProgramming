import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		HashMap<String, String> fruitBowl = new HashMap<>();
		fruitBowl.put("Apple", "Green");
		fruitBowl.put("Cherry", "Red");
		fruitBowl.put("Orange", "Orange");
		fruitBowl.put("Banana", "Yellow");
		fruitBowl.put("Apple", "Red");

		System.out.println(displayElements(fruitBowl));
		System.out.println(findElement(fruitBowl, "Pear"));
	}

	public static StringBuilder displayElements(HashMap<String, String> fruitBowl) {
		StringBuilder result = new StringBuilder();
		for (HashMap.Entry<String, String> fruit : fruitBowl.entrySet()) {
			result.append("Fruit: " + fruit.getKey() + " - Color: " + fruit.getValue() + "\n");
		}
		return result;
	}

	public static String findElement(HashMap<String, String> fruitBowl, String key) {
		if (fruitBowl.containsKey(key)) {
			return fruitBowl.get(key);
		} else {
			return "Element not found!";
		}
	}
}