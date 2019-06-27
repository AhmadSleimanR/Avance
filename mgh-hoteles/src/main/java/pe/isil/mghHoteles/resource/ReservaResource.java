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

    @GetMapping("/reservas/{idReserva}")
    public ResponseEntity getReservaById(@PathVariable Integer idReserva){
        Optional<Reserva> reserva = reservaService.findById(idReserva);
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

    @PutMapping("/reservas/{idReserva}")
    public ResponseEntity updateReserva(@PathVariable Integer idReserva, @RequestBody Reserva reserva){
        Optional<Reserva> currentReserva = reservaService.findById(idReserva);
        if(!currentReserva.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        reserva.setIdReserva(currentReserva.get().getIdReserva());
        reservaService.update(reserva);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @DeleteMapping("/reservas/{idReserva}")
    public ResponseEntity deleteReserva(@PathVariable Integer idReserva){
        Optional<Reserva> currentReserva = reservaService.findById(idReserva);
        if(!currentReserva.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        reservaService.delete(currentReserva.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
