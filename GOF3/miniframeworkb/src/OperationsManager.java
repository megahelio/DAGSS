import java.util.ArrayList;
import java.util.List;

import ds.miniframework.AbstractOperation;
import operaciones.DivOperacion;
import operaciones.SqrtOperacion;
import operaciones.SumOperacion;

class OperationsManager {

    public static List<AbstractOperation> getOperations() {
        List<AbstractOperation> operaciones = new ArrayList<>();
        operaciones.add(new SumOperacion());
        operaciones.add(new DivOperacion());
        if (LicenseManager.checkIsFullVersion()) {
            operaciones.add(new SqrtOperacion());
        }
        return operaciones;
    }
}