package converterapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TextManager {
	
	public static void transform(File input, File output) {
		Scanner scanner = null;
		PrintStream out = null;
		try {
			scanner = new Scanner(input);

		} catch (FileNotFoundException e) {
			System.err.println("the file " + input.getAbsolutePath()
					+ " does not exists: " + e.getMessage());
			System.exit(1);
		}

		try {
			out = new PrintStream(new FileOutputStream(output));
		} catch (FileNotFoundException e1) {
			System.err.println("the file " + input.getAbsolutePath()
					+ " does cannot be created: " + e1.getMessage());
			System.exit(1);
		}

		out.println("<products>");
		while (scanner.hasNextLine()) {			
			String xmlString = toXML(scanner.nextLine());
			out.println(xmlString);
		}
		out.println("</products>");

		out.close();
	}

	private static String toXML(String line) {
		String[] tokens = line.split("\t");
		if (tokens.length != 2) {
			throw new IllegalArgumentException(
					"the line does not contain 3 tokens");
		}

		return "<product>\n\t<name>" + tokens[0] + "</name>\n\t<price>"
				+ tokens[1] + "</price>\n</product>";

	}

}
