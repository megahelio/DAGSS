package ProgramObjects;

public class Programa implements Runnable {

    private String nombre;

    private int duracionMillis;

    private Boolean isDone;

    /**
     * @param nombre
     * @param duracionMillis
     */
    public Programa(String nombre, int duracionMillis) {
        this.nombre = nombre;
        this.duracionMillis = duracionMillis;
        this.isDone = false;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the duracionMillis
     */
    public int getDuracionMillis() {
        return duracionMillis;
    }

    /**
     * @param duracionMillis the duracionMillis to set
     */
    public void setDuracionMillis(int duracionMillis) {
        this.duracionMillis = duracionMillis;
    }

    public void run() {
        try {
            System.out.println("[INICIO] " + this.nombre + " [DURACION: " + this.duracionMillis + "]");
            Thread.sleep(this.duracionMillis);
            System.out.println("[FIN] " + this.nombre);
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