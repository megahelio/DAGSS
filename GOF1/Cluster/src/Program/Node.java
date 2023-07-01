package Program;
import java.util.List;

public class Node {
    private List<Node> previousNodes;
    private List<Node> nextNodes;
    private Program content;

    /**
     * @param previousNodes
     * @param nextNodes
     * @param content
     */
    public Node(List<Node> previousNodes, List<Node> nextNodes, Program content) {
        this.previousNodes = previousNodes;
        this.nextNodes = nextNodes;
        this.content = content;
    }

    /**
     * @return the previousNodes
     */
    public List<Node> getPreviousNodes() {
        return previousNodes;
    }

    /**
     * @param previousNodes the previousNodes to set
     */
    public void setPreviousNodes(List<Node> previousNodes) {
        this.previousNodes = previousNodes;
    }

    /**
     * @return the nextNodes
     */
    public List<Node> getNextNodes() {
        return nextNodes;
    }

    /**
     * @param nextNodes the nextNodes to set
     */
    public void setNextNodes(List<Node> nextNodes) {
        this.nextNodes = nextNodes;
    }

    /**
     * @return the content
     */
    public Program getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(Program content) {
        this.content = content;
    }

}
