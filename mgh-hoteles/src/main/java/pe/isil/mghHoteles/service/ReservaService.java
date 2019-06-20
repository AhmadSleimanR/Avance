package pe.isil.mghHoteles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Reserva;
import pe.isil.mghHoteles.repository.ReservaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
	@Autowired
	private ReservaRepository ReservaRepository;

	public void create(Reserva Reserva){
		ReservaRepository.save(Reserva);
	}
	public void delete(Reserva Reserva){ReservaRepository.delete(Reserva);}
	public void update(Reserva Reserva){ReservaRepository.save(Reserva);}
	public Optional<Reserva> findById(Integer IdReserva){return ReservaRepository.findById(IdReserva);}
	public List<Reserva> findAll(){return ReservaRepository.findAll();}
}
