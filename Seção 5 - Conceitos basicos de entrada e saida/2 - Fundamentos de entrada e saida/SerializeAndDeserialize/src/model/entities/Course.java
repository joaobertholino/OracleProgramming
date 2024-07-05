package model.entities;

import java.io.Serial;
import java.io.Serializable;

public class Course implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	private String courseCode;
	private int passingScore;

	public Course() {
	}

	public Course(String name, String type, String courseCode, int passingScore) {
		this.name = name;
		this.type = type;
		this.courseCode = courseCode;
		this.passingScore = passingScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public int getPassingScore() {
		return passingScore;
	}

	public void setPassingScore(int passingScore) {
		this.passingScore = passingScore;
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + "\n" +
				"Type: " + this.getType() + "\n" +
				"Course Code: " + this.getCourseCode() + "\n" +
				"Passing Score: " + this.getPassingScore();
	}
}
