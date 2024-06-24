package model.entities;

import java.util.ArrayList;
import java.util.List;

public class GenericClass {
	public static <T> ArrayList<T> printArray(T[] array) {
		ArrayList<T> result = new ArrayList<>();
		for (T arrayItem : array) {
			result.add(arrayItem);
		}
		return result;
	}

	public static void printList(List<?> list) {
		for (Object ellen : list) {
			System.out.println(ellen);
		}
	}

	public static double sumOfList(ArrayList<? extends Number> arrayList) {
		double s = 0.0;
		for (Number n : arrayList) {
			s += n.doubleValue();
		}
		return s;
	}

	public static void addNumbers(ArrayList<? super Integer> arrayList) {
		for (int i = 1; i <= 10; i++) {
			arrayList.add(i);
		}
	}
}
