public class Main {
	public static void main(String[] args) {
//		Teste de imutabilidade.
		StringBuilder str = new StringBuilder("Test immutability");
		String str2 = "Test immutability";

		System.out.println("StringBuilder: " + str.hashCode());
		System.out.println("String: " + str2.hashCode());

		str.replace(0, str.length(), "Learning Java with Oracle");
		str2 = "Learning Java with Oracle";

		System.out.println("StringBuilder: " + str.hashCode());
		System.out.println("String: " + str2.hashCode());

//		Métodos em comum entre objetos String e StringBuilder.
		System.out.println("StringBuilder = " + str);
		System.out.println("The length of the text is: " + str.length());
		System.out.println("The character at the beginning is: " + str.charAt(0));
		System.out.println("The second character is: " + str.charAt(1));
		System.out.println("The position of the start of the text \"acl\" is: " + str.indexOf("acl"));
		System.out.println("The following text is included within the String: " + str.substring(1, 4));

//		Demonstração dos métodos: append, reverse, delete, insert, replace, indexOf.
		System.out.println("Reverse = " + str.reverse());
		System.out.println("Reverse = " + str.reverse());

		str.append(" is fun");
		System.out.println("Appended string = " + str);

		str.delete(8, 13);
		System.out.println("Deleted string = " + str);

		str.insert(8, " Java Programming");
		System.out.println("Inserted string = " + str);

		str.replace(13, 25, " String Processing");
		System.out.println("Replaced string = " + str);

		System.out.println(str.indexOf("a"));
		System.out.println(str.indexOf("Q"));

		System.out.println(str.indexOf("a", 7));
	}
}