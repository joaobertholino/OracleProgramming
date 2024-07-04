package model.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesDemo {

	/**
	 * Método estático que retorna um objeto da classe {@code Path} recebendo dois objetos da classe {@code Path} como
	 * argumento e propagando uma exceção verificada do tipo {@code IOException} para o escopo do qual este método é
	 * chamado.
	 * <p>
	 * É declarado uma variável do tipo {@code Path} que recebe o retorno do método {@code resolve} chamado a partir do
	 * parâmetro {@code dirPath}, recebendo o objeto da classe {@code Path} do parâmetro {@code filePath} como argumento.
	 * <p>
	 * Utilizando a estrutura condicional {@code if}, é verificado se o diretório do parâmetro {@code dirPath} não existe,
	 * utilizando o método estático {@code notExists} da classe {@code Files}, se não existir, esse diretório sera criado
	 * com base no objeto da classe {@code Path} fornecido, utilizando o método {@code createDirectories} da classe
	 * {@code Files}.
	 * <p>
	 * Apos isso, é verificado se o diretório armazenado na variável {@code absPath} não existe, utilizando o método
	 * estático {@code notExists} da classe {@code Files}, se não existir, esse arquivo sera criado com base no diretório
	 * do objeto da classe {@code Path} fornecido, utilizando o método {@code createFile} da classe {@code Files}.
	 * <p>
	 * Por fim, o método retorna um objeto da classe {@code Path} que representa um diretório absoluto, ou seja, que
	 * contem um nó {@code root}.
	 *
	 * @param dirPath  Parâmetro que espera receber um objeto da classe {@code Path}, do qual representa um diretório
	 *                 absoluto.
	 * @param filePath Parâmetro que espera receber um objeto da classe {@code Path}, do qual representa um diretório
	 *                 relativo.
	 * @return Um objeto da classe {@code Path} que representa a resolução do objeto {@code dirPath} e do objeto
	 * {@code filePath}.
	 * @throws IOException Propaga esta exceção para o escopo do qual este método é chamado.
	 */
	public static Path createFiles(Path dirPath, Path filePath) throws IOException {
		Path absPath = dirPath.resolve(filePath);
		if (Files.notExists(dirPath)) {
			Files.createDirectories(dirPath);
		}
		if (Files.notExists(absPath)) {
			Files.createFile(absPath);
		}
		return absPath;
	}

	/**
	 * Método estático que torna um primitivo do tipo {@code boolean} recebendo um objeto da classe {@code Path} como
	 * argumento, propagando uma exceção do tipo {@code IOException} para o escopo do qual este método é chamado.
	 * <p>
	 * É declarado um bloco {@code if} onde é verificado se o objeto da classe {@code Path} existe utilizando o método
	 * estático {@code exists} da classe {@code Files}. Se existir, este arquivo sera deletado utilizando o método
	 * estático {@code delete} da classe {@code Files} passando o objeto da classe {@code Path} como argumento e retornando
	 * {@code true}, se não existir, o método apenas retorna false.
	 * @param filePath Objeto da classe {@code Path} que representa um arquivo a ser deletado.
	 * @return {@code true} se, e somente se, o arquivo do objeto passado como argumento existir e for deletado.
	 * @throws IOException Exceção que será propagada para o escopo do qual este método é chamado.
	 */
	public static boolean deleteFile(Path filePath) throws IOException {
		if (Files.exists(filePath)) {
			Files.delete(filePath);
			return true;
		}
		return false;
	}
}
