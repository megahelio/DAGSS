package CodigoInyeccionCerradoExpansion.DependencyInyectionExampleServices;

public class PrintService {

    private FTPTransportService transportService;
    private PDFFormatService formatService;
    /**
     * @param transportService
     * @param formatService
     */
    public PrintService(PDFFormatService formatService, FTPTransportService transportService) {
        this.transportService = transportService;
        this.formatService = formatService;
    }
    /**
     * Prints your @format_document and the @using_protocol to share it
     */
    public void print(){
        System.out.println("Sending document using: "+ transportService.getService());
        System.out.println("Printing "+formatService.getService() +" format");
    }
}
