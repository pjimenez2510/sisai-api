package ec.com.eeasa.sisai.features.auditoria.repositories;

import ec.com.eeasa.sisai.features.auditoria.entities.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
}