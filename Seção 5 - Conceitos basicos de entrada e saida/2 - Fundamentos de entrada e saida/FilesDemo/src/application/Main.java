package application;

import model.services.FilesDemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	/**
	 * Método principal onde é declarado três variáveis do tipo {@code Path}, todas recebem o retorno do método estático
	 * {@code get} da classe {@code Paths}. A primeira variável chamada {@code dirPath} é passado uma string como
	 * argumento ao método {@code get} que representa o caminho absoluto que sera criado, caso não exista. A segunda
	 * variável chamada {@code usersFilePath} é passado uma string como argumento ao método {@code get} que representa o
	 * nome do arquivo que sera criado, caso não exista. A terceira variável chamada {@code settingsFilePath} é passado
	 * uma string como argumento para o método {@code get} que representa o nome do arquivo que sera criado, caso não
	 * exista.
	 * <p>
	 * Por fim, é declarado um bloco {@code try-catch} onde é declarado duas variáveis do tipo {@code Path}, das quais
	 * irão receber o retorno da chamada do método estático {@code checkFiles} da classe {@code FilesDemo} que, em
	 * seguida, é chamado o método estático {@code displayFileStatus}, passando como argumento as duas variáveis
	 * {@code users} e {@code settings}.
	 * <p>
	 * Caso ocorra uma exceção, essa exceção sera capturada pelo bloco {@code catch} e sera exibida a sua mensagem padrão
	 * no console.
	 */
	public static void main(String[] args) {
		Path dirPath = Paths.get("C:\\Users\\joaob\\OneDrive\\Documentos\\SENAI\\OracleProgramming\\Seção 5 - Conceitos basicos de entrada e saida\\2 - Fundamentos de entrada e saida\\FileDemoArchives");
		Path usersFilePath = Paths.get("HighScores.txt");
		Path settingsFilePath = Paths.get("Settings.txt");

		try {
			Path users = FilesDemo.createFiles(dirPath, usersFilePath);
			Path settings = FilesDemo.createFiles(dirPath, settingsFilePath);

			if (users != null) {
				displayFileStatus(users, settings);
			}
			if (FilesDemo.deleteFile(dirPath)) {
				System.err.println(users + " - Deleted");
			}
			if (FilesDemo.deleteFile(settings)) {
				System.err.println(settings + " - Deleted");
			}
		} catch (IOException e) {
			System.err.println(e.getClass() + "\n" + e.getMessage());
		}
	}

	/**
	 * Método estático, sem retorno, que recebe dois objetos da classe {@code Path} como argumento e propaga uma exceção
	 * verificada do tipo {@code IOException} para o escopo do qual este método é chamado.
	 * <p>
	 * Este método declara uma sequencia de {@code System.out.println} que imprimem no console o retorno de cada um dos
	 * métodos estáticos da classe {@code Files} de verificação de propriedades do objeto da classe {@code Path} passados
	 * como argumento para eles.
	 *
	 * @param users    Parâmetro que espera receber um objeto da classe {@code Path}.
	 * @param settings Parâmetro que espera receber um objeto da classe {@code Path}.
	 * @throws IOException Exceção verificada que é propagada para o escopo do qual este método é chamado.
	 */
	public static void displayFileStatus(Path users, Path settings) throws IOException {
		System.out.println("Readable: " + Files.isReadable(users));
		System.out.println("Writeable: " + Files.isWritable(users));
		System.out.println("Executable: " + Files.isExecutable(users));
		System.out.println("Hidden: " + Files.isHidden(users));
		System.out.println("Same files: " + Files.isSameFile(users, settings));
	}
}