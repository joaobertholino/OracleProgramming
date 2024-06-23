package model.entities;

public class Student implements Comparable<Student> {
	private String firstName;
	private String lastName;
	private Integer mark;

	public Student(String firstName, String lastName, Integer mark) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mark = mark;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "First Name: " + this.firstName + "\n" +
				"Last Name: " + this.lastName + "\n" +
				"Mark: " + this.mark;
	}

	@Override
	public int compareTo(Student other) {
		return this.mark.compareTo(other.getMark());
	}
}
