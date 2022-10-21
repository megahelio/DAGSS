package CodigoExplicacionCasoDeUso.DependencyInyectionExampleServices;

public class ClosedPrintService {
    /**
     * Prints your PDF document using FTP protocol to share it
     */
    public void print(){
        System.out.println("Sending document using: FTP");
        System.out.println("Printing PDF format");
    }
}
