package application;

import model.entities.Cookie;

public class BakeryDriver {
	public static void main(String[] args) {
		Cookie cookie = new Cookie("Chocolate", 5.0);
		
		System.out.println("Type: " + cookie.getType());
		System.out.println("Item Name: " + cookie.getItemName());
		cookie.setPrice(10.0);
		System.out.println("Price: " + cookie.getPrice());
		System.out.println("Department: " + cookie.getDepartment());
	}
}
