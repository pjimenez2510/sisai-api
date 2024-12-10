package ec.com.eeasa.sisai.features.tipo_contrato_permiso.repositories;

import ec.com.eeasa.sisai.features.tipo_contrato_permiso.entities.TipoContratoPermiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipoContratoPermisoRepository extends JpaRepository<TipoContratoPermiso, Long>, JpaSpecificationExecutor<TipoContratoPermiso> {
    boolean existsByCodigoTipoContrato_Id(Long id);
}