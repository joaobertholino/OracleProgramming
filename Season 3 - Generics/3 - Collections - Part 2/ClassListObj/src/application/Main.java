package application;

import model.entities.Student;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();

		students.add(new Student("Mark", "Mywords", 95));
		students.add(new Student("Andrew", "Apic", 45));
		students.add(new Student("Beth", "Tween", 78));

		for(Student student : students) {
			System.out.println(student + "\n");
		}

		Collections.sort(students);

		for(Student student : students) {
			System.out.println(student + "\n");
		}
	}
}