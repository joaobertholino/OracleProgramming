public class Main {
	public static void main(String[] args) {
		String str = "help    me   I have   no idea   what's  going on!     !   !";
		System.out.println(str);

		str = str.replaceAll(" {2,}", " ");
		System.out.println(str);
	}
}