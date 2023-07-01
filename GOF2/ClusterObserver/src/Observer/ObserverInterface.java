package Observer;

import ProgramObjects.Programa;

public interface ObserverInterface {

    void programaCreado(int totalProgramas, Programa programa);

    void programaDestruido(int totalProgramas, Programa programa);
}
