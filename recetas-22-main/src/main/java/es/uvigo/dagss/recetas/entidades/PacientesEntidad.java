package es.uvigo.dagss.recetas.entidades;

import javax.persistence.*;

@Entity
public class PacientesEntidad extends UsuarioEntidad {

    public PacientesEntidad(String login, String nombre, String apellidos, String dni, String numTarjetaSanitaria,
            String numSeguridadSocial, int telefono, String email, String fechaNacimiento, String centroSaludAsign,
            String medicoAsignado, Estado estado, Rol rol, Direccion direccion) {
        super(login, nombre, email);
        this.apellidos = apellidos;
        this.dni = dni;
        this.numTarjetaSanitaria = numTarjetaSanitaria;
        this.numSeguridadSocial = numSeguridadSocial;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.centroSaludAsign = centroSaludAsign;
        this.medicoAsignado = medicoAsignado;
        this.estado = estado;
        this.rol = rol;
        this.direccion = direccion;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "dni")
    private String dni;

    @Column(name = "numTarjetaSanitaria")
    private String numTarjetaSanitaria;

    @Column(name = "numSeguridadSocial")
    private String numSeguridadSocial;

    @Column(name = "telefono")
    private int telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;

    @Column(name = "centroSaludAsign")
    private String centroSaludAsign;

    @Column(name = "medicoAsignado")
    private String medicoAsignado;

    @Column(name = "Estado")
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "Rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;
    private Direccion direccion;

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String dni) {
        this.dni = dni;
    }

    public String getNumTarjetaSanitaria() {
        return numTarjetaSanitaria;
    }

    public void setNumTarjetaSanitaria(String numTarjetaSanitaria) {
        this.numTarjetaSanitaria = numTarjetaSanitaria;
    }

    public String getNumSeguridadSocial() {
        return numSeguridadSocial;
    }

    public void setNumSeguridadSocial(String numSeguridadSocial) {
        this.numSeguridadSocial = numSeguridadSocial;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCentroSaludAsignado() {
        return centroSaludAsign;
    }

    public void setCentroSaludAsignado(String centroSaludAsign) {
        this.centroSaludAsign = centroSaludAsign;
    }

    public String getMedicoAsignado() {
        return medicoAsignado;
    }

    public void setMedicoAsignado(String medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
