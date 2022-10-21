package CodigoInyeccionAbiertoExpansion.DependencyInyectionExampleServices;

/* Queda cerrado para modificación y abierto para expansión con puto de expansión
en las interfaces de @TransportService y @FormatService  */
public class PrintService {

    private TransportServiceInterface transportService;
    private FormatServiceInterface formatService;

    /**
     * @param transportService
     * @param formatService
     */
    public PrintService(FormatServiceInterface formatService, TransportServiceInterface transportService) {
        this.transportService = transportService;
        this.formatService = formatService;
    }

    /**
     * Prints your @format_document and the @using_protocol to share it
     */
    public void print() {
        System.out.println("Sending document using: " + transportService.getService());
        System.out.println("Printing " + formatService.getService() + " format");
    }
}
