package es.uvigo.dagss.recetas.entidades;

import java.util.Date;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "login")
public class Paciente extends Usuario {

    private String nombre;
    private String apellidos;
    private String dni;// unique?
    private String numTarjetaSanitaria;
    private String numSeguridadSocial;
    private String telefono;
    private String email;
    
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @ManyToOne
    private Medico medicoAsignado;

    @Embedded
    private Direccion direccion;

    /**
     * 
     */
    public Paciente() {
    }

    /**
     * @param login
     * @param password
     * @param rol
     * @param usuario
     * @param nombre
     * @param apellidos
     * @param dni
     * @param numTarjetaSanitaria
     * @param numSeguridadSocial
     * @param telefono
     * @param email
     * @param fechaNacimiento
     * @param medicoAsignado
     * @param direccion
     */
    public Paciente(String login, String password, String nombre,
            String apellidos, String dni, String numTarjetaSanitaria, String numSeguridadSocial, String telefono,
            String email, Date fechaNacimiento, Medico medicoAsignado, Direccion direccion) {
        super(login, password, Rol.PACIENTE);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.numTarjetaSanitaria = numTarjetaSanitaria;
        this.numSeguridadSocial = numSeguridadSocial;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.medicoAsignado = medicoAsignado;
        this.direccion = direccion;
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
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the numTarjetaSanitaria
     */
    public String getNumTarjetaSanitaria() {
        return numTarjetaSanitaria;
    }

    /**
     * @param numTarjetaSanitaria the numTarjetaSanitaria to set
     */
    public void setNumTarjetaSanitaria(String numTarjetaSanitaria) {
        this.numTarjetaSanitaria = numTarjetaSanitaria;
    }

    /**
     * @return the numSeguridadSocial
     */
    public String getNumSeguridadSocial() {
        return numSeguridadSocial;
    }

    /**
     * @param numSeguridadSocial the numSeguridadSocial to set
     */
    public void setNumSeguridadSocial(String numSeguridadSocial) {
        this.numSeguridadSocial = numSeguridadSocial;
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
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the medicoAsignado
     */
    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }

    /**
     * @param medicoAsignado the medicoAsignado to set
     */
    public void setMedicoAsignado(Medico medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
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
        int result = super.hashCode();
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
        result = prime * result + ((numTarjetaSanitaria == null) ? 0 : numTarjetaSanitaria.hashCode());
        result = prime * result + ((numSeguridadSocial == null) ? 0 : numSeguridadSocial.hashCode());
        result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
        result = prime * result + ((medicoAsignado == null) ? 0 : medicoAsignado.hashCode());
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
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Paciente other = (Paciente) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (apellidos == null) {
            if (other.apellidos != null)
                return false;
        } else if (!apellidos.equals(other.apellidos))
            return false;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        if (numTarjetaSanitaria == null) {
            if (other.numTarjetaSanitaria != null)
                return false;
        } else if (!numTarjetaSanitaria.equals(other.numTarjetaSanitaria))
            return false;
        if (numSeguridadSocial == null) {
            if (other.numSeguridadSocial != null)
                return false;
        } else if (!numSeguridadSocial.equals(other.numSeguridadSocial))
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
        if (fechaNacimiento == null) {
            if (other.fechaNacimiento != null)
                return false;
        } else if (!fechaNacimiento.equals(other.fechaNacimiento))
            return false;
        if (medicoAsignado == null) {
            if (other.medicoAsignado != null)
                return false;
        } else if (!medicoAsignado.equals(other.medicoAsignado))
            return false;
        if (direccion == null) {
            if (other.direccion != null)
                return false;
        } else if (!direccion.equals(other.direccion))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PacientesEntidad [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni
                + ", numTarjetaSanitaria=" + numTarjetaSanitaria + ", numSeguridadSocial=" + numSeguridadSocial
                + ", telefono=" + telefono + ", email=" + email + ", fechaNacimiento=" + fechaNacimiento
                + ", medicoAsignado=" + medicoAsignado + ", direccion=" + direccion + "]";
    }

}
