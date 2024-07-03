package model.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReading {

	/**
	 * Método estático, sem retorno, que propaga uma exceção do tipo {@code IOException} caso ocorra qualquer exceção que
	 * seja do próprio tipo {@code IOException}, ou que seja de qualquer subtipo de {@code IOException}.
	 * <p>
	 * Neste método é instanciado um objeto da classe {@code BufferedReader}, que ira receber um objeto da classe
	 * {@code FileReader}, do qual recebera também um objeto da classe {@code File} contendo o nome totalmente qualificado
	 * do arquivo que sera feita a leitura.
	 * <p>
	 * É utilizado um loop {@code while} que sera executado enquanto a variável {@code line}, variável essa que recebe
	 * um linha do arquivo passado, for diferente de {@code null}, adicionando cada linha lida ao ArrayList recebido como
	 * argumento.
	 * <p>
	 * Por fim, a stream do objeto {@code BufferedReader} chamando o método {@code close}, assim liberando quaisquer
	 * recursos referentes a essa stream.
	 * @param employees Um ArrayList do tipo {@code String} que armazenada todas as linhas lidas do arquivo passado.
	 * @throws IOException Exceção a ser propagada para o escopo onde foi chamado o método.
	 */
	public static void readFile(ArrayList<String> employees) throws IOException {
		String pathStr = "C:\\Users\\joaob\\OneDrive\\Documentos\\SENAI\\OracleProgramming\\Seção 5 - Conceitos basicos de entrada e saida\\1 - Basico de entrada e saida\\employees.txt";
		BufferedReader fileInput = new BufferedReader(new FileReader(new File(pathStr)));
		String line = fileInput.readLine();

		while (line != null) {
			employees.add(line);
			line = fileInput.readLine();
		}
		fileInput.close();
	}
}
