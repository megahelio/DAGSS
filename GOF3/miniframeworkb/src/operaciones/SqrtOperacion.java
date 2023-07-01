package operaciones;

import java.util.List;

import ds.miniframework.AbstractOperation;
import ds.miniframework.logger.LogLevelEnum;
import ds.miniframework.logger.Logger;

public class SqrtOperacion extends AbstractOperation {

    final private Logger logger = Logger.getInstance();

    final private String ERROR_NUMERO_DE_PARAMETROS = "Se requiere un parametro para hacer la raiz cuadrada";
    final private String ERROR_PARAMETRO_NO_NUMÉRICO = "El Radical no es numérico.";

    public SqrtOperacion() {
        super("Raiz Cuadrada", List.of("Radical"));
    }

    @Override
    public String execute() {
        this.setProgressAndShow(0);
        if (getParameters().size() != 1) {
            this.setProgressAndShow(100);
            logger.log(LogLevelEnum.ERROR, ERROR_NUMERO_DE_PARAMETROS);
            return ERROR_NUMERO_DE_PARAMETROS;
        }
        this.setProgressAndShow(30);
        double res = 0;
        this.setProgressAndShow(40);
        try {
            res = Math.sqrt(Integer.parseInt(this.getParameters().get("Radical")));
        } catch (NumberFormatException e) {
            this.setProgressAndShow(100);
            logger.log(LogLevelEnum.ERROR, ERROR_PARAMETRO_NO_NUMÉRICO);
            return ERROR_PARAMETRO_NO_NUMÉRICO;
        }

        this.setProgressAndShow(100);
        logger.log(LogLevelEnum.INFO, "Sqrt finalizada: " + res);
        return "Resultado de la raíz: " + res;
    }
}
