package model.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReading {
	public static void readFile(ArrayList<String> employees) throws IOException {
		String line;
		BufferedReader fileInput;

		fileInput = new BufferedReader(new FileReader(new File("C:/JavaProgramming/employees.txt")));
		line = fileInput.readLine();

		while (line != null) {
			employees.add(line);
			line = fileInput.readLine();
		}
		fileInput.close();
	}
}
