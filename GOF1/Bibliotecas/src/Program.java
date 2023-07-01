
import java.util.List;

public class App {

    public static void main(String[] args) {
        Library library = new Library();
        ReaderInterface reader = new BookReaderTABFormat();
        WriterInterface writer = new ExporterXML();
        List<Book> books = reader.readFile(args[0]);

        library.addBooks(books);
        writer.export(args[1], books);

    }
}
