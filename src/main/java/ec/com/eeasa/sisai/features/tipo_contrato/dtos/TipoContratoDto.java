package ec.com.eeasa.sisai.features.tipo_contrato.dtos;

import java.math.BigDecimal;

/**
 * DTO for
 * {@link ec.com.eeasa.sisai.features.tipo_contrato.entities.TipoContrato}
 */
public class TipoContratoDto {
    Long id;
    String nombre;
    String descripcion;
    BigDecimal valorUnitario;
}