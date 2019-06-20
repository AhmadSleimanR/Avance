package pe.isil.mghHoteles.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.mghHoteles.model.Pago;
import pe.isil.mghHoteles.service.PagoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PagoResource {

    @Autowired
    PagoService pagoService;

    @GetMapping("/pagos")
    public ResponseEntity getAll(){
        List<Pago> pagos = pagoService.findAll();
        if(pagos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pagos, HttpStatus.OK);
    }

    @GetMapping("/pagos/{IdPago}")
    public ResponseEntity getPagoById(@PathVariable Integer IdPago){
        Optional<Pago> pago = pagoService.findById(IdPago);
        if(!pago.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pago, HttpStatus.OK);
    }

    @PostMapping("/pagos")
    public ResponseEntity createPago(@RequestBody Pago pago){
        pagoService.create(pago);
        return new ResponseEntity<>(pago, HttpStatus.CREATED);
    }

    @PutMapping("/pagos/{IdPago}")
    public ResponseEntity updatePago(@PathVariable Integer IdPago, @RequestBody Pago pago){
        Optional<Pago> currentAuthor = pagoService.findById(IdPago);
        if(!currentAuthor.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        pago.setIdPago(currentAuthor.get().getIdPago());
        pagoService.update(pago);
        return new ResponseEntity<>(pago, HttpStatus.OK);
    }

    @DeleteMapping("/pagos/{IdPago}")
    public ResponseEntity deletePago(@PathVariable Integer IdPago){
        Optional<Pago> currentPago = pagoService.findById(IdPago);
        if(!currentPago.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        pagoService.delete(currentPago.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
