package CodigoInyeccionCerradoExpansion.DependencyInyectionExampleServices;

public class Controller {
    public static void main(String[] args) {

            PrintService myPrintService = new PrintService(new PDFFormatService(),new FTPTransportService());

            myPrintService.print();
    }
    
}
