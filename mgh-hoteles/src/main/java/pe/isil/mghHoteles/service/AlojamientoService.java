package pe.isil.mghHoteles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Alojamiento;
import pe.isil.mghHoteles.repository.AlojamientoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlojamientoService {
	@Autowired
	private AlojamientoRepository alojamientoRepository;

	public void create(Alojamiento alojamiento){
		alojamientoRepository.save(alojamiento);
	}
	public void delete(Alojamiento alojamiento){alojamientoRepository.delete(alojamiento);}
	public void update(Alojamiento alojamiento){alojamientoRepository.save(alojamiento);}
	public Optional<Alojamiento> findById(Integer IdAlojamiento){return alojamientoRepository.findById(IdAlojamiento);}
	public List<Alojamiento> findAll(){return alojamientoRepository.findAll();}
}
