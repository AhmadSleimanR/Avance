package pe.isil.mghHoteles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Pago;
import pe.isil.mghHoteles.repository.PagoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {
	@Autowired
	private PagoRepository pagoRepository;

	public void create(Pago pago){
		pagoRepository.save(pago);
	}
	public void delete(Pago pago){pagoRepository.delete(pago);}
	public void update(Pago pago){pagoRepository.save(pago);}
	public Optional<Pago> findById(Integer IdPago){return pagoRepository.findById(IdPago);}
	public List<Pago> findAll(){return pagoRepository.findAll();}
}
