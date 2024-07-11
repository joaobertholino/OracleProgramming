package fruitBowls;

import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    ArrayList<Fruit> fruits = new ArrayList<>();
    fillBowls(args, fruits);
    displayFruit(fruits);
  }

  private static void fillBowls(String[] args, ArrayList<Fruit> fruits) {
    int i = 0;

    if ((i + 4) <= args.length) {
      fruits.add(new Fruit(args[i], args[i + 1], args[i + 2], Integer.parseInt(args[i + 3])));
      i += 4;
    }
  }

  private static void displayFruit(ArrayList<Fruit> fruits) {
    for(Fruit fruit : fruits) {
      System.out.println(fruit);
    }
  }
}