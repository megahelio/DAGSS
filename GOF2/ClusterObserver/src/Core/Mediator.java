package Core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Config.ConfReader;
import Config.ThreadRunner;
import Observer.ObserverInterface;
import ProgramObjects.Nodo;
import ProgramObjects.Programa;

public class Mediator implements ObserverInterface {
    private ThreadRunner threadRunner;
    private List<Nodo> arbol;
    private List<Nodo> nodosNoIterados;
    private List<Nodo> nodosTerminales;

    /**
     * @param confReader
     */
    public Mediator(ConfReader confReader) {
        this.threadRunner = ThreadRunner.getInstance();
        this.threadRunner.addObserver(this);

        this.arbol = new LinkedList<>(confReader.getArbol());
        this.nodosNoIterados = new LinkedList<>(arbol);
        // Creo una coleccion con los últimos nodos en ejecutar para determinar cuando
        // terminé de ejecutar todos los programas
        this.nodosTerminales = new ArrayList<>();
        for (Nodo nodo : arbol) {
            if (nodo.getNextNodes() == null) {
                this.nodosTerminales.add(nodo);
            }
        }
    }

    public void goCluster() {
        Boolean isProgramExecutable;
        Iterator<Nodo> iterator;
        do {
            iterator = this.nodosNoIterados.iterator();
            while (iterator.hasNext()) {
                Nodo aNode = iterator.next();
                isProgramExecutable = true;
                // Miro si el nodo tiene prerequisitos
                if (aNode.getPreviousNodes() != null) {
                    // Miro si se cumplen los prerrequisitos
                    for (Nodo aPreviousNodo : aNode.getPreviousNodes()) {
                        if (!aPreviousNodo.getContent().getIsDone()) {
                            // si no se cumplen los prerrequisitos no es ejecutable
                            isProgramExecutable = false;
                        }
                    }
                }
                // Si es ejecutable se ejecuta
                if (isProgramExecutable) {
                    this.threadRunner.execute(aNode.getContent());
                    iterator.remove();
                }
                // System.out.println(
                // "\t Programa: " + aNode.getContent().getNombre() + " Executable:" +
                // isProgramExecutable);
            }

        } while (!this.nodosNoIterados.isEmpty());
        this.threadRunner.stop();
        try {
            this.threadRunner.getSupervisor().join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void programaCreado(int totalProgramas, Programa programa) {
        System.out.println("Notificacion Mediator: Creado " + programa.getNombre() + " actualmente " + totalProgramas
                + " en ejecucion.");
    }

    @Override
    public void programaDestruido(int totalProgramas, Programa programa) {
        System.out.println("Notificacion Mediator: Destruido " + programa.getNombre() + " actualmente " + totalProgramas
                + " en ejecucion.");
        for (Nodo nodo : arbol) {
            if (nodo.getContent().equals(programa)) {
                nodo.getContent().setIsDone(true);
                break;
            }
        }
    }

}
