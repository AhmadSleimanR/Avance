package pe.isil.mghHoteles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Pago;
import pe.isil.mghHoteles.repository.PagoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService implements BasicCrud<Pago, Integer>{
	@Autowired
	private PagoRepository pagoRepository;
	@Override
	public void create(Pago pago){
		pagoRepository.save(pago);
	}
	@Override
	public void delete(Pago pago){pagoRepository.delete(pago);}
	@Override
	public Pago update(Pago pago){return pagoRepository.save(pago);}
	@Override
	public Optional<Pago> findById(Integer IdPago){return pagoRepository.findById(IdPago);}
	@Override
	public List<Pago> findAll(){return pagoRepository.findAll();}
}
