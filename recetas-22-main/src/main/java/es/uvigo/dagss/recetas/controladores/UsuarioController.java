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

import es.uvigo.dagss.recetas.entidades.Usuario;
import es.uvigo.dagss.recetas.servicios.UsuarioServicioImpl;

@RestController
@RequestMapping(path = "/api/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    @Autowired
    UsuarioServicioImpl usuarioServicio;

    @GetMapping()
    public ResponseEntity<List<Usuario>> buscarTodos() {
        try {
            List<Usuario> resultado = new ArrayList<>();

            resultado = usuarioServicio.buscarTodos();

            if (resultado.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "{login}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable("login") String login) {
        Optional<Usuario> usuarioentidad = usuarioServicio.buscarPorId(login);

        if (usuarioentidad.isPresent()) {
            return new ResponseEntity<>(usuarioentidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{login}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable("login") String login) {
        try {
            Optional<Usuario> usuarioentidad = usuarioServicio.buscarPorId(login);
            if (usuarioentidad.isPresent()) {
                usuarioServicio.eliminar(usuarioentidad.get().getLogin());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "{login}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> modificar(@PathVariable("login") String login,
            @RequestBody Usuario usuarioentidad) {
        Optional<Usuario> usuarioEntidadOptional = usuarioServicio.buscarPorId(login);

        if (usuarioEntidadOptional.isPresent()) {
            Usuario nuevoUsuarioEntidad = usuarioServicio.modificar(usuarioentidad);
            return new ResponseEntity<>(nuevoUsuarioEntidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuarioentidad) {
        try {
            String login = usuarioentidad.getLogin();
            if ((login != null) && !login.trim().isEmpty()) {
                Optional<Usuario> usuarioEntidadOptional = usuarioServicio.buscarPorId(login);

                if (usuarioEntidadOptional.isPresent()) {
                    Usuario nuevoUsuarioEntidad = usuarioServicio.crear(usuarioentidad);
                    URI uri = crearURIUsuarioEntidad(nuevoUsuarioEntidad);

                    return ResponseEntity.created(uri).body(nuevoUsuarioEntidad);

                }
            }
            // No aporta DNI o DNI ya existe
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Construye la URI del nuevo recurso creado con POST
    private URI crearURIUsuarioEntidad(Usuario usuarioentidad) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{login}")
                .buildAndExpand(usuarioentidad.getLogin())
                .toUri();
    }

}
