package converterapp;

import java.io.PrintStream;
import java.util.Scanner;

import Formatters.FormatterToXML;
import IO.Input.GetterInputFileConsoleInput;
import IO.Output.ShowOutputByConsole;

public class ConverterApp {

	public static void main(String args[]) {
		GetterInputInterface getterInputFile = new GetterInputFileConsoleInput();
		GetterOutputInterface getterOutputFile = new ShowOutputByConsole();

		Scanner scanner = getterInputFile.getInputFile();
		PrintStream out = getterOutputFile.getOutput();

		FormatterInterface formatter = new FormatterToXML();
		formatter.format(scanner, out);
		out.close();
	}

}
