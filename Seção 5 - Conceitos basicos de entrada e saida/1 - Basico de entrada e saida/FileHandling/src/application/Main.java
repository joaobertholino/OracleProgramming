package application;

import model.services.FileHandling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	/**
	 * Método principal que instancia um {@code ArrayList} do tipo {@code String} que sera passado como argumento para a
	 * chamada do método estático {@code readFile} da classe {@code FileHandling}, e o método estático {@code writeFile}
	 * também da classe {@code FileHandling}, do qual, utilizando um bloco try-catch, é capturado quaisquer exceções do
	 * tipo {@code IOException} ou seus subtipos, exibindo a mensagem de erro referente no console caso ocorra.
	 * <p>
	 * Por fim, é chamado o método estático {@code displayEmployees} para imprimir cada um dos elementos, do quais cada um
	 * representa uma linha lida do arquivo, no console.
	 */
	public static void main(String[] args) {
		ArrayList<String> employees = new ArrayList<>();

		try {
			FileHandling.readFile(employees);
			FileHandling.writeFile(employees);
		} catch (IOException e) {
			System.err.println(Arrays.toString(e.getStackTrace()));
		}
		displayEmployees(employees);
	}

	/**
	 * Método estático simples, sem retorno, que recebe um {@code ArrayList} do tipo {@code String} que cada um de seus
	 * elementos sera exibido no console por meio de um loop {@code for}.
	 * @param employees Um {@code ArrayList} contendo cada uma das linhas lidas do arquivo.
	 */
	public static void displayEmployees(ArrayList<String> employees) {
		for (int i = 0; i < employees.size(); i++) {
			System.out.println((i + 1) + ". " + employees.get(i));
		}
	}
}