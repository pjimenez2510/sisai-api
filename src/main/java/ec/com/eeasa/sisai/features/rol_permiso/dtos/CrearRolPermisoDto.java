package ec.com.eeasa.sisai.features.rol_permiso.dtos;

import ec.com.eeasa.sisai.features.rol_permiso.entities.RolPermiso;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link RolPermiso}
 */
@Data
public class CrearRolPermisoDto implements Serializable {
    List<Long> permisoIds;
    Long rolId;
}