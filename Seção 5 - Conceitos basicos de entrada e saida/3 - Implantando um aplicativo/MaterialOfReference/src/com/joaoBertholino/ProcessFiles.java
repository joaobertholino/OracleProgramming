package com.joaoBertholino;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ProcessFiles {
	private Path p;
	private Path p2;
	private Path p3;

	public ProcessFiles() {
		p = Paths.get("C:/LineTests");
		p2 = Paths.get("TestResults.txt");
		p3 = p.resolve(p2);
		CreateDirectory();
	}

	private void CreateDirectory() {

		try {
			if (Files.notExists(p)) {
				Files.createDirectory(p);
			}
			// endif
			if (Files.notExists(p3))
			 {
				Files.createFile(p3);
			// endif
			}
		} // end try
		catch (IOException x) {
			System.err.println(x);
		} // end catch
	}// end of CreateDirectory

	public void WriteFile(EmployeeInfo emp) throws IOException {
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(p3.toString(), true)));
		writer.println(emp);
		writer.close();
	}

	public void WriteFile(ArrayList<Product> products) throws IOException {
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(p3.toString(), true)));
		writer.println(products);
		writer.close();
	}
}