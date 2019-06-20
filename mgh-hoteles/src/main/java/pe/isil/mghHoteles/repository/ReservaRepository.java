package pe.isil.mghHoteles.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.mghHoteles.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
