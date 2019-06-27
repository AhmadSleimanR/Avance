package pe.isil.mghHoteles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Reserva;
import pe.isil.mghHoteles.repository.ReservaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService implements BasicCrud<Reserva, Integer>{
	@Autowired
	private ReservaRepository ReservaRepository;
	@Override
	public void create(Reserva Reserva){
		ReservaRepository.save(Reserva);
	}
	@Override
	public void delete(Reserva Reserva){ReservaRepository.delete(Reserva);}
	@Override
	public Reserva update(Reserva Reserva){return ReservaRepository.save(Reserva);}
	@Override
	public Optional<Reserva> findById(Integer IdReserva){return ReservaRepository.findById(IdReserva);}
	@Override
	public List<Reserva> findAll(){return ReservaRepository.findAll();}
}
