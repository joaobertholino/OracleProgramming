import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
	public static void main(String[] args) {
		Path pathBase = Paths.get("C:/Users/joaob/OneDrive/Documentos/SENAI/OracleProgramming/Seção 5 - Conceitos basicos de entrada e saida/2 - Fundamentos de entrada e saida/FilesCopyDemoArchives");
		Path directoryScores = Paths.get("Scores");
		Path directoryBackup = Paths.get("Backup");
		Path fileHighscores = Paths.get("HighScores.txt");

//		pathBase + directoryScores
		Path originalDirectory = pathBase.resolve(directoryScores);

//		pathBase + (directoryScores + fileHighscores)
		Path originalFile = pathBase.resolve(directoryScores.resolve(fileHighscores));

//		pathBase + directoryBackup
		Path backupDirectory = pathBase.resolve(directoryBackup);

//		pathBase + (directoryBackup + fileHighscores)
		Path backupFile = pathBase.resolve(directoryBackup.resolve(fileHighscores));

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