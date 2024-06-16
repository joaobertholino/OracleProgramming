package model.entities;

public class Fish extends Animal {
	private String name;
	private String waterType;
	private Double weight;

	public Fish() {
	}

	public Fish(String name, String waterType, Double weight) {
		this.name = name;
		this.waterType = waterType;
		this.weight = weight;
	}

	public Fish(String color, String name, String waterType, Double weight) {
		super(color);
		this.name = name;
		this.waterType = waterType;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWaterType() {
		return waterType;
	}

	public void setWaterType(String waterType) {
		this.waterType = waterType;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
}
