package es.uvigo.dagss.recetas.entidades;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class AdministradorEntidad extends UsuarioEntidad {

    public AdministradorEntidad(String login, String nombre, String email, Estado estado, LocalDateTime fechaRegistro,
            LocalDateTime fechaUltimoAcceso, Rol rol) {
        super(login, nombre, email);
        this.nombre = nombre;
        this.email = email;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.fechaUltimoAcceso = fechaUltimoAcceso;
        this.rol = rol;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_ultimo_acceso")
    private LocalDateTime fechaUltimoAcceso;

    @Column(name = "Rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDateTime getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }

    public void setFechaUltimoAcceso(LocalDateTime fechaUltimoAcceso) {
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
