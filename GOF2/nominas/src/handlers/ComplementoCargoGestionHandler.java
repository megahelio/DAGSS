package handlers;

import core.Empleado;

public class ComplementoCargoGestionHandler extends AbstractNominaHandler {
    @Override
    public void calcularNomina(Empleado empleado) {
        int complementoCargoGestion = empleado.isCargoGestion() ? 15 : 0;

        empleado.setNomina(empleado.getNomina()+complementoCargoGestion);
        ejecutarSiguiente(empleado);
    }
}