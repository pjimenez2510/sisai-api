package ec.com.eeasa.sisai.features.tipo_contrato.dtos;

import ec.com.eeasa.sisai.shared.constantes.Estado;
import ec.com.eeasa.sisai.shared.filtros.FiltroBase;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FiltroTipoContratoDto extends FiltroBase {
    @Parameter(description = "Nombre del tipo de contrato")
    String nombre;

    @Parameter(description = "Estado del tipo de contrato (ACTIVO, INACTIVO)")
    String estado = Estado.ACTIVO;
}
