import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Expansible aplicando patron builder
public class BookReaderTABFormat implements ReaderInterface {

    public List<Book> readFile(String path) {

        File file = new File(path);
        List books = new ArrayList();
        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);

            String line;
            String[] splitedLine;
            while ((line = br.readLine()) != null) {
                splitedLine = line.split("\t");
                books.add(new Book(new Author(splitedLine[1]), splitedLine[2].split("-")[1], splitedLine[0]));
            }

        } catch (IOException e) {
            System.err.println("Se Tensó");
            e.printStackTrace();
        }
        return books;
    }

}
