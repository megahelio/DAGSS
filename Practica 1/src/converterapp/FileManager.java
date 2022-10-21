package converterapp;

import java.io.File;
import java.util.Scanner;

public class FileManager {
	
	public static File getInputFile() {
		System.out.println("input filename: ");
		return getFile();
	}

	public static File getOutputFile() {
		System.out.println("output filename: ");
		return getFile();
	}

	private static File getFile() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();

		return new File(name);
	}

}
