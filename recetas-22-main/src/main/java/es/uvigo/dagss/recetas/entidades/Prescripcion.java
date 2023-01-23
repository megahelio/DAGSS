package es.uvigo.dagss.recetas.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Prescripcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Medicamento medicamento;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;
    private Double dosisDiaria;
    private String indicacion;

    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @Enumerated(EnumType.STRING)
    private EstadoGeneral estado;

    /**
     * @param medicamento
     * @param paciente
     * @param medico
     * @param dosisDiaria
     * @param indicacion
     * @param fechaInicio
     * @param fechaFin
     */
    public Prescripcion(Medicamento medicamento, Paciente paciente, Medico medico, Double dosisDiaria,
            String indicacion, Date fechaInicio, Date fechaFin) {
        this.medicamento = medicamento;
        this.paciente = paciente;
        this.medico = medico;
        this.dosisDiaria = dosisDiaria;
        this.indicacion = indicacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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
     * @return the medicamento
     */
    public Medicamento getMedicamento() {
        return medicamento;
    }

    /**
     * @param medicamento the medicamento to set
     */
    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * @return the medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * @return the dosisDiaria
     */
    public Double getDosisDiaria() {
        return dosisDiaria;
    }

    /**
     * @param dosisDiaria the dosisDiaria to set
     */
    public void setDosisDiaria(Double dosisDiaria) {
        this.dosisDiaria = dosisDiaria;
    }

    /**
     * @return the indicacion
     */
    public String getIndicacion() {
        return indicacion;
    }

    /**
     * @param indicacion the indicacion to set
     */
    public void setIndicacion(String indicacion) {
        this.indicacion = indicacion;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((medicamento == null) ? 0 : medicamento.hashCode());
        result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
        result = prime * result + ((medico == null) ? 0 : medico.hashCode());
        result = prime * result + ((dosisDiaria == null) ? 0 : dosisDiaria.hashCode());
        result = prime * result + ((indicacion == null) ? 0 : indicacion.hashCode());
        result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
        result = prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Prescripcion other = (Prescripcion) obj;
        if (medicamento == null) {
            if (other.medicamento != null)
                return false;
        } else if (!medicamento.equals(other.medicamento))
            return false;
        if (paciente == null) {
            if (other.paciente != null)
                return false;
        } else if (!paciente.equals(other.paciente))
            return false;
        if (medico == null) {
            if (other.medico != null)
                return false;
        } else if (!medico.equals(other.medico))
            return false;
        if (dosisDiaria == null) {
            if (other.dosisDiaria != null)
                return false;
        } else if (!dosisDiaria.equals(other.dosisDiaria))
            return false;
        if (indicacion == null) {
            if (other.indicacion != null)
                return false;
        } else if (!indicacion.equals(other.indicacion))
            return false;
        if (fechaInicio == null) {
            if (other.fechaInicio != null)
                return false;
        } else if (!fechaInicio.equals(other.fechaInicio))
            return false;
        if (fechaFin == null) {
            if (other.fechaFin != null)
                return false;
        } else if (!fechaFin.equals(other.fechaFin))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Prescripcion [id=" + id + ", medicamento=" + medicamento + ", paciente=" + paciente + ", medico="
                + medico + ", dosisDiaria=" + dosisDiaria + ", indicacion=" + indicacion + ", fechaInicio="
                + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + "]";
    }

}
