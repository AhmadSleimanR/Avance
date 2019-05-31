package pe.isil.mghHoteles.service;

import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Habitacion;

import java.util.ArrayList;
import java.util.List;

@Service
public class HabitacionService implements BasicCrud<Habitacion, Integer> {

    List<Habitacion> habitaciones = new ArrayList<>();

    @Override
    public void create(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    @Override
    public Habitacion update(Habitacion habitacionUpdated) {
        Habitacion currentHabitacion = findById(habitacionUpdated.getIdHabitacion());
        int index = habitaciones.indexOf(currentHabitacion);
        habitaciones.set(index, habitacionUpdated);
        return habitacionUpdated;
    }

    @Override
    public void delete(Habitacion habitacion) {
        habitaciones.remove(habitacion);
    }

    @Override
    public List<Habitacion> findAll() {
        return habitaciones;
    }

    @Override
    public Habitacion findById(Integer idhabitacion) {
        Habitacion habitacion = habitaciones.stream()
                .filter(e -> idhabitacion.equals(e.getIdHabitacion()))
                .findFirst()
                .orElseGet(null);

        return habitacion;
    }

}
