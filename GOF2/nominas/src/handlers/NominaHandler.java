package handlers;

import core.Empleado;

public interface NominaHandler {
    public void setSiguiente(NominaHandler handlerAntiguedad) ;
    public void calcularNomina(Empleado empleado) ;
}
