package pe.isil.mghHoteles.service;

import org.springframework.stereotype.Service;
import pe.isil.mghHoteles.model.Pago;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagoService implements BasicCrud<Pago, Integer>{

    List<Pago> pagos = new ArrayList<>();

    @Override
    public void create(Pago pago) { pagos.add(pago);
    }

    @Override
    public Pago update(Pago pagoUpdated) {
        Pago currentPago = findById(pagoUpdated.getIdPago());
        int index = pagos.indexOf(currentPago);
        pagos.set(index, pagoUpdated);
        return pagoUpdated;
    }

    @Override
    public void delete(Pago pago) {
        pagos.remove(pago);
    }

    @Override
    public List<Pago> findAll() {
        return pagos;
    }

    @Override
    public Pago findById(Integer idpago) {
        Pago pago = pagos.stream()
                .filter(e -> idpago.equals(e.getIdPago()))
                .findFirst()
                .orElseGet(null);

        return pago;
    }
}

