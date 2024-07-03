package application;

import model.services.FileReading;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	/**
	 * Método principal que instancia um ArrayList que sera passado como argumento para a chamada do método estático
	 * {@code readFile} da classe {@code FileReading}.
	 * <p>
	 * Utiliza-se um bloco try-catch para tratar a possível exceção propagada pelo método {@code readFile}, exibindo a
	 * mensagem referente a exceção lançada.
	 */
	public static void main(String[] args) {
		ArrayList<String> employees = new ArrayList<>();

		try {
			FileReading.readFile(employees);
			displayEmployees(employees);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Método simples que recebe um ArrayList do tipo {@code String como argumento} e por meio de um loop, imprime o
	 * conteúdo do ArrayList no console.
	 * @param employees Um ArrayList do tipo {@code String}.
	 */
	public static void displayEmployees(ArrayList<String> employees) {
		for(int i = 0; i < employees.size(); i++) {
			System.out.println((i + 1) + ". " + employees.get(i));
		}
	}
}