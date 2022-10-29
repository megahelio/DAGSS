public class Program {

    public static void main(String[] args) {
        Library library = new Library();
        BookReaderTABFormat.readFile(args[0], library);
        ExporterXML.export(args[1], library);

    }
}
