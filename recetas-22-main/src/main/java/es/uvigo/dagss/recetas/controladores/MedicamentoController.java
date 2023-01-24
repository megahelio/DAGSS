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

import es.uvigo.dagss.recetas.entidades.Medicamento;
import es.uvigo.dagss.recetas.servicios.MedicamentoServicioImpl;

@RestController
@RequestMapping(path = "/api/medicamento", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicamentoController {

    @Autowired
    MedicamentoServicioImpl medicamentoServicio;

    @GetMapping()
    public ResponseEntity<List<Medicamento>> buscarTodos() {
        try {
            List<Medicamento> resultado = new ArrayList<>();

            resultado = medicamentoServicio.buscarTodos();

            if (resultado.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Medicamento> buscarPorId(@PathVariable("id") Long id) {
        Optional<Medicamento> medicamentoentidad = medicamentoServicio.buscarPorId(id);

        if (medicamentoentidad.isPresent()) {
            return new ResponseEntity<>(medicamentoentidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/familia/{familia}")
    public ResponseEntity<List<Medicamento>> buscarPorFamilia(@PathVariable("familia") String familia) {
        List<Medicamento> medicamentoentidad = medicamentoServicio.buscarPorFamilia(familia);

        if (medicamentoentidad.isEmpty()) {
            return new ResponseEntity<>(medicamentoentidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/nombreComercial/{nombreComercial}")
    public ResponseEntity<List<Medicamento>> buscarPorNombreComercial(
            @PathVariable("nombreComercial") String nombreEstablecimiento) {
        List<Medicamento> medicamentoentidad = medicamentoServicio.buscarPorNombreComercial(nombreEstablecimiento);

        if (medicamentoentidad.isEmpty()) {
            return new ResponseEntity<>(medicamentoentidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/fabricante/{fabricante}")
    public ResponseEntity<List<Medicamento>> buscarPorFabricante(@PathVariable("fabricante") String fabricante) {
        List<Medicamento> medicamentoentidad = medicamentoServicio.buscarPorNombreComercial(fabricante);

        if (medicamentoentidad.isEmpty()) {
            return new ResponseEntity<>(medicamentoentidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/principioActivo/{principioActivo}")
    public ResponseEntity<List<Medicamento>> buscarPorPrincipioActivo(
            @PathVariable("principioActivo") String principioActivo) {
        List<Medicamento> medicamentoentidad = medicamentoServicio.buscarPorNombreComercial(principioActivo);

        if (medicamentoentidad.isEmpty()) {
            return new ResponseEntity<>(medicamentoentidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable("id") Long id) {
        try {
            Optional<Medicamento> medicamentoentidad = medicamentoServicio.buscarPorId(id);
            if (medicamentoentidad.isPresent()) {
                medicamentoServicio.eliminar(medicamentoentidad.get().getId());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medicamento> modificar(@PathVariable("id") Long id,
            @RequestBody Medicamento medicamentoentidad) {
        Optional<Medicamento> medicamentoEntidadOptional = medicamentoServicio.buscarPorId(id);

        if (medicamentoEntidadOptional.isPresent()) {
            Medicamento nuevoMedicamentoEntidad = medicamentoServicio.modificar(medicamentoentidad);
            return new ResponseEntity<>(nuevoMedicamentoEntidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medicamento> crear(@RequestBody Medicamento medicamentoentidad) {
        try {
            Long id = medicamentoentidad.getId();
            if ((id != null)) {
                Optional<Medicamento> medicamentoEntidadOptional = medicamentoServicio.buscarPorId(id);

                if (medicamentoEntidadOptional.isPresent()) {
                    Medicamento nuevoMedicamentoEntidad = medicamentoServicio.crear(medicamentoentidad);
                    URI uri = crearURIMedicamentoEntidad(nuevoMedicamentoEntidad);

                    return ResponseEntity.created(uri).body(nuevoMedicamentoEntidad);

                }
            }
            // No aporta DNI o DNI ya existe
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Construye la URI del nuevo recurso creado con POST
    private URI crearURIMedicamentoEntidad(Medicamento medicamentoentidad) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(medicamentoentidad.getId())
                .toUri();
    }

}
