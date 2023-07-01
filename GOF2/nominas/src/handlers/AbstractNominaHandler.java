package handlers;
import core.Empleado;

public abstract class AbstractNominaHandler implements NominaHandler {
    private NominaHandler siguiente;

    @Override
    public void setSiguiente(NominaHandler siguiente) {
        this.siguiente = siguiente;
    }

    protected void ejecutarSiguiente(Empleado empleado) {
        if (siguiente != null) {
            siguiente.calcularNomina(empleado);
        }
    }
}

