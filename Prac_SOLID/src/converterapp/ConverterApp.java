package converterapp;

import java.io.PrintStream;
import java.util.Scanner;

public class ConverterApp {

	public static void main(String args[]) {
		GetterInputFileInterface getterInputFile = new GetterInputFileConsoleInput();
		GetterOutputInterface getterOutputFile = new GetterOutputConsoleInput();

		Scanner scanner = getterInputFile.getInputFile();
		PrintStream out = getterOutputFile.getOutput();

		FormatterInterface formatter = new FormatterToXML();

		formatter.format(scanner, out);

		out.close();
	}

}
