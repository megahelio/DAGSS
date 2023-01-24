package es.uvigo.dagss.recetas.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Receta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Prescripcion prenscripcionReceta;

    @ManyToOne
    private Paciente paciente;

    @Temporal(TemporalType.DATE)
    private Date fechaInicioValidez;
    @Temporal(TemporalType.DATE)
    private Date fechaFinValidez;

    private int numCajas;

    @ManyToOne
    private Farmacia farmaciaUsada;

    @Enumerated(EnumType.STRING)
    private EstadoReceta receta;

    /**
     * 
     */
    public Receta() {
    }

    /**
     * @param id
     * @param prenscripcionReceta
     * @param fechaInicioValidez
     * @param fechaFinValidez
     * @param numCajas
     * @param receta
     */
    public Receta(Prescripcion prenscripcionReceta, Date fechaInicioValidez,
            Date fechaFinValidez, int numCajas) {
        this.prenscripcionReceta = prenscripcionReceta;
        this.fechaInicioValidez = fechaInicioValidez;
        this.fechaFinValidez = fechaFinValidez;
        this.numCajas = numCajas;
        this.farmaciaUsada = null;
        this.receta = EstadoReceta.PLANIFICADA;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the prenscripcionReceta
     */
    public Prescripcion getPrenscripcionReceta() {
        return prenscripcionReceta;
    }

    /**
     * @param prenscripcionReceta the prenscripcionReceta to set
     */
    public void setPrenscripcionReceta(Prescripcion prenscripcionReceta) {
        this.prenscripcionReceta = prenscripcionReceta;
    }

    /**
     * @return the fechaInicioValidez
     */
    public Date getFechaInicioValidez() {
        return fechaInicioValidez;
    }

    /**
     * @param fechaInicioValidez the fechaInicioValidez to set
     */
    public void setFechaInicioValidez(Date fechaInicioValidez) {
        this.fechaInicioValidez = fechaInicioValidez;
    }

    /**
     * @return the fechaFinValidez
     */
    public Date getFechaFinValidez() {
        return fechaFinValidez;
    }

    /**
     * @param fechaFinValidez the fechaFinValidez to set
     */
    public void setFechaFinValidez(Date fechaFinValidez) {
        this.fechaFinValidez = fechaFinValidez;
    }

    /**
     * @return the numCajas
     */
    public int getNumCajas() {
        return numCajas;
    }

    /**
     * @param numCajas the numCajas to set
     */
    public void setNumCajas(int numCajas) {
        this.numCajas = numCajas;
    }

    /**
     * @return the farmaciaUsada
     */
    public Farmacia getFarmaciaUsada() {
        return farmaciaUsada;
    }

    /**
     * @param farmaciaUsada the farmaciaUsada to set
     */
    public void setFarmaciaUsada(Farmacia farmaciaUsada) {
        this.farmaciaUsada = farmaciaUsada;
    }

    /**
     * @return the receta
     */
    public EstadoReceta getReceta() {
        return receta;
    }

    /**
     * @param receta the receta to set
     */
    public void setReceta(EstadoReceta receta) {
        this.receta = receta;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((prenscripcionReceta == null) ? 0 : prenscripcionReceta.hashCode());
        result = prime * result + ((fechaInicioValidez == null) ? 0 : fechaInicioValidez.hashCode());
        result = prime * result + ((fechaFinValidez == null) ? 0 : fechaFinValidez.hashCode());
        result = prime * result + numCajas;
        result = prime * result + ((farmaciaUsada == null) ? 0 : farmaciaUsada.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Receta other = (Receta) obj;
        if (prenscripcionReceta == null) {
            if (other.prenscripcionReceta != null)
                return false;
        } else if (!prenscripcionReceta.equals(other.prenscripcionReceta))
            return false;
        if (fechaInicioValidez == null) {
            if (other.fechaInicioValidez != null)
                return false;
        } else if (!fechaInicioValidez.equals(other.fechaInicioValidez))
            return false;
        if (fechaFinValidez == null) {
            if (other.fechaFinValidez != null)
                return false;
        } else if (!fechaFinValidez.equals(other.fechaFinValidez))
            return false;
        if (numCajas != other.numCajas)
            return false;
        if (farmaciaUsada == null) {
            if (other.farmaciaUsada != null)
                return false;
        } else if (!farmaciaUsada.equals(other.farmaciaUsada))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Receta [id=" + id + ", prenscripcionReceta=" + prenscripcionReceta + ", fechaInicioValidez="
                + fechaInicioValidez + ", fechaFinValidez=" + fechaFinValidez + ", numCajas=" + numCajas
                + ", farmaciaUsada=" + farmaciaUsada + ", receta=" + receta + "]";
    }

}
