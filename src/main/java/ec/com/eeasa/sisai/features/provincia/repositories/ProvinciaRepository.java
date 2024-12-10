package ec.com.eeasa.sisai.features.provincia.repositories;

import ec.com.eeasa.sisai.features.provincia.entities.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long>, JpaSpecificationExecutor<Provincia> {
}