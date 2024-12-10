package ec.com.eeasa.sisai.features.permisos.dtos;

import ec.com.eeasa.sisai.shared.models.FiltroBase;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FiltroPermisoDto extends FiltroBase {
    @Parameter(description = "Recurso del permiso")
    private String recurso;

    @Parameter(description = "Acción del permiso")
    private String accion;

    @Parameter(description = "Descripción del permiso")
    private String descripcion;
}
