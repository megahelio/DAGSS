package operaciones;

import java.util.List;

import ds.miniframework.AbstractOperation;

public class DivOperacion extends AbstractOperation {
    public DivOperacion() {
        super("División", List.of("Dividendo", "Divisor"));
    }

    @Override
    public String execute() {
        this.setProgressAndShow(0);
        if (getParameters().size() != 2) {
            return "Error: Se requieren dos parámetros para dividir.";
        }
        this.setProgressAndShow(30);

        float cociente = 0;
        try {
            cociente = Float.parseFloat(getParameters().get("Dividendo"))
                    / Float.parseFloat(getParameters().get("Divisor"));
        } catch (NumberFormatException e) {
            this.setProgressAndShow(100);
            return "Error: Uno o más parámetros no son numéricos.";
        }
        this.setProgressAndShow(60);

        this.setProgressAndShow(100);

        return "Resultado de la division: " + cociente;
    }
}
