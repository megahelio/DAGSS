package ds.miniframework;

import java.util.List;
import java.util.Scanner;

import ds.miniframework.logger.LogLevelEnum;
import ds.miniframework.logger.Logger;

public class ConsoleFramework {
    final private List<AbstractOperation> operations;
    final private Scanner scanner;
    final private Logger logger;

    /**
     * @param operations
     */
    public ConsoleFramework(List<AbstractOperation> operations) {
        this.operations = operations;
        this.logger = Logger.getInstance();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        int seleccion = 0;
        String entrada = "";
        do {
            seleccion = seleccionarOperacion();
            logger.log(LogLevelEnum.DEBUG, "Seleccionó: " + seleccion);
            if (seleccion == 0) {
                logger.log(LogLevelEnum.DEBUG, "Solicitó salir del programa");
                break;
            }
            // Adquisicion parámetros
            logger.log(LogLevelEnum.DEBUG, "Inició adquisición parámetros");
            for (String nombreParametro : this.operations.get(seleccion - 1).getParameters().keySet()) {
                logger.log(LogLevelEnum.DEBUG, "Solicita parametro: " + nombreParametro);
                System.out.print(nombreParametro + ": ");
                entrada = this.scanner.nextLine();
                this.operations.get(seleccion - 1).getParameters().put(nombreParametro, entrada);
                logger.log(LogLevelEnum.DEBUG, "Parametro: " + nombreParametro + " = " + entrada);
            }

            // Ejecución
            System.out.println(this.operations.get(seleccion - 1).execute());

        } while (seleccion != 0);
        // Al salir cerramos flujos abiertos
        this.close();
    }

    private Integer seleccionarOperacion() {
        Integer respuesta = 0;
        Boolean seguir = true;
        do {
            try {
                this.mostrarOperaciones();
                System.out.print("Usuario: ");
                respuesta = Integer.parseInt(scanner.nextLine());
                seguir = respuesta < 0 || respuesta > this.operations.size();
            } catch (NumberFormatException e) {
                logger.log(LogLevelEnum.ERROR, "Respuesta no numerica");
                System.out.println("Respuesta no numerica");
            }
        } while (seguir);
        System.out.println("Seleccionada operacion: " + respuesta);

        return respuesta;
    }

    private void mostrarOperaciones() {
        int i = 0;
        System.out.println("-------------------------------------");
        System.out.println("[0] Cerrar");
        for (AbstractOperation unaOperacion : this.operations) {
            System.out.println("[" + ++i + "] " + unaOperacion.getName());
        }
        System.out.println("-------------------------------------");
    }

    private void close() {
        this.scanner.close();
        this.logger.close();
        
    }
}
