package ec.com.eeasa.sisai.features.permisos.repositories;

import ec.com.eeasa.sisai.features.permisos.entities.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PermisoRepository extends JpaRepository<Permiso, Long>, JpaSpecificationExecutor<Permiso> {
    List<Permiso> findByRolPermisos_Rol_Id(Long id);
}