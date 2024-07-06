package com.joaoBertholino;
import java.util.Date;
import java.util.List;

public abstract class Product implements Item {
	private int serialNumber;
	private String manufacturer;
	private Date manufacturedOn;
	private String name;
	public static int currentProductionNumber = 1;

	public Product(String name) {
		this.name = name;
		serialNumber = currentProductionNumber++;
		manufacturer = Item.manufacturer;
		manufacturedOn = new Date();
	}

	// hashcode used to test if two objects the same. Make all objects of same name
	// equal
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	// if hashcode matches then we test the name
	@Override
	public boolean equals(Object other) {

		Product product = (Product) other;
		return this.name.equals(product.name);
	}

	@Override
	public void setProductionNumber(int productionnumber) {
		currentProductionNumber = productionnumber;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Date getManufactureDate() {
		return manufacturedOn;
	}

	@Override
	public int getSerialNumber() {
		return serialNumber;
	}

	@Override
	public String toString() {
		return "\n" + "Name          : " + name + "\n" + "Manufacturer  : " + manufacturer + "\n" + "Serial Number : "
				+ serialNumber + "\n" + "Date          : " + manufacturedOn + "\n";
	}

	public static <T> void print(List<T> list) {
		for (T listitem : list) {
			System.out.println(listitem);
		}

	}

	public static void printType(List<? extends Product> list, Class<?> cls) {
		for (Product listitem : list) {
			if (listitem.getClass().equals(cls)) {
				System.out.println(listitem);
			}
		}
	}

}
