package com.joaoBertholino;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProductionLineProgram {

	static void MainMenu() {
		System.out.println("Main Menu");
		System.out.println("-------------------------\n");
		System.out.println("1 - Enter new item");
		System.out.println("2 - List item types");
		System.out.println("3 - List all items");
		System.out.println("q - Quit");
	}

	static void AddItemMenu() {
		System.out.println("Add Item Menu");
		System.out.println("-------------------------\n");
		System.out.println("1 - Add Audio Player");
		System.out.println("2 - Add Movie Player");
		System.out.println("r - Return");
	}

	// take a regular expression and a menu choice and check if valid selection
	static String getMenuResponse(String regex, String choice) {
		if (choice.matches(regex)) {
			return choice;
		} else {
			System.out.println("Invalid Selection");
			return "error";
		}
	}

	static AudioPlayer newAudioPlayer() {
		Scanner input = new Scanner(System.in);
		System.out.print("Audio Player Details");
		System.out.print("\nName : ");
		String name = input.nextLine();
		System.out.print("\nSpecification : ");
		String specification = input.nextLine();
		AudioPlayer audioplayer = new AudioPlayer(name, specification);
		return audioplayer;
	}

	static void displayMonitorTypes() {
		System.out.println("-- Select Monitor Type --");
		int menuselection = 1;
		for (MonitorType monitor : MonitorType.values()) {
			System.out.println(menuselection + " - " + monitor);
			menuselection++;
		}

	}

	static MoviePlayer newMediaPlayer() {
		Scanner input = new Scanner(System.in);
		System.out.print("Media Player Details");
		System.out.print("\nName : ");
		String name = input.nextLine();
		System.out.print("\nResolution : ");
		String resolution = input.nextLine();
		System.out.print("\nRefresh rate : ");
		Integer refresh = input.nextInt();
		System.out.print("\nResponse time : ");
		Integer response = input.nextInt();

		displayMonitorTypes();
		// get the MonitorType associated to the menu item.
		MonitorType monitor = MonitorType.values()[input.nextInt() - 1];

		MoviePlayer movieplayer = new MoviePlayer(name, new Screen(resolution, refresh, response), monitor);
		return movieplayer;
	}

	public static <T> void main(String[] args) throws IOException {
		// public static void main(String[] args) {
		ArrayList<Product> allproducts = new ArrayList<>();
		//
		EmployeeInfo employee = new EmployeeInfo();
		ProcessFiles f = new ProcessFiles();

		Scanner input = new Scanner(System.in);
		String menuchoice = "";
		String submenuchoice = "";
		do {
			do {
				MainMenu();
				menuchoice = input.next();
				menuchoice = getMenuResponse("[123q]", menuchoice);
			} while (menuchoice.equals("error"));

			switch (menuchoice) {
			case "1":
				do {
					AddItemMenu();
					submenuchoice = input.next();
					submenuchoice = getMenuResponse("[12r]", submenuchoice);
				} while (submenuchoice.equals("error"));
				Product newproduct = null;
				int quantity = 0;
				switch (submenuchoice) {
				case "1":
					newproduct = newAudioPlayer();
					allproducts.add(newproduct);

					System.out.print("Quantity to create:");
					quantity = input.nextInt();
					for (int i = 1; i < quantity; i++) {
						allproducts.add(new AudioPlayer(newproduct.getName(), ((AudioPlayer) newproduct).getAudioSpecification()));
					}
					break;
				case "2":
					newproduct = newMediaPlayer();
					allproducts.add(newproduct);

					System.out.print("Quantity to create:");
					quantity = input.nextInt();
					for (int i = 1; i < quantity; i++) {
						allproducts.add(new MoviePlayer(newproduct.getName(), ((MoviePlayer) newproduct).getScreen(),
								((MoviePlayer) newproduct).getMonitor()));
					}
					break;
				}

				System.out.print("** Items Created! **/n");

				break;
			case "2":
				System.out.println("* Distinct products created **");
				// overridden equals and hashcode methods in product
				Set<Product> uniqueproduct = new HashSet<>(allproducts);
				System.out.println("Total Items created: " + allproducts.size());
				System.out.println("Unique products: " + uniqueproduct.size());
				System.out.println(uniqueproduct);
				break;
			case "3":
				System.out.println("* All Products Created **");
				System.out.println(allproducts);
				break;
			}

		} while (!menuchoice.equals("q"));
		System.out.println(employee.getCode());
		f.WriteFile(allproducts);
		f.WriteFile(employee);
		System.out.println(employee);

	}

}
