public class Main {
	public static void main(String[] args) {
		for(String name : args) {
			if (!name.equals(args[args.length - 1])){
				System.out.print(name + " - ");
			} else {
				System.out.print(name);
			}
		}
	}
}