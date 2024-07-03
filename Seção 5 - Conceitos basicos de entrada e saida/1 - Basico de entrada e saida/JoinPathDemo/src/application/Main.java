package application;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		Path basicPath = Paths.get("C:/JavaProgramming");
		Path newPath = Paths.get("IO/Logs");

		System.out.println("Basic path: " + basicPath);
		System.out.println("New path: " + newPath);

		Path basicPath2 = basicPath.resolve(newPath.toString());
		Path newPath2 = newPath.resolve(basicPath.toString());

		System.out.println("Resolve basic path: " + basicPath2);
		System.out.println("Resolve new path: " + newPath2);
	}
}