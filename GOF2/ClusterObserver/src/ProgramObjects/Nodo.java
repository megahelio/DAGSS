package ProgramObjects;
import java.util.List;

public class Nodo {
    private List<Nodo> previousNodes;
    private List<Nodo> nextNodes;
    private Programa content;

    /**
     * @param previousNodes
     * @param nextNodes
     * @param content
     */
    public Nodo(List<Nodo> previousNodes, List<Nodo> nextNodes, Programa content) {
        this.previousNodes = previousNodes;
        this.nextNodes = nextNodes;
        this.content = content;
    }

    /**
     * @return the previousNodes
     */
    public List<Nodo> getPreviousNodes() {
        return previousNodes;
    }

    /**
     * @param previousNodes the previousNodes to set
     */
    public void setPreviousNodes(List<Nodo> previousNodes) {
        this.previousNodes = previousNodes;
    }

    /**
     * @return the nextNodes
     */
    public List<Nodo> getNextNodes() {
        return nextNodes;
    }

    /**
     * @param nextNodes the nextNodes to set
     */
    public void setNextNodes(List<Nodo> nextNodes) {
        this.nextNodes = nextNodes;
    }

    /**
     * @return the content
     */
    public Programa getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(Programa content) {
        this.content = content;
    }

}
