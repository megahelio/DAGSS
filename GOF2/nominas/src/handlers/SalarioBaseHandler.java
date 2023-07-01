package handlers;

import core.Empleado;

public class SalarioBaseHandler extends AbstractNominaHandler {
    @Override
    public void calcularNomina(Empleado empleado) {
        String escala = empleado.getEscala();
        int salarioBase;

        if (escala.equals("C")) {
            salarioBase = 900;
        } else if (escala.equals("B")) {
            salarioBase = 1100;
        } else if (escala.equals("A")) {
            salarioBase = 1300;
        } else {
            salarioBase = 0; // Escala no válida
        }

        empleado.setNomina(empleado.getNomina()+salarioBase);
        ejecutarSiguiente(empleado);
    }
}
