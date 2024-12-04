package ec.com.eeasa.sisai.features.tipo_contrato.repositories;

import ec.com.eeasa.sisai.features.tipo_contrato.entities.TipoContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipoContratoRepository extends JpaRepository<TipoContrato, Long>, JpaSpecificationExecutor<TipoContrato> {
}