package handlers;

import core.Empleado;

public class ComplementosAntiguedadHandler extends AbstractNominaHandler {
    @Override
    public void calcularNomina(Empleado empleado) {
        int anosTrabajados = empleado.getAnosTrabajados();
        int complementoAntiguedad = 0;

        complementoAntiguedad += (anosTrabajados / 6) * 50; // Sexenios
        complementoAntiguedad += (anosTrabajados / 5) * 20; // Quinquenios
        complementoAntiguedad += (anosTrabajados / 3) * 10; // Trienios

        empleado.setNomina(empleado.getNomina() + complementoAntiguedad);
        ejecutarSiguiente(empleado);
    }
}
