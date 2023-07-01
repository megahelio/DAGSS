package Core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Config.ConfReader;
import Config.ThreadRunner;
import Program.Node;


public class Mediator {
    private ThreadRunner threadRunner;
    private List<Node> tree;
    private List<Node> nodesNoIterated;
    private List<Node> nodesFinal;

    /**
     * @param confReader
     */
    public Mediator(ConfReader confReader) {
        this.threadRunner = ThreadRunner.getInstance();


        this.tree = new LinkedList<>(confReader.getTree());
        this.nodesNoIterated = new LinkedList<>(tree);
        // Creo una coleccion con los últimos nodos en ejecutar para determinar cuando
        // terminé de ejecutar todos los programas
        this.nodesFinal = new ArrayList<>();
        for (Node nodo : tree) {
            if (nodo.getNextNodes() == null) {
                this.nodesFinal.add(nodo);
            }
        }
    }

    public void runCluster() {
        Boolean isProgramExecutable;
        Iterator<Node> iterator;
        do {
            iterator = this.nodesNoIterated.iterator();
            while (iterator.hasNext()) {
                Node aNode = iterator.next();
                isProgramExecutable = true;
                // Miro si el nodo tiene prerequisitos
                if (aNode.getPreviousNodes() != null) {
                    // Miro si se cumplen los prerrequisitos
                    for (Node aPreviousNodo : aNode.getPreviousNodes()) {
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
                //  System.out.println(
                //  "\t Programa: " + aNode.getContent().getName() + " Executable:" +
                //  isProgramExecutable);
            }

        } while (!this.nodesNoIterated.isEmpty());
        this.threadRunner.stop();

    }

}
