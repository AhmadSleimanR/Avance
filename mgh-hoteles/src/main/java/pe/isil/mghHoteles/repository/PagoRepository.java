package pe.isil.mghHoteles.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.mghHoteles.model.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
}
