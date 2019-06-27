package pe.isil.mghHoteles.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.mghHoteles.model.Foto;
import pe.isil.mghHoteles.service.FotoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FotoResource {

    @Autowired
    FotoService fotoService;

    @GetMapping("/fotos")
    public ResponseEntity getAll(){
        List<Foto> fotos = fotoService.findAll();
        if(fotos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fotos, HttpStatus.OK);
    }

    @GetMapping("/fotos/{idFoto}")
    public ResponseEntity getFotoById(@PathVariable Integer idFoto){
        Optional<Foto> foto = fotoService.findById(idFoto);
        if(!foto.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foto, HttpStatus.OK);
    }

    @PostMapping("/fotos")
    public ResponseEntity createFoto(@RequestBody Foto foto){
        fotoService.create(foto);
        return new ResponseEntity<>(foto, HttpStatus.CREATED);
    }

    @PutMapping("/fotos/{idFoto}")
    public ResponseEntity updateFoto(@PathVariable Integer idFoto, @RequestBody Foto foto){
        Optional<Foto> currentFoto = fotoService.findById(idFoto);
        if(!currentFoto.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        foto.setIdFoto(currentFoto.get().getIdFoto());
        fotoService.update(foto);
        return new ResponseEntity<>(foto, HttpStatus.OK);
    }

    @DeleteMapping("/fotos/{idFoto}")
    public ResponseEntity deleteFoto(@PathVariable Integer idFoto){
        Optional<Foto> currentFoto = fotoService.findById(idFoto);
        if(!currentFoto.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        fotoService.delete(currentFoto.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
