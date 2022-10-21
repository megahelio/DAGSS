package CodigoCerradoModificacionYExtension.DependencyInyectionExampleServices;

public class PrintService {

    private FTPTransportService transportService;
    private PDFFormatService formatService;
    /**
     * @param transportService
     * @param formatService
     */
    public PrintService() {
        this.transportService = new FTPTransportService();
        this.formatService = new PDFFormatService();
    }
    /**
     * Prints your PDF document using FTP protocol to share it
     */
    public void print(){
        System.out.println("Sending document using: "+ transportService.getService());
        System.out.println("Printing "+formatService.getService() +" format");
    }
}
