package Program;

public class Program implements Runnable {

    private String name;

    private int timeMillis;

    private Boolean isDone;

    /**
     * @param name
     * @param timeMillis
     */
    public Program(String name, int timeMillis) {
        this.name = name;
        this.timeMillis = timeMillis;
        this.isDone = false;
    }

    /**
     * @return the nombre
     */
    public String getName() {
        return name;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setName(String nombre) {
        this.name = nombre;
    }

    /**
     * @return the duracionMillis
     */
    public int getTimeMillis() {
        return timeMillis;
    }

    /**
     * @param duracionMillis the duracionMillis to set
     */
    public void setTimeMillis(int duracionMillis) {
        this.timeMillis = duracionMillis;
    }

    public void run() {
        try {
            System.out.println("[INICIO] " + this.name + " [DURACION: " + this.timeMillis + "]");
            Thread.sleep(this.timeMillis);
            System.out.println("[FIN] " + this.name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.isDone = true;
        }
    }

    /**
     * @return the isDone
     */
    public Boolean getIsDone() {
        return isDone;
    }

    /**
     * @param isDone the isDone to set
     */
    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

}