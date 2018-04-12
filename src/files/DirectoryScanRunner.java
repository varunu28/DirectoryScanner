package files;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class DirectoryScanRunner {

	public static void main(String[] args) throws IOException {
		
		Path currentDir = Paths.get(".");
		int numOfLevels = 4;
		
		Predicate<? super Path> onlyJavaFiles = 
				path -> String.valueOf(path).endsWith(".java");
				
		// BiPredicate for filtering Java Files
		BiPredicate<Path, BasicFileAttributes> javaMatcher =
				(path, attributes) -> String.valueOf(path).endsWith(".java");
				
		// BiPredicate for filtering for directories
		BiPredicate<Path, BasicFileAttributes> directoryMatcher =
				(path, attributes) -> attributes.isDirectory();
		
		// Creating a directory scanner object
		DirectoryScanner directoryScanner = new DirectoryScanner();
		
		// Printing all the files in the directory
		directoryScanner.listAllDirs(currentDir);
		
		// Printing the files by scanning the directory for a given level
		directoryScanner.listAllDirsWithGivenLevel(currentDir, numOfLevels);
		
		// Printing the files based on a predicate
		directoryScanner.filterFilesUsingPredicate(currentDir, numOfLevels, onlyJavaFiles);
		
		// // Printing the files based on a BiPredicate
		directoryScanner.filterFilesUsingBiPredicate(currentDir, numOfLevels, directoryMatcher);
	}
}
