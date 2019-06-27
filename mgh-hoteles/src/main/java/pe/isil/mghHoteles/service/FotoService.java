package pe.isil.mghHoteles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Foto;
import pe.isil.mghHoteles.repository.FotoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FotoService implements BasicCrud<Foto, Integer>{
	@Autowired
	private FotoRepository fotoRepository;
	@Override
	public void create(Foto foto){
		fotoRepository.save(foto);
	}
	@Override
	public void delete(Foto foto){fotoRepository.delete(foto);}
	@Override
	public Foto update(Foto foto){return fotoRepository.save(foto);}
	@Override
	public Optional<Foto> findById(Integer IdFoto){return fotoRepository.findById(IdFoto);}
	@Override
	public List<Foto> findAll(){return fotoRepository.findAll();}
}
