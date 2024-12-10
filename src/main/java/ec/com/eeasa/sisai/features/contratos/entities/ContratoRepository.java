package ec.com.eeasa.sisai.features.contratos.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContratoRepository extends JpaRepository<Contrato, Long>, JpaSpecificationExecutor<Contrato> {
  boolean existsByDictpCodigoTipoContrato_Id(Long id);

}