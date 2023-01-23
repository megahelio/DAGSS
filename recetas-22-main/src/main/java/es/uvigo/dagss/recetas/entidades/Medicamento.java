package es.uvigo.dagss.recetas.entidades;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Medicamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreComercial;
    private String principioActivo;
    private String fabricante;
    private String familia;
    private int numDosis;

    @Enumerated(EnumType.STRING)
    private EstadoGeneral estado;

    /**
     * @param id
     * @param nombreComercial
     * @param principioActivo
     * @param fabricante
     * @param familia
     * @param numDosis
     * @param estado
     */
    public Medicamento(String nombreComercial, String principioActivo, String fabricante,
            String familia, int numDosis) {
        this.nombreComercial = nombreComercial;
        this.principioActivo = principioActivo;
        this.fabricante = fabricante;
        this.familia = familia;
        this.numDosis = numDosis;
        this.estado = EstadoGeneral.ACTIVO;
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
     * @return the nombreComercial
     */
    public String getNombreComercial() {
        return nombreComercial;
    }

    /**
     * @param nombreComercial the nombreComercial to set
     */
    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    /**
     * @return the principioActivo
     */
    public String getPrincipioActivo() {
        return principioActivo;
    }

    /**
     * @param principioActivo the principioActivo to set
     */
    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    /**
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the familia
     */
    public String getFamilia() {
        return familia;
    }

    /**
     * @param familia the familia to set
     */
    public void setFamilia(String familia) {
        this.familia = familia;
    }

    /**
     * @return the numDosis
     */
    public int getNumDosis() {
        return numDosis;
    }

    /**
     * @param numDosis the numDosis to set
     */
    public void setNumDosis(int numDosis) {
        this.numDosis = numDosis;
    }

    /**
     * @return the estado
     */
    public EstadoGeneral getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoGeneral estado) {
        this.estado = estado;
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nombreComercial == null) ? 0 : nombreComercial.hashCode());
        result = prime * result + ((principioActivo == null) ? 0 : principioActivo.hashCode());
        result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
        result = prime * result + ((familia == null) ? 0 : familia.hashCode());
        result = prime * result + numDosis;
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
        Medicamento other = (Medicamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nombreComercial == null) {
            if (other.nombreComercial != null)
                return false;
        } else if (!nombreComercial.equals(other.nombreComercial))
            return false;
        if (principioActivo == null) {
            if (other.principioActivo != null)
                return false;
        } else if (!principioActivo.equals(other.principioActivo))
            return false;
        if (fabricante == null) {
            if (other.fabricante != null)
                return false;
        } else if (!fabricante.equals(other.fabricante))
            return false;
        if (familia == null) {
            if (other.familia != null)
                return false;
        } else if (!familia.equals(other.familia))
            return false;
        if (numDosis != other.numDosis)
            return false;
        if (estado != other.estado)
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "MedicamentosEntidad [id=" + id + ", nombreComercial=" + nombreComercial + ", principioActivo="
                + principioActivo + ", fabricante=" + fabricante + ", familia=" + familia + ", numDosis=" + numDosis
                + ", estado=" + estado + "]";
    }

}
