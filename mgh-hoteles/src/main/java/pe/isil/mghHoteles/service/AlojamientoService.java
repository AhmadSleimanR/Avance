package pe.isil.mghHoteles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Alojamiento;
import pe.isil.mghHoteles.repository.AlojamientoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlojamientoService implements BasicCrud<Alojamiento, Integer>{
	@Autowired
	private AlojamientoRepository alojamientoRepository;
	@Override
	public void create(Alojamiento alojamiento){
		alojamientoRepository.save(alojamiento);
	}
	@Override
	public void delete(Alojamiento alojamiento){alojamientoRepository.delete(alojamiento);}
	@Override
	public Alojamiento update(Alojamiento alojamiento){return alojamientoRepository.save(alojamiento);}
	@Override
	public Optional<Alojamiento> findById(Integer IdAlojamiento){return alojamientoRepository.findById(IdAlojamiento);}
	@Override
	public List<Alojamiento> findAll(){return alojamientoRepository.findAll();}
}
