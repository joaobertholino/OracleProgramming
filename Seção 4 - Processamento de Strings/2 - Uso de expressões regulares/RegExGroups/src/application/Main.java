package application;

import model.entities.IncorrectDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Pattern dateP = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
		try {
			System.out.println(getDate(in, dateP));
		} catch (IncorrectDate e) {
			System.out.println(e.getMessage());
		}

		in.close();
	}

	public static String getDate(Scanner in, Pattern dateP) {
		String date;
		Matcher dateM;
		do {
			System.out.print("Enter a Date (dd/mm/yyyy): ");
			date = in.nextLine();
			dateM = dateP.matcher(date);

			if (dateM.matches()) {
				String day = dateM.group(1);
				String month = dateM.group(2);
				String year = dateM.group(3);
				if (dateM.matches() && validateDate(date)) {
					date = month + "/" + day + "/" + year;
				} else {
					throw new IncorrectDate("Incorrect date entered");
				}
			}
		} while (!dateM.matches());
		return date;
	}

	static boolean validateDate(String newDate) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.setLenient(false);
		try {
			format.parse(newDate);
			return true;
		} catch (ParseException e) {
			System.out.println(newDate + " is not valid according to " + format.toPattern() + " pattern.");
			return false;
		}
	}
}