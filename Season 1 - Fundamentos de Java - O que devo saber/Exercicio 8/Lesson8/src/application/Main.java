package application;

import model.entities.Dog;
import model.entities.Fish;

public class Main {
	public static void main(String[] args) {
		Dog dogOne = new Dog("Ace", "Beagle", 45.6);
		dogOne.bark("Woof-Woof");
		System.out.println("Dog name: " + dogOne.getName());
		System.out.println("Dog breed: " + dogOne.getBreed());
		System.out.println("Dog weight: " + dogOne.getWeight());

		Fish fishOne = new Fish("Red", "Bailey", "Fresh Water", 10.2);
		System.out.println("Fish name: " + fishOne.getName());
		System.out.println("Fish water type: " + fishOne.getWaterType());
		System.out.println("Fish color: " + fishOne.getColor());
		System.out.println("Fish weight: " + fishOne.getWeight());
	}
}