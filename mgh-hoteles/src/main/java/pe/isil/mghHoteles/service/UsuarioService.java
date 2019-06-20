package pe.isil.mghHoteles.service;

import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Usuario;

import java.util.ArrayList;
import java.util.List;


@Service
public class UsuarioService implements  BasicCrud<Usuario, Integer> {


    List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void create(Usuario usuario) { usuarios.add(usuario);
    }

    @Override
    public Usuario update(Usuario usuarioUpdated) {
        Usuario currentUsuario = findById(usuarioUpdated.getIdUsuario());
        int index = usuarios.indexOf(currentUsuario);
        usuarios.set(index, usuarioUpdated);
        return usuarioUpdated;
    }

    @Override
    public void delete(Usuario usuario) {
        usuarios.remove(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarios;
    }

    @Override
    public Usuario findById(Integer idusuario) {
        Usuario usuario = usuarios.stream()
                .filter(e -> idusuario.equals(e.getIdUsuario()))
                .findFirst()
                .orElseGet(null);

        return usuario;
    }
}
