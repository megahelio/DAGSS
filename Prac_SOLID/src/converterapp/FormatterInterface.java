package converterapp;

import java.io.PrintStream;
import java.util.Scanner;

//extension point
public interface FormatterInterface {

    public void format(Scanner scanner, PrintStream out);
    
}
