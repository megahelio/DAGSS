package controladores;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import entidades.UsuarioEntidad;
import servicios.UsuarioServicio;

@RestController
@RequestMapping(path = "/api/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping()
    public ResponseEntity<List<UsuarioEntidad>> buscarTodos(
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "nombre", required = false) String nombre) {
        try {
            System.out.println("caca");
            List<UsuarioEntidad> resultado = new ArrayList<>();

            if (email != null) {
                resultado = usuarioServicio.buscarPorEmail(email);
            } else if (nombre != null) {
                resultado = usuarioServicio.buscarPorNombre(nombre);

            } else {
                resultado = usuarioServicio.buscarTodos();
            }

            if (resultado.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "{login}")
    public ResponseEntity<UsuarioEntidad> buscarPorLogin(@PathVariable("login") String login) {
        Optional<UsuarioEntidad> usuarioentidad = usuarioServicio.buscarPorLogin(login);

        if (usuarioentidad.isPresent()) {
            return new ResponseEntity<>(usuarioentidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{login}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable("login") String login) {
        try {
            Optional<UsuarioEntidad> usuarioentidad = usuarioServicio.buscarPorLogin(login);
            if (usuarioentidad.isPresent()) {
                usuarioServicio.eliminar(usuarioentidad.get());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "{login}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioEntidad> modificar(@PathVariable("login") String login,
            @RequestBody UsuarioEntidad usuarioentidad) {
        Optional<UsuarioEntidad> usuarioEntidadOptional = usuarioServicio.buscarPorLogin(login);

        if (usuarioEntidadOptional.isPresent()) {
            UsuarioEntidad nuevoUsuarioEntidad = usuarioServicio.modificar(usuarioentidad);
            return new ResponseEntity<>(nuevoUsuarioEntidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioEntidad> crear(@RequestBody UsuarioEntidad usuarioentidad) {
        try {
            String login = usuarioentidad.getLogin();
            if ((login != null) && !login.trim().isEmpty()) {
                Optional<UsuarioEntidad> usuarioEntidadOptional = usuarioServicio.buscarPorLogin(login);

                if (usuarioEntidadOptional.isPresent()) {
                    UsuarioEntidad nuevoUsuarioEntidad = usuarioServicio.crear(usuarioentidad);
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
    private URI crearURIUsuarioEntidad(UsuarioEntidad usuarioentidad) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{login}")
                .buildAndExpand(usuarioentidad.getLogin())
                .toUri();
    }

}
