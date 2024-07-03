package model.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileHandling {

	/**
	 * Método estático, sem retorno, que recebe um {@code ArrayList} do tipo {@code String} como argumento, propagando
	 * qualquer exceção do tipo {@code IOException}, ou que seja subtipo de {@code IOException} para o escopo onde este
	 * método é chamado.
	 * <p>
	 * Utilizando o método estático {@code get} da classe {@code Paths}, passando como argumento uma string que representa
	 * o nome totalmente qualificado do arquivo que sera lido, retorna-se um objeto da classe {@code Path}, sendo
	 * armazenado em uma variável.
	 * <p>
	 * Apos isso, é instanciado um objeto da classe {@code BufferedReader} por meio da chamada do método estático
	 * {@code newBufferedReader} da classe {@code Files}, passando com argumento o objeto da classe {@code Path}
	 * instanciado anteriormente, junto com um objeto da classe {@code Charset} instanciado a partir da chamada do método
	 * estático {@code forName} do qual recebe uma string indicando o padrão de decodificação de caracteres do arquivo.
	 * <p>
	 * Por fim, é atribuído a uma variável do tipo {@code String} o retorno do método {@code readLine} do objeto da classe
	 * {@code BufferedReader}, que se refere ao conteúdo lido da linha atual do arquivo. Utilizando um loop while que ira
	 * ser executado enquanto a variável que contem o contúdo da linha do arquivo for diferente de {@code null},
	 * adicionando cada linha lida ao {@code ArrayList} recebido como argumento.
	 * <p>
	 * Apos isto, a stream do objeto da classe {@code BufferedReader} é fechado, liberando quaisquer recursos relacionados
	 * a ele.
	 *
	 * @param employees Um {@code ArrayList} do tipo {@code String} que recebe o resultado de cada linha lida do arquivo.
	 * @throws IOException Exceção a ser propagada para o escopo da chamada deste método.
	 */
	public static void readFile(ArrayList<String> employees) throws IOException {
		Path path = Paths.get("C:\\Users\\joaob\\OneDrive\\Documentos\\SENAI\\OracleProgramming\\Seção 5 - Conceitos basicos de entrada e saida\\1 - Basico de entrada e saida\\employees.txt");
		BufferedReader fileInput = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));

		String line = fileInput.readLine();
		while (line != null) {
			employees.add(line);
			line = fileInput.readLine();
		}
		fileInput.close();
	}

	/**
	 * Um método estático, sem retorno, que recebe um {@code ArrayList} do tipo {@code String}, da qual ira conter o
	 * conteúdo a ser gravado no arquivo, propagando uma exceção do tipo {@code IOException} para o escopo onde este
	 * método foi chamado.
	 * <p>
	 * É instanciado um objeto da classe {@code Path} por meio do método estático {@code get} da classe {@code Paths}, do
	 * qual recebe uma string que representa o nome totalmente qualificado do arquivo que sera criado ou modificado.
	 * <p>
	 * É também instanciado um objeto da classe {@code BufferedWriter} por meio do método estático {@code newBufferedWriter}
	 * da classe {@code Files} que recebe um objeto da classe {@code Path}, um objeto da classe {@code Charset} instanciado
	 * por meio do seu método estático {@code forName} que recebe uma string que representa a definição de decodificação
	 * de caracteres, junto a esses argumentos, o método {@code newBufferedWriter} recebe também dois argumentos de tipo
	 * enumerado da classe {@code StandardOpenOption} chamando os valores {@code CREATE} e {@code WRITE} respectivamente.
	 * <p>
	 * Apos isso, é feita a iteração do {@code ArrayList} recebido como argumento por meio de um {@code forEach}, do qual,
	 * ira gravar cada um de seus elementos do tipo {@code String} no arquivo utilizando o método {@code write} do
	 * objeto da classe {@code BufferedWriter}, em seguida, é chamado o método {@code newLine} também do objeto da classe
	 * {@code BufferedWriter} que ira definir um separador de linha apos a gravação de cada elemento do {@code ArrayList}
	 * no arquivo.
	 * <p>
	 * Por fim, utiliza-se o método {@code close} do objeto da classe {@code BufferedWriter} que é responsável por fechar
	 * a stream, liberando quaisquer recursos do sistema referentes a essa stream.
	 * @param employees Um {@code ArrayList} do tipo {@code String} que contem todos os elementos que serão gravados no
	 *                  arquivo.
	 * @throws IOException Exceção a ser propagada ao escopo do qual este método foi chamado.
	 */
	public static void writeFile(ArrayList<String> employees) throws IOException {
		Path path = Paths.get("C:\\Users\\joaob\\OneDrive\\Documentos\\SENAI\\OracleProgramming\\Seção 5 - Conceitos basicos de entrada e saida\\1 - Basico de entrada e saida\\userNames.txt");
		BufferedWriter bufferedWriter = Files.newBufferedWriter(path, Charset.forName("ISO-8859-1"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

		for (String employee : employees) {
			bufferedWriter.write(employee);
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
	}
}
