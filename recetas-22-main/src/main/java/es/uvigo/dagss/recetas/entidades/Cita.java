package es.uvigo.dagss.recetas.entidades;

import java.util.Date;

import javax.persistence.*;

@Entity

public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente pacienteCitado;

    @ManyToOne
    private Medico medicoAtiende;

    private Date fechaCita;
    private int duracionCita;

    @Enumerated(EnumType.STRING)
    private EstadoCita cita;

    /**
     * 
     */
    public Cita() {
    }

    /**
     * @param id
     * @param pacienteCitado
     * @param medicoAtiende
     * @param fechaCita
     * @param duracionCita
     */
    public Cita(Paciente pacienteCitado, Medico medicoAtiende, Date fechaCita,
            int duracionCita) {
        this.pacienteCitado = pacienteCitado;
        this.medicoAtiende = medicoAtiende;// suponemos que a pesar de que el paciente tiene un medico asignado (Médico
                                           // de cabecera) el
                                           // paciente puede tener citas con otros medicos (Especialidades).
        this.fechaCita = fechaCita;
        this.duracionCita = duracionCita;
        this.cita = EstadoCita.PLANIFICADA;
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
     * @return the pacienteCitado
     */
    public Paciente getPacienteCitado() {
        return pacienteCitado;
    }

    /**
     * @param pacienteCitado the pacienteCitado to set
     */
    public void setPacienteCitado(Paciente pacienteCitado) {
        this.pacienteCitado = pacienteCitado;
    }

    /**
     * @return the medicoAtiende
     */
    public Medico getMedicoAtiende() {
        return medicoAtiende;
    }

    /**
     * @param medicoAtiende the medicoAtiende to set
     */
    public void setMedicoAtiende(Medico medicoAtiende) {
        this.medicoAtiende = medicoAtiende;
    }

    /**
     * @return the fechaCita
     */
    public Date getFechaCita() {
        return fechaCita;
    }

    /**
     * @param fechaCita the fechaCita to set
     */
    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    /**
     * @return the duracionCita
     */
    public int getDuracionCita() {
        return duracionCita;
    }

    /**
     * @param duracionCita the duracionCita to set
     */
    public void setDuracionCita(int duracionCita) {
        this.duracionCita = duracionCita;
    }

    /**
     * @return the cita
     */
    public EstadoCita getCita() {
        return cita;
    }

    /**
     * @param cita the cita to set
     */
    public void setCita(EstadoCita cita) {
        this.cita = cita;
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
        result = prime * result + ((pacienteCitado == null) ? 0 : pacienteCitado.hashCode());
        result = prime * result + ((medicoAtiende == null) ? 0 : medicoAtiende.hashCode());
        result = prime * result + ((fechaCita == null) ? 0 : fechaCita.hashCode());
        result = prime * result + duracionCita;
        result = prime * result + ((cita == null) ? 0 : cita.hashCode());
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
        Cita other = (Cita) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (pacienteCitado == null) {
            if (other.pacienteCitado != null)
                return false;
        } else if (!pacienteCitado.equals(other.pacienteCitado))
            return false;
        if (medicoAtiende == null) {
            if (other.medicoAtiende != null)
                return false;
        } else if (!medicoAtiende.equals(other.medicoAtiende))
            return false;
        if (fechaCita == null) {
            if (other.fechaCita != null)
                return false;
        } else if (!fechaCita.equals(other.fechaCita))
            return false;
        if (duracionCita != other.duracionCita)
            return false;
        if (cita != other.cita)
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
        return "CitasEntidad [id=" + id + ", pacienteCitado=" + pacienteCitado + ", medicoAtiende=" + medicoAtiende
                + ", fechaCita=" + fechaCita + ", duracionCita=" + duracionCita + ", cita=" + cita + "]";
    }

}
