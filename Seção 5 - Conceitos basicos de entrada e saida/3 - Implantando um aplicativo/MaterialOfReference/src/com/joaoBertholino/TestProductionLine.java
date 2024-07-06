package com.joaoBertholino;
import java.io.IOException;
import java.util.ArrayList;

public class TestProductionLine {

	public static <T> void main(String[] args) throws IOException {

		ArrayList<Product> products = new ArrayList<>();
		EmployeeInfo employee = new EmployeeInfo();

		products.add(new AudioPlayer("SilverFox1", "All new features"));
		products.add(new AudioPlayer("SilverFox1", "All new features"));
		products.add(new MoviePlayer("movie p1", new Screen("600x400", 40, 22), MonitorType.LCD));

		System.out.println(products);
		System.out.println(employee.getCode());

		// Product.print(products);
		// Product.printType(products,AudioPlayer.class);

	}

}
