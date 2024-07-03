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
	 * se não existir, esse diretório sera criado com base no objeto da classe {@code Path} fornecido, utilizando o
	 * método {@code createDirectories} da classe {@code Files}.
	 * <p>
	 * Apos isso, é verificado se o diretório armazenado na variável {@code absPath} não existe, se não existir, esse
	 * arquivo sera criado com base no diretório do objeto da classe {@code Path} fornecido, utilizando o método
	 * {@code createFile} da classe {@code Files}.
	 * <p>
	 * Por fim, o método retorna um objeto da classe {@code Path} que representa um diretório absoluto, ou seja, que
	 * contem um nó {@code root}.
	 * @param dirPath Parâmetro que espera receber um objeto da classe {@code Path}, do qual representa um diretório absoluto.
	 * @param filePath Parâmetro que espera receber um objeto da classe {@code Path}, do qual representa um diretório relativo.
	 * @return Um objeto da classe {@code Path} que representa a resolução do objeto {@code dirPath} e do objeto {@code filePath}.
	 * @throws IOException Propaga esta exceção para o escopo do qual este método é chamado.
	 */
	public static Path checkFiles(Path dirPath, Path filePath) throws IOException {
		Path absPath = dirPath.resolve(filePath);
		if (Files.notExists(dirPath)) {
			Files.createDirectories(dirPath);
		}
		if (Files.notExists(absPath)) {
			Files.createFile(absPath);
		}
		return absPath;
	}
}
