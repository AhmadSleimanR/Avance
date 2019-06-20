package pe.isil.mghHoteles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Habitacion;
import pe.isil.mghHoteles.repository.HabitacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {
	@Autowired
	private HabitacionRepository habitacionRepository;

	public void create(Habitacion habitacion){
		habitacionRepository.save(habitacion);
	}
	public void delete(Habitacion habitacion){habitacionRepository.delete(habitacion);}
	public void update(Habitacion habitacion){habitacionRepository.save(habitacion);}
	public Optional<Habitacion> findById(Integer IdHabitacion){return habitacionRepository.findById(IdHabitacion);}
	public List<Habitacion> findAll(){return habitacionRepository.findAll();}
}
