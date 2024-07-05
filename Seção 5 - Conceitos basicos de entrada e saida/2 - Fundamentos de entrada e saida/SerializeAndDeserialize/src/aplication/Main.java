package aplication;

import model.entities.Course;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		Path path = Paths.get("C:\\Users\\joaob\\OneDrive\\Documentos\\SENAI\\OracleProgramming\\Seção 5 - Conceitos basicos de entrada e saida\\2 - Fundamentos de entrada e saida\\SerializeAndDeserializeArchives\\details.ser");
		Course myCourse = new Course("Java Programming", "Oracle", "JP", 60);

		serializeData(myCourse, path);
		Course savedCourse = deSerializeData(path);

		displayData(savedCourse);
	}

	public static void serializeData(Course courseObject, Path path) {
		try (FileOutputStream fileOut = new FileOutputStream(path.toString()); ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
			objOut.writeObject(courseObject);
		} catch (IOException e) {
			System.err.println(e.getClass() + " - " + e.getMessage());
		}
	}

	public static Course deSerializeData(Path path) {
		try (FileInputStream fileIn = new FileInputStream(path.toString()); ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
			return (Course) objIn.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.err.println(e.getClass() + " - " + e.getMessage());
			return null;
		}
	}

	public static void displayData(Course course) {
		System.err.println("Deserialized Course Details:");
		System.out.println(course);
	}
}