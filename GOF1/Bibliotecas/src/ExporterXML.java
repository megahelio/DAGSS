import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;


//Expansible aplicando patron builder
public class ExporterXML implements WriterInterface{

    public void export(String path, List<Book> books) {
        FileWriter file = null;
        PrintWriter pw = null;

        try {
            file = new FileWriter(path,true);
            pw = new PrintWriter(file);

            pw.println("<libros>");
            for (Book book : books) {
                
                pw.println("<libro>");
                pw.println("<titulo>" + book.getTitulo() + "</titulo>");
                pw.println("<autor>" + book.getAuthor().getName() + "</autor>");
                pw.println("<isbn>" + book.getIsbn() + "</isbn>");
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