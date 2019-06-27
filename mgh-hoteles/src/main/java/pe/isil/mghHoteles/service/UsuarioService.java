package pe.isil.mghHoteles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Usuario;
import pe.isil.mghHoteles.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements BasicCrud<Usuario, Integer>{
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Override
	public void create(Usuario usuario){
		usuarioRepository.save(usuario);
	}
	@Override
	public void delete(Usuario usuario){usuarioRepository.delete(usuario);}
	@Override
	public Usuario update(Usuario usuario){return usuarioRepository.save(usuario);}
	@Override
	public Optional<Usuario> findById(Integer IdUsuario){return usuarioRepository.findById(IdUsuario);}
	@Override
	public List<Usuario> findAll(){return usuarioRepository.findAll();}
}
