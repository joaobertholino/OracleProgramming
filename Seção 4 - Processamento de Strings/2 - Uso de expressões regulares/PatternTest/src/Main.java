import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("[a-z0-9].{10,}@gmail[.]com");
		String str = "joaobertholino964@gmail.com";

		System.out.println(isMatch(str, pattern));
	}

	private static boolean isMatch(String str, Pattern pattern){
		Matcher match = pattern.matcher(str);
		return match.matches();
	}
}