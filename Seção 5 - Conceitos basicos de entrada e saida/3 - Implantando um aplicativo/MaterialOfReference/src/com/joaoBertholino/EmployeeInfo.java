package com.joaoBertholino;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeInfo {
	StringBuilder name;
	String code;
	String deptId;
	Pattern p;
	Scanner in;

	public EmployeeInfo() {
		in = new Scanner(System.in);
		name = new StringBuilder();
		p = Pattern.compile("[A-Z][a-z]{3}[0-9]{2}");

		setName();
		setDeptId();
	}

	public StringBuilder getName() {
		return this.name;
	}

	public String getCode() {
		return this.code;
	}

	public String getDeptId() {
		return this.deptId;
	}

	private void setDeptId() {
		boolean correctFormat;
		String id = getId();
		correctFormat = validId(id);
		System.out.println(correctFormat);
		if (correctFormat) {
			id = reverseString(id);
			this.deptId = id;
		} else {
			this.deptId = "None00";
		}
	}

	// A method to reverse a string using recursion
	public String reverseString(String id) {
		char c = id.charAt(id.length() - 1);
		if (id.length() == 1) {
			return Character.toString(c);
		}

		return c + reverseString(id.substring(0, id.length() - 1));
	}

	private String getId() {
		String id = "";
		System.out.print("Please Enter your department ID: ");
		id = in.next();

		return id;
	}

	private boolean validId(String id) {
		Matcher match = p.matcher(id);

		return match.matches();
	}// end method rhymningAnimal

	private void setName() {
		Boolean found;
		StringBuilder name = new StringBuilder(inputName());

		found = checkName(name);
		if (found) {
			this.name = name;
			createEmployeeCode(name);
		} else {
			System.out.println("Incorrect data entered! Default values used");
			this.name.append("guest");
			this.code = "guest";
		}

		// endif
	}

	private void createEmployeeCode(StringBuilder name) {
		String temp;
		int pos;

		temp = (name.substring(0, 1));
		pos = name.indexOf(" ");
		temp = temp + (name.substring(pos + 1));

		this.code = temp;
	}

	private String inputName() {
		String name = "";
		System.out.print("Please Enter your first and second name: ");
		name = in.nextLine();

		return name;
	}

	private boolean checkName(StringBuilder name) {
		int found;
		found = name.indexOf(" ");
		if (found < 0) {
			return false;
		}
		else {
			return true;
		// endif
		}
	}

	@Override
	public String toString() {
		return "\n" + "Employee Code  : " + this.code + "\nDepartment Number : " + this.deptId + "\n";

	}
}
