import java.io.IOException;
import java.nio.file.*;

public class Main {
	public static void main(String[] args) {
		Path pathBase = Paths.get("C:/Users/joaob/OneDrive/Documentos/SENAI/OracleProgramming/Seção 5 - Conceitos basicos de entrada e saida/2 - Fundamentos de entrada e saida/FilesCopyDemoArchives");
		Path directoryScores = Paths.get("Scores");
		Path directoryBackup = Paths.get("Backup");
		Path fileHighScores = Paths.get("HighScores.txt");

//		pathBase + directoryScores
		Path originalDirectory = pathBase.resolve(directoryScores);

//		pathBase + (directoryScores + fileHighScores)
		Path originalFile = pathBase.resolve(directoryScores.resolve(fileHighScores));

//		pathBase + directoryBackup
		Path backupDirectory = pathBase.resolve(directoryBackup);

//		pathBase + (directoryBackup + fileHighScores)
		Path backupFile = pathBase.resolve(directoryBackup.resolve(fileHighScores));

		try {
			if (Files.exists(originalFile)) {
				if (Files.notExists(backupDirectory)) {
					Files.createDirectories(backupDirectory);
				}
				Files.copy(originalFile, backupFile, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
			}
			if (Files.notExists(originalDirectory)) {
				Files.createDirectories(originalDirectory);
			}
			if (Files.notExists(originalFile)) {
				Files.createFile(originalFile);
			}
		} catch (IOException x) {
			System.err.println(x.getClass());
		}
	}
}