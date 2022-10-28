package IO.Output;

import java.io.PrintStream;
import converterapp.GetterOutputInterface;

public class ShowOutputByConsole implements GetterOutputInterface {
    
    public PrintStream getOutput() {
        System.out.println("Output will be shown by console: ");
        PrintStream toret = new PrintStream(System.out);
        return toret;
    }

}
