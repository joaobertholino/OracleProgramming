package application;

public class Main {
	public static void main(String[] args) {
		recurseMethod(10);

		System.out.println(fatorial(10));
	}

	public static void recurseMethod(int num) {
		if (num == 0){
			return;
		}
		else {
			System.out.println("hello " + num);
			recurseMethod(--num);
			System.out.println(num);
		}
	}

	public static int fatorial(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * fatorial(n - 1);
		}
	}
}