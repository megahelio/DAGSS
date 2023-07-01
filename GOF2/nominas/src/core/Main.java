package core;

import java.util.List;

import handlers.CalculadoraNomina;

public class Main {
    private static final String FICHERO_BD = "empleados.txt";

    public static void main(String[] args) {
        List<Empleado> todosEmpleados = LectorFichero.leerArchivo(FICHERO_BD);
        // todosEmpleados.forEach((t -> System.out.println(t.toString())));

        CalculadoraNomina calculadora = new CalculadoraNomina();
        todosEmpleados.forEach((t -> calculadora.calcularNomina(t)));

        todosEmpleados.forEach(
                (t -> System.out.println(t.getNombre() + "  " + t.getNomina())));

    }
}
