package es.uvigo.dagss.recetas.controladores;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import es.uvigo.dagss.recetas.entidades.Administrador;
import es.uvigo.dagss.recetas.servicios.AdministradorServicioImpl;
import es.uvigo.dagss.recetas.servicios.UsuarioServicioImpl;

@RestController
@RequestMapping(path = "/api/administrador", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdministradorController {

    @Autowired
    AdministradorServicioImpl administradorServicio;
    @Autowired
    UsuarioServicioImpl usuarioServicioImpl;

    @GetMapping()
    public ResponseEntity<List<Administrador>> buscarTodos() {
        try {
            List<Administrador> resultado = new ArrayList<>();

            resultado = administradorServicio.buscarTodos();

            if (resultado.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "{login}")
    public ResponseEntity<Administrador> buscarPorId(@PathVariable("login") String login) {
        Optional<Administrador> administradorentidad = administradorServicio.buscarPorId(login);

        if (administradorentidad.isPresent()) {
            return new ResponseEntity<>(administradorentidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{login}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable("login") String login) {
        try {
            Optional<Administrador> administradorentidad = administradorServicio.buscarPorId(login);
            if (administradorentidad.isPresent()) {
                administradorServicio.eliminar(administradorentidad.get().getLogin());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "{login}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Administrador> modificar(@PathVariable("login") String login,
            @RequestBody Administrador administradorentidad) {
        Optional<Administrador> administradorEntidadOptional = administradorServicio.buscarPorId(login);

        if (administradorEntidadOptional.isPresent()) {
            Administrador nuevoAdministradorEntidad = administradorServicio.modificar(administradorentidad);
            return new ResponseEntity<>(nuevoAdministradorEntidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Administrador> crear(@RequestBody Administrador administradorentidad) {
        try {
            String login = administradorentidad.getLogin();

            if ((login != null) && !login.trim().isEmpty()) {

                Optional<Administrador> administradorEntidadOptional = administradorServicio.buscarPorId(login);

                if (!administradorEntidadOptional.isPresent()) {
                    usuarioServicioImpl.crear(administradorentidad);
                    Administrador nuevoAdministradorEntidad = administradorServicio.crear(administradorentidad);
                    URI uri = crearURIAdministradorEntidad(nuevoAdministradorEntidad);

                    return ResponseEntity.created(uri).body(nuevoAdministradorEntidad);

                }
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Construye la URI del nuevo recurso creado con POST
    private URI crearURIAdministradorEntidad(Administrador administradorentidad) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{login}")
                .buildAndExpand(administradorentidad.getLogin())
                .toUri();
    }

}
