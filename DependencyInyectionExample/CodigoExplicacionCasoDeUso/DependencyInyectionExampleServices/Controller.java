package CodigoExplicacionCasoDeUso.DependencyInyectionExampleServices;

public class Controller {
    public static void main(String[] args) {

            ClosedPrintService myPrintService = new ClosedPrintService();

            myPrintService.print();
    }
    
}
