package Config;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ProgramObjects.Nodo;
import ProgramObjects.Programa;

public class ConfReader {
    Programa programaA;
    Programa programaB;
    Programa programaC;
    Programa programaD;
    Programa programaE;
    Programa programaF;

    /**
     * 
     */
    public ConfReader() {
        this.programaA = new Programa("Programa A", 1000);
        this.programaB = new Programa("Programa B", 5000);
        this.programaC = new Programa("Programa C", 4000);
        this.programaD = new Programa("Programa D", 1000);
        this.programaE = new Programa("Programa E", 1000);
        this.programaF = new Programa("Programa F", 2000);
    }

    public List<Nodo> getArbol(){
        List<Nodo> arbol = new LinkedList<>();
        Nodo nodoA = new Nodo(null, null, programaA);
        Nodo nodoB = new Nodo(null, null, programaB);
        Nodo nodoC = new Nodo(null, null, programaC);
        Nodo nodoD = new Nodo(null, null, programaD);
        Nodo nodoE = new Nodo(null, null, programaE);
        Nodo nodoF = new Nodo(null, null, programaF);

        List<Nodo> nodes = new ArrayList<>();
        
        nodes.add(nodoB);
        nodes.add(nodoC);
        nodes.add(nodoD);
        nodoA.setNextNodes(new ArrayList<>(nodes));
        nodes.clear();

        nodes.add(nodoA);
        nodoB.setPreviousNodes(new ArrayList<>(nodes));
        nodoC.setPreviousNodes(new ArrayList<>(nodes));
        nodoD.setPreviousNodes(new ArrayList<>(nodes));
        nodes.clear();

        nodes.add(nodoE);
        nodoB.setNextNodes(new ArrayList<>(nodes));
        nodoC.setNextNodes(new ArrayList<>(nodes));
        nodoF.setNextNodes(new ArrayList<>(nodes));
        nodes.clear();

        nodes.add(nodoF);
        nodes.add(nodoB);
        nodes.add(nodoC);
        nodoE.setPreviousNodes(new ArrayList<>(nodes));
        nodes.clear();
    
        nodes.add(nodoD);
        nodoF.setPreviousNodes(new ArrayList<>(nodes));
        nodes.clear();

        nodes.add(nodoF);
        nodoD.setNextNodes(new ArrayList<>(nodes));
        
        arbol.add(nodoA);
        arbol.add(nodoB);
        arbol.add(nodoC);
        arbol.add(nodoD);
        arbol.add(nodoE);
        arbol.add(nodoF);

        return arbol;
    }
}
