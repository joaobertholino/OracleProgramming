package application;

import java.util.ArrayList;

import model.entities.GenericClass;

public class App {
	public static void main(String[] args) {
		Double[] integers = new Double[5];
		integers[0] = 122.12;
		integers[1] = 123.13;
		integers[2] = 124.14;
		integers[3] = 125.15;
		integers[4] = 126.16;
		
		System.out.println(GenericClass.printArray(integers));
		
		String[] strings = new String[5];
		strings[0] = "Joao";
		strings[1] = "Ellen";
		strings[2] = "Nicolas";
		strings[3] = "Irineu";
		strings[4] = "Fabio";

		System.out.println(GenericClass.printArray(strings));
		GenericClass.printList(GenericClass.printArray(strings));
		
		System.out.println(GenericClass.sumOfList(GenericClass.printArray(integers)));
		
		ArrayList<Integer> listNumber = new ArrayList<Integer>();
		GenericClass.addNumbers(listNumber);
		System.out.println(listNumber);
	}
}
