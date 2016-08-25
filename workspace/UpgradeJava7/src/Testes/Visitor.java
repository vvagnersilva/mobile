package Testes;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class Finder extends SimpleFileVisitor<Path> {

	private final PathMatcher matcher;

	private static int numMatches = 0;

	Finder() {
		matcher = FileSystems.getDefault().getPathMatcher("glob:*java");
	}

	void find(Path file) {
		Path Name = file.getFileName();

		if (Name != null && matcher.matches(Name)) {

			numMatches++;
		}
	}

	void report() {

		System.out.println("Matched: " + numMatches);
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

		find(file);

		return FileVisitResult.CONTINUE;
	}
}

public class Visitor {

	public static void main(String[] args) throws IOException {

		Finder finder = new Finder();

		Files.walkFileTree(Paths.get("E:\\Project"), finder);

		finder.report();
	}
}

