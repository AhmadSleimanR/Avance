package pe.isil.mghHoteles.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.mghHoteles.model.Usuario;
import pe.isil.mghHoteles.service.ReservaService;
import pe.isil.mghHoteles.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioResource  {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ReservaService reservaService;

    @GetMapping("/usuarios")
    public ResponseEntity getAll(){
        List<Usuario> usuarios = usuarioService.findAll();
        if(usuarios.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/usuarios/{IdUsuario}")
    public ResponseEntity getUsuarioById(@PathVariable Integer IdUsuario){
        Usuario usuario = usuarioService.findById(IdUsuario);
        if(usuario == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping("/usuarios")
    public ResponseEntity createUsuario(@RequestBody Usuario usuario){
        usuarioService.create(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @PutMapping("/usuarios/{IdUsuario}")
    public ResponseEntity updateUsuario(@PathVariable Integer IdUsuario, @RequestBody Usuario usuario){
        Usuario currentAuthor = usuarioService.findById(IdUsuario);
        if(currentAuthor == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        usuario.setIdUsuario(currentAuthor.getIdUsuario());
        usuarioService.update(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/usuarios/{IdUsuario}")
    public ResponseEntity deleteUsuario(@PathVariable Integer IdUsuario){
        Usuario currentUsuario = usuarioService.findById(IdUsuario);
        if(currentUsuario == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        usuarioService.delete(currentUsuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
