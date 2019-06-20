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

    @GetMapping("/habitacions")
    public ResponseEntity getAll(){
        List<Habitacion> habitacions = habitacionService.findAll();
        if(habitacions.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(habitacions, HttpStatus.OK);
    }

    @GetMapping("/habitacions/{IdHabitacion}")
    public ResponseEntity getHabitacionById(@PathVariable Integer IdHabitacion){
        Optional<Habitacion> habitacion = habitacionService.findById(IdHabitacion);
        if(!habitacion.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(habitacion, HttpStatus.OK);
    }

    @PostMapping("/habitacions")
    public ResponseEntity createHabitacion(@RequestBody Habitacion habitacion){
        habitacionService.create(habitacion);
        return new ResponseEntity<>(habitacion, HttpStatus.CREATED);
    }

    @PutMapping("/habitacions/{IdHabitacion}")
    public ResponseEntity updateHabitacion(@PathVariable Integer IdHabitacion, @RequestBody Habitacion habitacion){
        Optional<Habitacion> currentAuthor = habitacionService.findById(IdHabitacion);
        if(!currentAuthor.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        habitacion.setIdHabitacion(currentAuthor.get().getIdHabitacion());
        habitacionService.update(habitacion);
        return new ResponseEntity<>(habitacion, HttpStatus.OK);
    }

    @DeleteMapping("/habitacions/{IdHabitacion}")
    public ResponseEntity deleteHabitacion(@PathVariable Integer IdHabitacion){
        Optional<Habitacion> currentHabitacion = habitacionService.findById(IdHabitacion);
        if(!currentHabitacion.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        habitacionService.delete(currentHabitacion.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
