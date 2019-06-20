package pe.isil.mghHoteles.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.mghHoteles.model.Reserva;
import pe.isil.mghHoteles.service.ReservaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservaResource {

    @Autowired
    ReservaService reservaService;

    @GetMapping("/reservas")
    public ResponseEntity getAll(){
        List<Reserva> reservas = reservaService.findAll();
        if(reservas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/reservas/{IdReserva}")
    public ResponseEntity getReservaById(@PathVariable Integer IdReserva){
        Optional<Reserva> reserva = reservaService.findById(IdReserva);
        if(!reserva.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @PostMapping("/reservas")
    public ResponseEntity createReserva(@RequestBody Reserva reserva){
        reservaService.create(reserva);
        return new ResponseEntity<>(reserva, HttpStatus.CREATED);
    }

    @PutMapping("/reservas/{IdReserva}")
    public ResponseEntity updateReserva(@PathVariable Integer IdReserva, @RequestBody Reserva reserva){
        Optional<Reserva> currentAuthor = reservaService.findById(IdReserva);
        if(!currentAuthor.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        reserva.setIdReserva(currentAuthor.get().getIdReserva());
        reservaService.update(reserva);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @DeleteMapping("/reservas/{IdReserva}")
    public ResponseEntity deleteReserva(@PathVariable Integer IdReserva){
        Optional<Reserva> currentReserva = reservaService.findById(IdReserva);
        if(!currentReserva.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        reservaService.delete(currentReserva.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
