package model.entities;

public class Dog extends Animal {
	private String name;
	private String breed;
	private String barkNoise;
	private Double weight;

	public Dog() {
	}

	public Dog(String name, String breed, Double weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}

	public Dog(String color, String name, String breed, String barkNoise, Double weight) {
		super(color);
		this.name = name;
		this.breed = breed;
		this.barkNoise = barkNoise;
		this.weight = weight;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return this.breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String bark() {
		return barkNoise;
	}

	public void bark(String barkNoise) {
		this.barkNoise = barkNoise;
	}
}
