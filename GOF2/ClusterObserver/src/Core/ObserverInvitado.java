package Core;

import Config.ThreadRunner;
import Observer.ObserverInterface;
import ProgramObjects.Programa;

public class ObserverInvitado implements ObserverInterface {
    private ThreadRunner threadRunner;

    public ObserverInvitado() {
        this.threadRunner = ThreadRunner.getInstance();
        this.threadRunner.addObserver(this);
    }

    @Override
    public void programaCreado(int totalProgramas, Programa programa) {
         System.out.println("Notificacion ObserverInvitado: Creado " + programa.getNombre() + " actualmente "
                 + totalProgramas
                 + " en ejecucion.");
    }

    @Override
    public void programaDestruido(int totalProgramas, Programa programa) {
         System.out.println("Notificacion ObserverInvitado: Destruido " + programa.getNombre() + " actualmente "
                 + totalProgramas + " en ejecucion.");
    }

}
