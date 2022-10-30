import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Expansible aplicando patron builder
public class BookReaderTABFormat {

    public static void readFile(String path, Library library) {

        File file = new File(path);

        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);

            String line;
            String[] splitedLine;
            while ((line = br.readLine()) != null) {
                splitedLine = line.split("\t");
                library.addBook(new Book(new Author(splitedLine[1]), splitedLine[2].split("-")[1], splitedLine[0]));
            }

        } catch (IOException e) {
            System.err.println("Se Tensó");
            e.printStackTrace();
        }
    }

}
