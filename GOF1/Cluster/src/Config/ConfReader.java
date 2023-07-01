package Config;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Program.Node;
import Program.Program;

public class ConfReader {
    Program programaA;
    Program programaB;
    Program programaC;
    Program programaD;
    Program programaE;
    Program programaF;

    /**
     * 
     */
    public ConfReader() {
        this.programaA = new Program("Programa A", 1000);
        this.programaB = new Program("Programa B", 5000);
        this.programaC = new Program("Programa C", 10000);
        this.programaD = new Program("Programa D", 1000);
        this.programaE = new Program("Programa E", 1000);
        this.programaF = new Program("Programa F", 2000);
    }

    public List<Node> getTree(){
        List<Node> arbol = new LinkedList<>();
        Node nodoA = new Node(null, null, programaA);
        Node nodoB = new Node(null, null, programaB);
        Node nodoC = new Node(null, null, programaC);
        Node nodoD = new Node(null, null, programaD);
        Node nodoE = new Node(null, null, programaE);
        Node nodoF = new Node(null, null, programaF);

        List<Node> nodes = new ArrayList<>();
        
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
