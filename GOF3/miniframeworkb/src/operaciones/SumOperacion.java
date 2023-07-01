package operaciones;

import java.util.List;

import ds.miniframework.AbstractOperation;

public class SumOperacion extends AbstractOperation {
    public SumOperacion() {
        super("Sumar", List.of("Sumando A", "Sumando B"));
    }

    @Override
    public String execute() {
        this.setProgressAndShow(0);
        if (getParameters().size() != 2) {
            this.setProgressAndShow(100);
            return "Error: Se requieren dos parámetros para sumar.";
        }
        this.setProgressAndShow(30);

        int sum = 0;
        for (String param : getParameters().values()) {
            try {
                sum += Integer.parseInt(param);
            } catch (NumberFormatException e) {
                this.setProgressAndShow(100);
                return "Error: Uno o más parámetros no son numéricos.";
            }
            this.setProgressAndShow(60);
        }
        this.setProgressAndShow(100);

        return "Resultado de la suma: " + sum;
    }
}
