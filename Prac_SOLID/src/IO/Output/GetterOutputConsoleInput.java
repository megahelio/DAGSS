package IO.Output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import converterapp.GetterOutputInterface;


//OCP Class
public class GetterOutputConsoleInput implements GetterOutputInterface {

    public PrintStream getOutput() {
        System.out.println("output filename: ");
        File file = getFile();
        PrintStream toret = null;
        try {
            toret = new PrintStream(new FileOutputStream(file));
        } catch (FileNotFoundException e1) {
            System.err.println("the file " + file.getAbsolutePath()
                    + " does cannot be created: " + e1.getMessage());
            System.exit(1);
        }
        return toret;
    }

    private File getFile() {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        return new File(name);
    }

}
