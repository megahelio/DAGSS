package entidades;

import java.time.LocalDateTime;

import javax.persistence.*;
///CREO QUE ESTA MAL PORQUE TIENE QUE HEREDAR DE MEDICAMENTO CREO
@Entity
@Table(name = "preinscipcion")
public class PreinscripcionEntidad {

    public PreinscripcionEntidad(String medicamentoPreinscrito, String pacientePreinscrito, String medicoPreinscrito,
            int dosisDiaria, String indicacion, LocalDateTime fechaInicioPreinscripcion,
            LocalDateTime fechaFinPreinscripcion, Estado estado) {
        this.medicamentoPreinscrito = medicamentoPreinscrito;
        this.pacientePreinscrito = pacientePreinscrito;
        this.medicoPreinscrito = medicoPreinscrito;
        this.dosisDiaria = dosisDiaria;
        this.indicacion = indicacion;
        this.fechaInicioPreinscripcion = fechaInicioPreinscripcion;
        this.fechaFinPreinscripcion = fechaFinPreinscripcion;
        this.estado = Estado.ACTIVO;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "medicamentoPreinscrito")
    private String medicamentoPreinscrito;

    @Column(name = "pacientePreinscrito")
    private String pacientePreinscrito;

    @Column(name = "medicoPreinscrito")
    private String medicoPreinscrito;

    @Column(name = "dosisDiaria")
    private int dosisDiaria;

    @Column(name = "indicacion")
    private String indicacion;

    @Column(name = "fechaInicioPreinscripcion")
    private LocalDateTime fechaInicioPreinscripcion;

    @Column(name = "fechaFinPreinscripcion")
    private LocalDateTime fechaFinPreinscripcion;

    @Column(name = "Estado")
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicamentoPreinscrito() {
        return medicamentoPreinscrito;
    }

    public void setMedicamentoPreinscrito(String medicamentoPreinscrito) {
        this.medicamentoPreinscrito = medicamentoPreinscrito;
    }

    public String getPacientePreinscrito() {
        return pacientePreinscrito;
    }

    public void setPacientePreinscrito(String pacientePreinscrito) {
        this.pacientePreinscrito = pacientePreinscrito;
    }

    public String getMedicoPreinscrito() {
        return medicoPreinscrito;
    }

    public void setMedicoPreinscrito(String medicoPreinscrito) {
        this.medicoPreinscrito = medicoPreinscrito;
    }

    public int getDosisDiaria() {
        return dosisDiaria;
    }

    public void setDosisDiaria(int dosisDiaria) {
        this.dosisDiaria = dosisDiaria;
    }

    public String getIndicaciones() {
        return indicacion;
    }

    public void setIndicaciones(String indicacion) {
        this.indicacion = indicacion;
    }

    public LocalDateTime getFechaInicioPreinscripcion() {
        return fechaInicioPreinscripcion;
    }

    public void setFechaInicioPreinscripcion(LocalDateTime fechaInicioPreinscripcion) {
        this.fechaInicioPreinscripcion = fechaInicioPreinscripcion;
    }

    public LocalDateTime getFechaFinPreinscripcion() {
        return fechaInicioPreinscripcion;
    }

    public void setFechaFinPreinscripcion(LocalDateTime fechaInicioPreinscripcion) {
        this.fechaInicioPreinscripcion = fechaInicioPreinscripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
