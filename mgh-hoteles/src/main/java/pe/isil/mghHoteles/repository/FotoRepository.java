package pe.isil.mghHoteles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.mghHoteles.model.Foto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer> {
}
