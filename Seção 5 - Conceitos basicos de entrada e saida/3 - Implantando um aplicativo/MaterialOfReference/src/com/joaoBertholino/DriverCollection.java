package com.joaoBertholino;
import java.util.ArrayList;

public class DriverCollection {

	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<>();
		products.add(new AudioPlayer("SilverFox1", "Latest audio player"));
		products.add(new AudioPlayer("SilverFox1", "Latest audio player"));
		products.add(new AudioPlayer("SilverFox1", "Latest audio player"));
		products.add(new AudioPlayer("SilverFox1", "Latest audio player"));

		products.add(new MoviePlayer("SilverFoxTV1", new Screen("600x400", 40, 22), MonitorType.LED));
		products.add(new MoviePlayer("SilverFoxTV1", new Screen("600x400", 40, 22), MonitorType.LED));
		products.add(new MoviePlayer("SilverFoxTV1", new Screen("600x400", 40, 22), MonitorType.LED));

		System.out.println(products);
	}

}
