package ec.com.eeasa.sisai.features.roles.dtos;

import ec.com.eeasa.sisai.shared.filtros.FiltroBase;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FiltroRolDto extends FiltroBase {
    @Parameter(description = "Nombre del rol")
    String descripcion;
}
