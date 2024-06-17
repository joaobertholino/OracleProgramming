package model.entities;

public class Cookie implements Item {
	private String cookieType;
	private Double price;

	public Cookie(String cookieType, Double price) {
		this.cookieType = cookieType;
		this.price = price;
	}

	@Override
	public String getItemName() {
		return "Cookie";
	}

	@Override
	public Double getPrice() {
		return this.price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String getDepartment() {
		return "Bakery";
	}

	public String getType() {
		return this.cookieType;
	}
}
