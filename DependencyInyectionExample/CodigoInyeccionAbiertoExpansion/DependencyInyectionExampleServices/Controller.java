package CodigoInyeccionAbiertoExpansion.DependencyInyectionExampleServices;

public class Controller {
    public static void main(String[] args) {

            PrintService myPrintService = new PrintService(new JPGFormatService(),new FTPTransportService());

            myPrintService.print();
    }
    
}
