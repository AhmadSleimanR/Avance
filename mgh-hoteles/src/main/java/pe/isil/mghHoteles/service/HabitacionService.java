package pe.isil.mghHoteles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Habitacion;
import pe.isil.mghHoteles.repository.HabitacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService implements BasicCrud<Habitacion, Integer>{
	@Autowired
	private HabitacionRepository habitacionRepository;
	@Override
	public void create(Habitacion habitacion){
		habitacionRepository.save(habitacion);
	}
	@Override
	public void delete(Habitacion habitacion){habitacionRepository.delete(habitacion);}
	@Override
	public Habitacion update(Habitacion habitacion){return habitacionRepository.save(habitacion);}
	@Override
	public Optional<Habitacion> findById(Integer IdHabitacion){return habitacionRepository.findById(IdHabitacion);}
	@Override
	public List<Habitacion> findAll(){return habitacionRepository.findAll();}
}
