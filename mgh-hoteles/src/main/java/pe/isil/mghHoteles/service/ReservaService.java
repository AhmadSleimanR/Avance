package pe.isil.mghHoteles.service;

import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Reserva;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReservaService implements BasicCrud<Reserva, Integer> {

    List<Reserva> reservas = new ArrayList<>();

    @Override
    public void create(Reserva reserva) { reservas.add(reserva);
    }

    @Override
    public Reserva update(Reserva reservaUpdated) {
        Reserva currentReserva = findById(reservaUpdated.getIdReserva());
        int index = reservas.indexOf(currentReserva);
        reservas.set(index, reservaUpdated);
        return reservaUpdated;
    }

    @Override
    public void delete(Reserva reserva) {
        reservas.remove(reserva);
    }

    @Override
    public List<Reserva> findAll() {
        return reservas;
    }

    @Override
    public Reserva findById(Integer idreserva) {
        Reserva reserva = reservas.stream()
                .filter(e -> idreserva.equals(e.getIdReserva()))
                .findFirst()
                .orElseGet(null);

        return reserva;
    }
}


