package pe.isil.mghHoteles.service;

import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Foto;
import pe.isil.mghHoteles.model.Foto;

import java.util.ArrayList;
import java.util.List;


@Service
public class FotoService implements BasicCrud<Foto, Integer> {

	List<Foto> fotos = new ArrayList<>();

	@Override
	public void create(Foto foto) {
		fotos.add(foto);
	}

	@Override
	public Foto update(Foto fotoUpdated) {
		Foto currentFoto = findById(fotoUpdated.getIdFoto());
		int index = fotos.indexOf(currentFoto);
		fotos.set(index, fotoUpdated);
		return fotoUpdated;
	}

	@Override
	public void delete(Foto foto) {
		fotos.remove(foto);
	}

	@Override
	public List<Foto> findAll() {
		return fotos;
	}

	@Override
	public Foto findById(Integer idfoto) {
		Foto habitacion = fotos.stream()
				.filter(e -> idfoto.equals(e.getIdFoto()))
				.findFirst()
				.orElseGet(null);

		return habitacion;
	}
}
