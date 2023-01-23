package es.uvigo.dagss.recetas.entidades;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "citas")
public class CitasEntidad {

    public CitasEntidad(String pacienteCitado, String medicoAtiende, LocalDateTime fechaCita, String duracionCita, Cita cita) {
        this.pacienteCitado = pacienteCitado;
        this.medicoAtiende = medicoAtiende;
        this.fechaCita = fechaCita;
        this.duracionCita = duracionCita;
        this.cita = cita;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "pacienteCitado")
    private String pacienteCitado;

    @Column(name = "medicoAtiende")
    private String medicoAtiende;

    @Column(name = "fechaCita")
    private LocalDateTime fechaCita;

    @Column(name = "duracionCita")
    private String duracionCita;

    @Column(name = "Cita")
    @Enumerated(EnumType.STRING)
    private Cita cita;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPacienteCitado() {
        return pacienteCitado;
    }

    public void setPacienteCitado(String pacienteCitado) {
        this.pacienteCitado = pacienteCitado;
    }

    public String getMedicoAtiende() {
        return medicoAtiende;
    }

    public void setMedicoAtiende(String medicoAtiende) {
        this.medicoAtiende = medicoAtiende;
    }

    public LocalDateTime getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDateTime fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getDuracionCita() {
        return duracionCita;
    }

    public void setDuracionCita(String duracionCita) {
        this.duracionCita = duracionCita;
    }    

    public Cita getCita() {
        return cita;
    }

    public void setRol(Cita cita) {
        this.cita = cita;
    }
}
