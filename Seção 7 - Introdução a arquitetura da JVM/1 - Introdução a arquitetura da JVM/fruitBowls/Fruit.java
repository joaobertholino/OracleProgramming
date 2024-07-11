package fruitBowls;

public class Fruit {
  private String name;
  private String color;
  private String fruitCategory;
  private Integer amountFruit;

  public Fruit(String name, String color, String fruitCategory, Integer amountFruit) {
    this.name = name;
    this.color = color;
    this.fruitCategory = fruitCategory;
    this.amountFruit = amountFruit;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getFruitCategory() {
    return this.fruitCategory;
  }

  public void setFruitCategory(String fruitCategory) {
    this.fruitCategory = fruitCategory;
  }

  public Integer getAmountFruit() {
    return this.amountFruit;
  }

  public void setAmountFruit(Integer amountFruit) {
    this.amountFruit = amountFruit;
  }

  @Override
  public String toString() {
    return "Fruit name: " + this.name + "\n" +
      "Fruit color: " + this.color + "\n" +
      "Fruit category: " + this.fruitCategory + "\n" +
      "Fruit amount: " + this.amountFruit;
  }

}