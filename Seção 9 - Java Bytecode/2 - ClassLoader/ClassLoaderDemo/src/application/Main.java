package application;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
	private final static String DISK_URL = System.getProperty("user.dir") + "\\src\\application\\Main";

	public static void main(String[] args) {
		System.out.println(Main.DISK_URL);
		try {
			URL[] urls = new URL[]{new URL(Main.DISK_URL)};
			URLClassLoader loader = new URLClassLoader(urls);
			Class<?> clazz = Class.forName("LoadingExemple", true, loader);

			System.out.println(clazz.getClassLoader());
			runTest(clazz);
		} catch (Exception e) {
			System.err.println(e.getClass() + " - " + e.getMessage());
		}
	}

	private static void runTest(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method main = clazz.getMethod("main", new Class[]{String[].class});
		Object[] args = new Object[]{new String[0]};
		main.invoke(null, args);
	}
}