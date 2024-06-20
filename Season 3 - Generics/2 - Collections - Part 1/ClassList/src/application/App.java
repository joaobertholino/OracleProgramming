package application;

import java.util.ArrayList;
import java.util.Collections;

public class App {

	public static void main(String[] args) {
		ArrayList<String> studentNames = new ArrayList<>();
		addStudents(studentNames, "Joao");
		addStudents(studentNames, "Ellen");
		addStudents(studentNames, "Nicolas");
		addStudents(studentNames, "Adriano");
		addStudents(studentNames, "Irineu");
		addStudents(studentNames, "Lucas");
		addStudents(studentNames, "Fabio");
		addStudents(studentNames, "Marcos");
		addStudents(studentNames, "Ronaldo");
		addStudents(studentNames, "Guilherme");
		
		System.out.println(displayStudent(studentNames));
		
		Collections.sort(studentNames);
		
		System.out.println(displayStudent(studentNames));
	}
	
	public static void addStudents(ArrayList<String> list, String nameStudent) {
		list.add(nameStudent);
	}
	
	public static StringBuilder displayStudent(ArrayList<String> list) {
		StringBuilder result = new StringBuilder("");
		for(String name : list) {
			result.append("Student name: " + name + "\n");
		}
		return result;
	}
}
