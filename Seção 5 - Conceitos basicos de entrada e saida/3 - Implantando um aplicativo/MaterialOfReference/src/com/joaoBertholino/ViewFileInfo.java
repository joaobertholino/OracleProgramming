package com.joaoBertholino;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ViewFileInfo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("C:/LineTests/TestResults.txt"))) {
			StringBuilder fileContents = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				fileContents.append(line);
				fileContents.append(System.lineSeparator());
				line = br.readLine();
			} // end while
			String everything = fileContents.toString();
			System.out.println(everything);
		} // end try
	}// end main

}