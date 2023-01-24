package es.uvigo.dagss.recetas.entidades;

import java.util.Date;
import java.time.Instant;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "login")
public class Administrador extends Usuario {

    private String nombre;

    private String email;

    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @Temporal(TemporalType.DATE)
    private Date fechaUltimoAcceso;

    /**
     * 
     */
    public Administrador() {
        super();
    }


    public Administrador(String login, String password, String nombre, String email) {
        super(login, password, Rol.ADMINISTRADOR);
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = Date.from(Instant.now());
        this.fechaUltimoAcceso = Date.from(Instant.now());
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
     * @return the fechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the fechaUltimoAcceso
     */
    public Date getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }

    /**
     * @param fechaUltimoAcceso the fechaUltimoAcceso to set
     */
    public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
        this.fechaUltimoAcceso = fechaUltimoAcceso;
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
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((fechaRegistro == null) ? 0 : fechaRegistro.hashCode());
        result = prime * result + ((fechaUltimoAcceso == null) ? 0 : fechaUltimoAcceso.hashCode());
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
        Administrador other = (Administrador) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (fechaRegistro == null) {
            if (other.fechaRegistro != null)
                return false;
        } else if (!fechaRegistro.equals(other.fechaRegistro))
            return false;
        if (fechaUltimoAcceso == null) {
            if (other.fechaUltimoAcceso != null)
                return false;
        } else if (!fechaUltimoAcceso.equals(other.fechaUltimoAcceso))
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
        return "AdministradorEntidad [nombre=" + nombre + ", email=" + email + ", fechaRegistro=" + fechaRegistro
                + ", fechaUltimoAcceso=" + fechaUltimoAcceso + "]";
    }

}
