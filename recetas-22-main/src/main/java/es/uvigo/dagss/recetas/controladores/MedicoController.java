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

import es.uvigo.dagss.recetas.entidades.CentroSalud;
import es.uvigo.dagss.recetas.entidades.Medico;
import es.uvigo.dagss.recetas.servicios.MedicoServicioImpl;

@RestController
@RequestMapping(path = "/api/medico", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicoController {

    @Autowired
    MedicoServicioImpl medicoServicio;

    @GetMapping()
    public ResponseEntity<List<Medico>> buscarTodos() {
        try {
            List<Medico> resultado = new ArrayList<>();

            resultado = medicoServicio.buscarTodos();

            if (resultado.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{login}")
    public ResponseEntity<Medico> buscarPorId(@PathVariable("login") String login) {
        Optional<Medico> medicoentidad = medicoServicio.buscarPorId(login);

        if (medicoentidad.isPresent()) {
            return new ResponseEntity<>(medicoentidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/centroSalud/{centro}")
    public ResponseEntity<List<Medico>> buscarPorCentroSaludAsignContaining(
            @PathVariable("centro") CentroSalud centro) {
        try {
            List<Medico> resultado = new ArrayList<>();
            resultado = medicoServicio.buscarPorCentroSaludAsignContaining(centro);

            if (resultado.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(resultado, HttpStatus.OK);

        } catch (

        Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/nombre/{nombre}")
    public ResponseEntity<List<Medico>> buscarPorCentroSaludAsignContaining(@PathVariable("nombre") String nombre) {
        try {
            List<Medico> medicoentidad = medicoServicio.buscarPorNombreContaining(nombre);
            if (medicoentidad.isEmpty()) {
                return new ResponseEntity<>(medicoentidad, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "{login}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable("login") String login) {
        try {
            Optional<Medico> medicoentidad = medicoServicio.buscarPorId(login);
            if (medicoentidad.isPresent()) {
                medicoServicio.eliminar(medicoentidad.get().getLogin());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "{login}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medico> modificar(@PathVariable("login") String login,
            @RequestBody Medico medicoentidad) {
        Optional<Medico> medicoEntidadOptional = medicoServicio.buscarPorId(login);

        if (medicoEntidadOptional.isPresent()) {
            Medico nuevoMedicoEntidad = medicoServicio.modificar(medicoentidad);
            return new ResponseEntity<>(nuevoMedicoEntidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medico> crear(@RequestBody Medico medicoentidad) {
        try {
            String login = medicoentidad.getLogin();
            if ((login != null) && !login.trim().isEmpty()) {
                Optional<Medico> medicoEntidadOptional = medicoServicio.buscarPorId(login);

                if (medicoEntidadOptional.isPresent()) {
                    Medico nuevoMedicoEntidad = medicoServicio.crear(medicoentidad);
                    URI uri = crearURIMedicoEntidad(nuevoMedicoEntidad);

                    return ResponseEntity.created(uri).body(nuevoMedicoEntidad);

                }
            }
            // No aporta DNI o DNI ya existe
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Construye la URI del nuevo recurso creado con POST
    private URI crearURIMedicoEntidad(Medico medicoentidad) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{login}")
                .buildAndExpand(medicoentidad.getLogin())
                .toUri();
    }

}
