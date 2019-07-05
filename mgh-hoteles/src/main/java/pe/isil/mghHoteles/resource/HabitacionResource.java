package pe.isil.mghHoteles.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.mghHoteles.model.Habitacion;
import pe.isil.mghHoteles.service.HabitacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HabitacionResource {

    @Autowired
    HabitacionService habitacionService;

    @GetMapping("/habitaciones")
    public ResponseEntity getAll(){
        List<Habitacion> habitacions = habitacionService.findAll();
        if(habitacions.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(habitacions, HttpStatus.OK);
    }

    @GetMapping("/habitaciones/{idHabitacion}")
    public ResponseEntity getHabitacionById(@PathVariable Integer idHabitacion){
        Optional<Habitacion> habitacion = habitacionService.findById(idHabitacion);
        if(!habitacion.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(habitacion, HttpStatus.OK);
    }

    @PostMapping("/habitaciones")
    public ResponseEntity createHabitacion(@RequestBody Habitacion habitacion){
        habitacionService.create(habitacion);
        return new ResponseEntity<>(habitacion, HttpStatus.CREATED);
    }

    @PutMapping("/habitaciones/{idHabitacion}")
    public ResponseEntity updateHabitacion(@PathVariable Integer idHabitacion, @RequestBody Habitacion habitacion){
        Optional<Habitacion> currentHabitacion = habitacionService.findById(idHabitacion);
        if(!currentHabitacion.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        habitacion.setIdHabitacion(currentHabitacion.get().getIdHabitacion());
        habitacionService.update(habitacion);
        return new ResponseEntity<>(habitacion, HttpStatus.OK);
    }

    @DeleteMapping("/habitaciones/{idHabitacion}")
    public ResponseEntity deleteHabitacion(@PathVariable Integer idHabitacion){
        Optional<Habitacion> currentHabitacion = habitacionService.findById(idHabitacion);
        if(!currentHabitacion.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        habitacionService.delete(currentHabitacion.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
