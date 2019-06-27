package pe.isil.mghHoteles.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.mghHoteles.model.Usuario;
import pe.isil.mghHoteles.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsuarioResource  {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity getAll(){
        List<Usuario> usuarios = usuarioService.findAll();
        if(usuarios.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/usuarios/{idUsuario}")
    public ResponseEntity getUsuarioById(@PathVariable Integer idUsuario){
        Optional<Usuario> usuario = usuarioService.findById(idUsuario);
        if(!usuario.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping("/usuarios")
    public ResponseEntity createUsuario(@RequestBody Usuario usuario){
        usuarioService.create(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @PutMapping("/usuarios/{idUsuario}")
    public ResponseEntity updateUsuario(@PathVariable Integer idUsuario, @RequestBody Usuario usuario){
        Optional<Usuario> currentUsuario = usuarioService.findById(idUsuario);
        if(!currentUsuario.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        usuario.setIdUsuario(currentUsuario.get().getIdUsuario());
        usuarioService.update(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/usuarios/{idUsuario}")
    public ResponseEntity deleteUsuario(@PathVariable Integer idUsuario){
        Optional<Usuario> currentUsuario = usuarioService.findById(idUsuario);
        if(!currentUsuario.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        usuarioService.delete(currentUsuario.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
