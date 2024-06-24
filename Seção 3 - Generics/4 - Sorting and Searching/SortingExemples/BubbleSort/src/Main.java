public class Main {
	public static void main(String[] args) {
		int[] numbers = {49, 58, 1, 2, 87};

		displayArray(numbers);
		bubbleSortOne(numbers);
//		bubbleSortTwo(numbers);
		displayArray(numbers);
	}

	public static void bubbleSortOne(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	}

	public static void bubbleSortTwo(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			boolean flag = false;
			for (int j = 0; j < numbers.length - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					flag = true;
					int temp = numbers[j + 1];
					numbers[j + 1] = numbers[j];
					numbers[j] = temp;
				}
			}
			if (!flag) {
				return;
			}
		}
	}

	public static void displayArray(int[] numbers) {
		for (int num : numbers) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}