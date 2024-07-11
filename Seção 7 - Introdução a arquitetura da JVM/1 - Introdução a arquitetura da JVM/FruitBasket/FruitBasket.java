public class FruitBasket {
  public static void main(String[] args) {
    displayFruits(args);
  }

  private static void displayFruits(String[] fruits) {
    for (String fruit : fruits) {
      System.out.println(fruit);
    }
  }
}