package IO.Input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import converterapp.GetterInputInterface;

//OCP Class
public class GetterInputFileConsoleInput implements GetterInputInterface {

    public Scanner getInputFile() {
        System.out.println("input filename: ");
        File file = getFile();
        Scanner toret = null;
        try {
            toret = new Scanner(file);

        } catch (FileNotFoundException e) {
            System.err.println("the file " + file.getAbsolutePath()
                    + " does not exists: " + e.getMessage());
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
