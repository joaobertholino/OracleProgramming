package application;

public class Main {
	public static void main(String[] args) {
//		recurseMethod(10);

//		System.err.println(fatorial(5));
		System.err.println(fibonacci(4));
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

	/**
	 * Linear recursion => Contem apenas uma chamada recursiva.
	 * <p>
	 * A cada chamada recursiva cria-se uma stack de execuções que armazena o estado de cada chamada recursiva, ao atingir
	 * o caso base {@code n <= 1} é executado as chamadas da stack começando pela mais profunda, e indo até a chamada mais
	 * superficial.
	 * @param n Valor que sera usado para se calcular o fatorial do mesmo de forma recursiva linear.
	 * @return O valor total retornado por todas as chamadas recursivas.
	 */
	public static int fatorial(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * fatorial(n - 1);
		}
	}

	/**
	 * Nonlinear Recursion => Contem duas ou mais chamadas recursivas.
	 * <p>
	 * Em métodos de recursividade não-linear, neste exemplo de Fibonacci, inicia-se pela primeira chamada recursiva
	 * {@code fibonacci(n - 1)} até atingir o caso base, em sequencia é feita a segunda chamada recursiva
	 * {@code fibonacci(n - 2)} também até atingir o caso base.
	 * <p>
	 * Chamadas recursivas não-lineares são descritas de forma mais pratica utilizando diagramas de arvore, para
	 * demonstrar cada ramificação das chamadas recursivas.
	 * @param n Valor que sera usado para se calcular o fibonacci do mesmo de forma recursiva não-linear.
	 * @return O valor total de todas as chamadas recursivas.
	 */
	public static double fibonacci(double n) {
		if (n < 2) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}