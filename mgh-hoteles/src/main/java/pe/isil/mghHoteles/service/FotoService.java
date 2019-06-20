package pe.isil.mghHoteles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Foto;
import pe.isil.mghHoteles.repository.FotoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FotoService {
	@Autowired
	private FotoRepository fotoRepository;

	public void create(Foto foto){
		fotoRepository.save(foto);
	}
	public void delete(Foto foto){fotoRepository.delete(foto);}
	public void update(Foto foto){fotoRepository.save(foto);}
	public Optional<Foto> findById(Integer IdFoto){return fotoRepository.findById(IdFoto);}
	public List<Foto> findAll(){return fotoRepository.findAll();}
}
