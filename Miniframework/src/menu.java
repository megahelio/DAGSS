import java.util.ArrayList;
import java.util.Scanner;

import operations.OperationGeneric;

public class menu {

    private ArrayList<OperationGeneric> operationList;

    public menu() {
        // Que implemetaciones tengo? relleno la lista de operaciones llamando a
        // operation_XXXX.getOperationName()
    }

    protected String actuatorMenu() {
        String opStr = "";
        try (Scanner sc = new Scanner(System.in)) {
            Boolean invalidInput = true;

            while (invalidInput) {

                // Listar opciones
                System.out.println("Select an option and press enter (-1 to exit): ");
                for (int i = 0; i < operationList.size(); i++) {
                    System.out.println("[" + i + "] " + operationList.get(i).getOperationName());
                }

                // Validar entrada
                opStr = sc.nextLine();
                try {
                    if (-2 < Integer.parseInt(opStr) && Integer.parseInt(opStr) < operationList.size())
                        invalidInput = false;
                } catch (NumberFormatException e) {
                    System.out.println("Select a NUMBER");
                }

            }
            // Me piden salir?
            if (opStr == "-1") {
                return "Quit Selected";
            }
        }
        return operationList.get(Integer.parseInt(opStr)).operate();
        // Llamar a la clase seleccionada de operation list
    }
}
