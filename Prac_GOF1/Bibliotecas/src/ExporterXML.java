import java.io.FileWriter;
import java.io.PrintWriter;

public class ExporterXML {

    public static void export(String path, Library library) {
        FileWriter file = null;
        PrintWriter pw = null;

        try {
            file = new FileWriter(path);
            pw = new PrintWriter(file);

            pw.println("<libros>");
            for (int i = 0; i < library.librarySize(); i++) {
                pw.println("<libro>");
                pw.println("<titulo>" + library.getBook(i).getTitulo() + "</titulo>");
                pw.println("<autor>" + library.getBook(i).getAuthor().getName() + "</autor>");
                pw.println("<isbn>" + library.getBook(i).getIsbn() + "</isbn>");
                pw.println("</libro>");
            }
            pw.println("</libros>");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (null != file)
                    file.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
}