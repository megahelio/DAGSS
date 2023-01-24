package es.uvigo.dagss.recetas.entidades;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "login")
public class Farmacia extends Usuario {

    private String nif;
    private String nombreEstablecimiento;
    private String nombreFarmaceutico;
    private String apellidosFarmaceutico;
    private String numColegiado;
    private String telefono;
    private String email;

    @Enumerated(EnumType.STRING)
    private EstadoGeneral estado;

    @Embedded
    private Direccion direccion;

    /**
     * 
     */
    public Farmacia() {
    }

    /**
     * @param login
     * @param password
     * @param rol
     * @param nif
     * @param nombreEstablecimiento
     * @param nombreFarmaceutico
     * @param apellidosFarmaceutico
     * @param numColegiado
     * @param telefono
     * @param email
     * @param estado
     * @param direccion
     */
    public Farmacia(String login, String password, Rol rol, String nif, String nombreEstablecimiento,
            String nombreFarmaceutico, String apellidosFarmaceutico, String numColegiado, String telefono, String email,
            Direccion direccion) {
        super(login, password, rol);
        this.nif = nif;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.nombreFarmaceutico = nombreFarmaceutico;
        this.apellidosFarmaceutico = apellidosFarmaceutico;
        this.numColegiado = numColegiado;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.estado = EstadoGeneral.ACTIVO;
    }

    /**
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * @return the nombreEstablecimiento
     */
    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    /**
     * @param nombreEstablecimiento the nombreEstablecimiento to set
     */
    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    /**
     * @return the nombreFarmaceutico
     */
    public String getNombreFarmaceutico() {
        return nombreFarmaceutico;
    }

    /**
     * @param nombreFarmaceutico the nombreFarmaceutico to set
     */
    public void setNombreFarmaceutico(String nombreFarmaceutico) {
        this.nombreFarmaceutico = nombreFarmaceutico;
    }

    /**
     * @return the apellidosFarmaceutico
     */
    public String getApellidosFarmaceutico() {
        return apellidosFarmaceutico;
    }

    /**
     * @param apellidosFarmaceutico the apellidosFarmaceutico to set
     */
    public void setApellidosFarmaceutico(String apellidosFarmaceutico) {
        this.apellidosFarmaceutico = apellidosFarmaceutico;
    }

    /**
     * @return the numColegiado
     */
    public String getNumColegiado() {
        return numColegiado;
    }

    /**
     * @param numColegiado the numColegiado to set
     */
    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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

    /**
     * @return the direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
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
        result = prime * result + ((nif == null) ? 0 : nif.hashCode());
        result = prime * result + ((nombreEstablecimiento == null) ? 0 : nombreEstablecimiento.hashCode());
        result = prime * result + ((nombreFarmaceutico == null) ? 0 : nombreFarmaceutico.hashCode());
        result = prime * result + ((apellidosFarmaceutico == null) ? 0 : apellidosFarmaceutico.hashCode());
        result = prime * result + ((numColegiado == null) ? 0 : numColegiado.hashCode());
        result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
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
        Farmacia other = (Farmacia) obj;
        if (nif == null) {
            if (other.nif != null)
                return false;
        } else if (!nif.equals(other.nif))
            return false;
        if (nombreEstablecimiento == null) {
            if (other.nombreEstablecimiento != null)
                return false;
        } else if (!nombreEstablecimiento.equals(other.nombreEstablecimiento))
            return false;
        if (nombreFarmaceutico == null) {
            if (other.nombreFarmaceutico != null)
                return false;
        } else if (!nombreFarmaceutico.equals(other.nombreFarmaceutico))
            return false;
        if (apellidosFarmaceutico == null) {
            if (other.apellidosFarmaceutico != null)
                return false;
        } else if (!apellidosFarmaceutico.equals(other.apellidosFarmaceutico))
            return false;
        if (numColegiado == null) {
            if (other.numColegiado != null)
                return false;
        } else if (!numColegiado.equals(other.numColegiado))
            return false;
        if (telefono == null) {
            if (other.telefono != null)
                return false;
        } else if (!telefono.equals(other.telefono))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (estado != other.estado)
            return false;
        if (direccion == null) {
            if (other.direccion != null)
                return false;
        } else if (!direccion.equals(other.direccion))
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
        return "FarmaciasEntidad [nif=" + nif + ", nombreEstablecimiento=" + nombreEstablecimiento
                + ", nombreFarmaceutico=" + nombreFarmaceutico + ", apellidosFarmaceutico=" + apellidosFarmaceutico
                + ", numColegiado=" + numColegiado + ", telefono=" + telefono + ", email=" + email + ", estado="
                + estado + ", direccion=" + direccion + "]";
    }

}
