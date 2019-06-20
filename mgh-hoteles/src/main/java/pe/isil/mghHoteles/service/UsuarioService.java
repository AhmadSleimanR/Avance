package pe.isil.mghHoteles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Usuario;
import pe.isil.mghHoteles.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public void create(Usuario usuario){
		usuarioRepository.save(usuario);
	}
	public void delete(Usuario usuario){usuarioRepository.delete(usuario);}
	public void update(Usuario usuario){usuarioRepository.save(usuario);}
	public Optional<Usuario> findById(Integer IdUsuario){return usuarioRepository.findById(IdUsuario);}
	public List<Usuario> findAll(){return usuarioRepository.findAll();}
}
