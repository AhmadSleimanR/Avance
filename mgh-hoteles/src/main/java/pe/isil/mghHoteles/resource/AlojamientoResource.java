package pe.isil.mghHoteles.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.mghHoteles.model.Alojamiento;
import pe.isil.mghHoteles.service.AlojamientoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AlojamientoResource {

    @Autowired
    AlojamientoService alojamientoService;

    @GetMapping("/alojamientos")
    public ResponseEntity getAll(){
        List<Alojamiento> alojamientos = alojamientoService.findAll();
        if(alojamientos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alojamientos, HttpStatus.OK);
    }

    @GetMapping("/alojamientos/{idAlojamiento}")
    public ResponseEntity getAlojamientoById(@PathVariable Integer idAlojamiento){
        Optional<Alojamiento> alojamiento = alojamientoService.findById(idAlojamiento);
        if(!alojamiento.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(alojamiento, HttpStatus.OK);
    }

    @PostMapping("/alojamientos")
    public ResponseEntity createAlojamiento(@RequestBody Alojamiento alojamiento){
        alojamientoService.create(alojamiento);
        return new ResponseEntity<>(alojamiento, HttpStatus.CREATED);
    }

    @PutMapping("/alojamientos/{idAlojamiento}")
    public ResponseEntity updateAlojamiento(@PathVariable Integer idAlojamiento, @RequestBody Alojamiento alojamiento){
        Optional<Alojamiento> currentAlojamiento = alojamientoService.findById(idAlojamiento);
        if(!currentAlojamiento.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        alojamiento.setIdAlojamiento(currentAlojamiento.get().getIdAlojamiento());
        alojamientoService.update(alojamiento);
        return new ResponseEntity<>(alojamiento, HttpStatus.OK);
    }

    @DeleteMapping("/alojamientos/{idAlojamiento}")
    public ResponseEntity deleteAlojamiento(@PathVariable Integer idAlojamiento){
        Optional<Alojamiento> currentAlojamiento = alojamientoService.findById(idAlojamiento);
        if(!currentAlojamiento.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        alojamientoService.delete(currentAlojamiento.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
