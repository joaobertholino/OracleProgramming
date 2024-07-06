package com.joaoBertholino;
import java.io.IOException;

public class AddEmployee {

	public static void main(String[] args) throws IOException {
		EmployeeInfo employee = new EmployeeInfo();
		ProcessFiles f = new ProcessFiles();
		System.out.println(employee);
		f.WriteFile(employee);
	}
}
