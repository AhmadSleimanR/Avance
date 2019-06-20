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

    @GetMapping("/fotos/{IdFoto}")
    public ResponseEntity getFotoById(@PathVariable Integer IdFoto){
        Optional<Foto> foto = fotoService.findById(IdFoto);
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

    @PutMapping("/fotos/{IdFoto}")
    public ResponseEntity updateFoto(@PathVariable Integer IdFoto, @RequestBody Foto foto){
        Optional<Foto> currentAuthor = fotoService.findById(IdFoto);
        if(!currentAuthor.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        foto.setIdFoto(currentAuthor.get().getIdFoto());
        fotoService.update(foto);
        return new ResponseEntity<>(foto, HttpStatus.OK);
    }

    @DeleteMapping("/fotos/{IdFoto}")
    public ResponseEntity deleteFoto(@PathVariable Integer IdFoto){
        Optional<Foto> currentFoto = fotoService.findById(IdFoto);
        if(!currentFoto.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        fotoService.delete(currentFoto.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
