package pe.isil.mghHoteles.service;

import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Alojamiento;

import java.util.ArrayList;
import java.util.List;


@Service
public class AlojamientoService implements BasicCrud<Alojamiento, Integer> {

    List<Alojamiento> alojamientos = new ArrayList<>();

    @Override
    public void create(Alojamiento alojamiento) {
        alojamientos.add(alojamiento);
    }

    @Override
    public Alojamiento update(Alojamiento alojamientoUpdated) {
        Alojamiento currentAlojamiento = findById(alojamientoUpdated.getIdAlojamiento());
        int index = alojamientos.indexOf(currentAlojamiento);
        alojamientos.set(index, alojamientoUpdated);
        return alojamientoUpdated;
    }

    @Override
    public void delete(Alojamiento alojamiento) {
        alojamientos.remove(alojamiento);
    }

    @Override
    public List<Alojamiento> findAll() {
        return alojamientos;
    }

    @Override
    public Alojamiento findById(Integer idalojamiento) {
        Alojamiento habitacion = alojamientos.stream()
                .filter(e -> idalojamiento.equals(e.getIdAlojamiento()))
                .findFirst()
                .orElseGet(null);

        return habitacion;
    }
}
