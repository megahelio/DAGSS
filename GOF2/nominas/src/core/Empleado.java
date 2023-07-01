package core;

public class Empleado {
    private String nombre;
    private String escala;
    private int anosTrabajados;
    private boolean cargoGestion;
    private int nomina;

    /**
     * @param nombre
     * @param escala
     * @param anosTrabajados
     * @param cargoGestion
     */
    public Empleado(String nombre, String escala, int anosTrabajados, boolean cargoGestion) {
        this.nombre = nombre;
        this.escala = escala;
        this.anosTrabajados = anosTrabajados;
        this.cargoGestion = cargoGestion;
        this.nomina = 0;
    }

    public Empleado() {
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
     * @return the escala
     */
    public String getEscala() {
        return escala;
    }

    /**
     * @return the nomina
     */
    public int getNomina() {
        return nomina;
    }

    /**
     * @param nomina the nomina to set
     */
    public void setNomina(int nomina) {
        this.nomina = nomina;
    }

    /**
     * @param escala the escala to set
     */
    public void setEscala(String escala) {
        this.escala = escala;
    }

    /**
     * @return the anosTrabajados
     */
    public int getAnosTrabajados() {
        return anosTrabajados;
    }

    /**
     * @param anosTrabajados the anosTrabajados to set
     */
    public void setAnosTrabajados(int anosTrabajados) {
        this.anosTrabajados = anosTrabajados;
    }

    /**
     * @return the cargoGestion
     */
    public boolean isCargoGestion() {
        return cargoGestion;
    }

    /**
     * @param cargoGestion the cargoGestion to set
     */
    public void setCargoGestion(boolean cargoGestion) {
        this.cargoGestion = cargoGestion;
    }

    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + ", escala=" + escala + ", anosTrabajados=" + anosTrabajados
                + ", cargoGestion=" + cargoGestion + ", nomina=" + nomina + "]";
    }

}
