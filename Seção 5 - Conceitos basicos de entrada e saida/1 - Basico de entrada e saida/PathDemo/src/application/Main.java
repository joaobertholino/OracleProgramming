package application;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		Path[] paths = new Path[5];

//		Utilizando duas barras invertidas.
		paths[0] = Paths.get("C:\\JavaProgramming\\NIO2\\DemoFile.txt");

//		Utilizando apenas uma barra padrão.
		paths[1] = Paths.get("C:/JavaProgramming/NIO2/DemoFile.txt");

//		Passando cada node como um argumento.
		paths[2] = Paths.get("C:", "JavaProgramming", "NIO2", "DemoFile.txt");

//		Passando apenas o nome do arquivo - leaf node.
		paths[3] = Paths.get("DemoFile.txt");

//		Passando um objeto da classe URI retornado pelo método create que recebe uma string que representa o caminho.
		paths[4] = Paths.get(URI.create("file:///~/DemoFile.txt"));

		for (int i = 0; i < paths.length; i++) {
			System.out.println("Default File Path: " + i + ": " + paths[i]);
		}

		System.out.println("\n");

		System.out.println(paths[0].getFileName());
		System.out.println(paths[0].getParent());
		System.out.println(paths[0].getNameCount());
		System.out.println(paths[0].isAbsolute());
		System.out.println(paths[3].toAbsolutePath());
		System.out.println(paths[0].toUri());

		System.out.println("\n");

		Path rp = Paths.get("C:/JavaProgramming/IO/../NIO2//DemoFile.txt");
		System.out.println("rp.normalize(): [" + rp.normalize() + "]");

		System.out.println("\n");

		Path sp = Paths.get("C:\\Users\\joaob\\OneDrive\\Documentos\\SENAI\\OracleProgramming\\Seção 5 - Conceitos basicos de entrada e saida\\1 - Basico de entrada e saida\\Input and Output\\NIO2\\demoFiles.txt");
		System.out.println("p.subpath() [" + sp.getNameCount() + "][" + sp.subpath(0, 5) + "]");
		System.out.println("p.subpath() [" + sp.getNameCount() + "][" + (sp.normalize()).subpath(0, sp.normalize().getNameCount() - 1) + "]");

	}
}