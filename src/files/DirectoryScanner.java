package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class DirectoryScanner {

	// Printing all the files in the directory path
	public void listAllDirs(Path directoryPath) throws IOException {
		Files.
			list(directoryPath).
			forEach(System.out::println);
	}
	
	// Printing the files by scanning the directory path for a given level
	public void listAllDirsWithGivenLevel(Path directoryPath, int numOfLevels) throws IOException {
		Files.
			walk(directoryPath, numOfLevels).
			forEach(System.out::println);
	}
	
	// Printing the files by scanning the directory path for a given level based on a predicate
	public void filterFilesUsingPredicate(Path directoryPath, int numOfLevels, Predicate<? super Path> predicate) 
			throws IOException {
		Files.
			walk(directoryPath, numOfLevels).
			filter(predicate).
			forEach(System.out::println);
	}
	
	// Printing the files by scanning the directory path for a given level based on a bipredicate
	public void filterFilesUsingBiPredicate(Path directoryPath, int numOfLevels, 
			BiPredicate<Path, BasicFileAttributes> biPredicate) throws IOException {
		Files.
			find(directoryPath, numOfLevels, biPredicate).
			forEach(System.out::println);
	}
}
