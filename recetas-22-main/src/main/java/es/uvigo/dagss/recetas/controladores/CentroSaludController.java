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
import es.uvigo.dagss.recetas.servicios.CentroSaludServicioImpl;

@RestController
@RequestMapping(path = "/api/centroSalud", produces = MediaType.APPLICATION_JSON_VALUE)
public class CentroSaludController {

    @Autowired
    CentroSaludServicioImpl centroSaludServicio;

    @GetMapping()
    public ResponseEntity<List<CentroSalud>> buscarTodos() {
        try {
            List<CentroSalud> resultado = new ArrayList<>();

            resultado = centroSaludServicio.buscarTodos();

            if (resultado.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<CentroSalud> buscarPorId(@PathVariable("id") Long id) {
        Optional<CentroSalud> centroSaludentidad = centroSaludServicio.buscarPorId(id);

        if (centroSaludentidad.isPresent()) {
            return new ResponseEntity<>(centroSaludentidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable("id") Long id) {
        try {
            Optional<CentroSalud> centroSaludentidad = centroSaludServicio.buscarPorId(id);
            if (centroSaludentidad.isPresent()) {
                centroSaludServicio.eliminar(centroSaludentidad.get().getId());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CentroSalud> modificar(@PathVariable("id") Long id,
            @RequestBody CentroSalud centroSaludentidad) {
        Optional<CentroSalud> centroSaludEntidadOptional = centroSaludServicio.buscarPorId(id);

        if (centroSaludEntidadOptional.isPresent()) {
            CentroSalud nuevoCentroSaludEntidad = centroSaludServicio.modificar(centroSaludentidad);
            return new ResponseEntity<>(nuevoCentroSaludEntidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CentroSalud> crear(@RequestBody CentroSalud centroSaludentidad) {
        try {
            Long id = centroSaludentidad.getId();
            if ((id != null)) {
                Optional<CentroSalud> centroSaludEntidadOptional = centroSaludServicio.buscarPorId(id);

                if (centroSaludEntidadOptional.isPresent()) {
                    CentroSalud nuevoCentroSaludEntidad = centroSaludServicio.crear(centroSaludentidad);
                    URI uri = crearURICentroSaludEntidad(nuevoCentroSaludEntidad);

                    return ResponseEntity.created(uri).body(nuevoCentroSaludEntidad);

                }
            }
            // No aporta DNI o DNI ya existe
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Construye la URI del nuevo recurso creado con POST
    private URI crearURICentroSaludEntidad(CentroSalud centroSaludentidad) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(centroSaludentidad.getId())
                .toUri();
    }

}
