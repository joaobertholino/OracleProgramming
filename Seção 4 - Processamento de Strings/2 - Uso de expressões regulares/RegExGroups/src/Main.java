import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Pattern pattern = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
		String date = getDate(in, pattern);

		if (date == null) {
			System.err.println("Invalid Date!");
		} else {
			System.out.println("US style date: " + date);
		}
		in.close();
	}

	private static String getDate(Scanner in, Pattern pattern) {
		String date;
		Matcher matcher;
		boolean validateDate;
		do {
			System.out.print("Enter a date in the format (DD/MM/YYYY): ");
			date = in.nextLine();
			matcher = pattern.matcher(date);

			validateDate = validateDate(date);
			if (matcher.matches() && validateDate) {
				String day = matcher.group(1);
				String month = matcher.group(2);
				String year = matcher.group(3);
				date = month + "/" + day + "/" + year;
				return date;
			}
		} while (!(matcher.matches() && validateDate));
		return null;
	}

	private static boolean validateDate(String newDate) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.setLenient(false);

		try {
			format.parse(newDate);
			return true;
		} catch (ParseException e) {
			System.err.println(newDate + " is not valid according to " + format.toPattern() + " pattern.");
			return false;
		}
	}
}