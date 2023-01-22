package entidades;

import javax.persistence.*;

@Entity
public class MedicosEntidad extends UsuarioEntidad {

    public MedicosEntidad(Long id, String nombre, String apellidos, String dni, String numColegiado, int telefono,
            String email, String centroSaludAsign, Estado estado, Rol rol) {
        super(id, nombre, email);
        this.apellidos = apellidos;
        this.dni = dni;
        this.numColegiado = numColegiado;
        this.telefono = telefono;
        this.email = email;
        this.centroSaludAsign = centroSaludAsign;
        this.estado = estado;
        this.rol = rol;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "numColegiado")
    private String numColegiado;

    @Column(name = "telefono")
    private int telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "centroSaludAsign")
    private String centroSaludAsign;

    @Column(name = "Estado")
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "Rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;

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

    public String getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
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

    public String getCentroSaludAsignado() {
        return centroSaludAsign;
    }

    public void setCentroSaludAsignado(String centroSaludAsign) {
        this.centroSaludAsign = centroSaludAsign;
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
