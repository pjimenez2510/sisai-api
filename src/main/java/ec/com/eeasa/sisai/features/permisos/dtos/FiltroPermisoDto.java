package ec.com.eeasa.sisai.features.permisos.dtos;

import ec.com.eeasa.sisai.shared.filtros.FiltroBase;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FiltroPermisoDto extends FiltroBase {
    @Parameter(description = "Recurso del permiso")
    private String recurso;

    @Parameter(description = "Accion del permiso")
    private String accion;

    @Parameter(description = "Descripcion del permiso")
    private String descripcion;
}
