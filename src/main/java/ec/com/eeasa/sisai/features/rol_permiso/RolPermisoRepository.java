package ec.com.eeasa.sisai.features.rol_permiso;

import ec.com.eeasa.sisai.features.rol_permiso.entities.RolPermiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RolPermisoRepository extends JpaRepository<RolPermiso, Long>, JpaSpecificationExecutor<RolPermiso> {
}