package converterapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConverterApp {

	public static void main(String args[]) {
		
		FileManager fm = new FileManager();
		TextManager tm = new TextManager();
		
		File input = fm.getInputFile();
		File output = fm.getOutputFile();

		tm.transform(input, output);
	}

}
