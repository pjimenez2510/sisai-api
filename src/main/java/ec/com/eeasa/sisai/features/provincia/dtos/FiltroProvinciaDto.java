package ec.com.eeasa.sisai.features.provincia.dtos;

import ec.com.eeasa.sisai.shared.models.FiltroBase;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FiltroProvinciaDto extends FiltroBase {
    @Parameter(description = "Nombre de la provincia")
    private String nombre;

    @Parameter(description = "Estado (ACTIVO, INACTIVO)")
    private String estado;
}
