package handlers;
import core.Empleado;

public class CalculadoraNomina {
    private NominaHandler inicioHandler;

    public CalculadoraNomina() {
        // Configurar la cadena de responsabilidades
        inicioHandler = new SalarioBaseHandler();
        NominaHandler handlerAntiguedad = new ComplementosAntiguedadHandler();
        NominaHandler handlerCargoGestion = new ComplementoCargoGestionHandler();

        inicioHandler.setSiguiente(handlerAntiguedad);
        handlerAntiguedad.setSiguiente(handlerCargoGestion);
    }

    public void calcularNomina(Empleado empleado) {
        inicioHandler.calcularNomina(empleado);
    }
}
