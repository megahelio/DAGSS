package es.uvigo.dagss.recetas.entidades;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "usuariologin")
public class Medico extends Usuario {

    private String nombre;

    private String apellidos;

    private String dni;

    private String numColegiado;

    private int telefono;

    private String email;

    @ManyToOne
    private CentroSalud centroSaludAsign;

    /**
     * @param login
     * @param password
     * @param rol
     * @param usuario
     * @param nombre
     * @param apellidos
     * @param dni
     * @param numColegiado
     * @param telefono
     * @param email
     * @param centroSaludAsign
     */
    public Medico(String login, String password, String nombre,
            String apellidos, String dni, String numColegiado, int telefono, String email,
            CentroSalud centroSaludAsign) {
        super(login, password, Rol.MÉDICO);

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.numColegiado = numColegiado;
        this.telefono = telefono;
        this.email = email;
        this.centroSaludAsign = centroSaludAsign;
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
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
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
     * @return the centroSaludAsign
     */
    public CentroSalud getCentroSaludAsign() {
        return centroSaludAsign;
    }

    /**
     * @param centroSaludAsign the centroSaludAsign to set
     */
    public void setCentroSaludAsign(CentroSalud centroSaludAsign) {
        this.centroSaludAsign = centroSaludAsign;
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
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
        result = prime * result + ((numColegiado == null) ? 0 : numColegiado.hashCode());
        result = prime * result + telefono;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((centroSaludAsign == null) ? 0 : centroSaludAsign.hashCode());
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
        Medico other = (Medico) obj;
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
        if (numColegiado == null) {
            if (other.numColegiado != null)
                return false;
        } else if (!numColegiado.equals(other.numColegiado))
            return false;
        if (telefono != other.telefono)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (centroSaludAsign == null) {
            if (other.centroSaludAsign != null)
                return false;
        } else if (!centroSaludAsign.equals(other.centroSaludAsign))
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
        return "MedicosEntidad [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", numColegiado="
                + numColegiado + ", telefono=" + telefono + ", email=" + email + ", centroSaludAsign="
                + centroSaludAsign + "]";
    }

}
