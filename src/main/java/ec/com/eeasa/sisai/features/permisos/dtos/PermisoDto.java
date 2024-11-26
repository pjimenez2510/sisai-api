package ec.com.eeasa.sisai.features.permisos.dtos;

import ec.com.eeasa.sisai.features.permisos.entities.Permiso;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link Permiso}
 */
@Data
public class PermisoDto implements Serializable {
    Long id;
    String recurso;
    String accion;
    String descripcion;
}