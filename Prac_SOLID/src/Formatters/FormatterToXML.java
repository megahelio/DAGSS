package Formatters;

import java.io.PrintStream;
import java.util.Scanner;

import converterapp.FormatterInterface;

public class FormatterToXML implements FormatterInterface {

    @Override
    public void format(Scanner scanner, PrintStream out) {
        out.println("<products>");
        while (scanner.hasNextLine()) {
            out.println(formatLine(scanner.nextLine()));
        }
        out.println("</products>");

    }

    private String formatLine(String line) {
        String[] tokens = line.split("\t");
        if (tokens.length != 2) {
            throw new IllegalArgumentException(
                    "the line does not contain 3 tokens");
        }

        return "<product>\n\t<name>" + tokens[0] + "</name>\n\t<price>"
                + tokens[1] + "</price>\n</product>";
    }
}
