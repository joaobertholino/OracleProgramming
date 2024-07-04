import java.io.IOException;
import java.nio.file.*;

public class Main {
	public static void main(String[] args) {
		Path p = Paths.get("C:/JavaProgramming/gameData");
		Path p1 = Paths.get("scores");
		Path p2 = Paths.get("backup");
		Path p3 = Paths.get("Highscores.txt");

		Path woD = p.resolve(p1);
		Path woF = p.resolve(p1.resolve(p3));
		Path buD = p.resolve(p2);
		Path buF = p.resolve(p2.resolve(p3));

		try {
			if (Files.exists(woF)) {
				if (Files.notExists(buD)) {
					Files.createDirectories(buD);
				}
				Files.copy(woF, buF, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
			}
			if (Files.notExists(woD)){
				Files.createDirectories(woD);
			}
			if (Files.notExists(woF)) {
				Files.createFile(woF);
			}
		} catch (IOException x) {
			System.err.println(x.getClass());
		}
	}
}