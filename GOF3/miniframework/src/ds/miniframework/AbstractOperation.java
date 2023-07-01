package ds.miniframework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractOperation {
    private String name;
    private Map<String, String> parameters;
    private int progress;

    /**
     * @param progress the progress to set
     */
    public void setProgressAndShow(int progress) {
        this.progress = progress;
        System.out.println(this.progress + "%");
    }

    public AbstractOperation(String name, List<String> parameters) {
        this.name = name;
        this.parameters = new HashMap<>();
        for (String parameter : parameters) {
            this.parameters.put(parameter, "");
        }
        this.progress = 0;
    }

    public abstract String execute();

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the parametros
     */
    public Map<String, String> getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parametros to set
     */
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

}
