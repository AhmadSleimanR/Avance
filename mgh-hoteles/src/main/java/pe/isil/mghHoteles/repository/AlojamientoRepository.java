package pe.isil.mghHoteles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.mghHoteles.model.Alojamiento;

@Repository
public interface AlojamientoRepository extends JpaRepository<Alojamiento, Integer> {
}
