import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("(J|j)ava");
		String str = "Java courses are the best! You have got to love java.";
		System.out.println(str);

		Matcher matcher = pattern.matcher(str);
		str = matcher.replaceAll("Oracle");
		System.out.println(str);
	}
}