package application;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		Path p1 = Paths.get("C:/JavaProgramming/IO/Logs/errorLogs.txt");
		Path p2 = Paths.get("C:/JavaProgramming/IO");
		Path p3 = p2.relativize(p1);
		System.out.println(p3);
	}
}