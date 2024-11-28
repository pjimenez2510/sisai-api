package ec.com.eeasa.sisai.features.roles.repositories;

import ec.com.eeasa.sisai.features.roles.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RolRepository extends JpaRepository<Rol, Long>, JpaSpecificationExecutor<Rol> {
}