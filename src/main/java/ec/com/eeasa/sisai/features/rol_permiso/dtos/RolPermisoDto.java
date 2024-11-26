package ec.com.eeasa.sisai.features.rol_permiso.dtos;

import ec.com.eeasa.sisai.features.permisos.dtos.PermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.entities.RolPermiso;
import ec.com.eeasa.sisai.features.roles.dtos.RolDto;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link RolPermiso}
 */
@Data
public class RolPermisoDto implements Serializable {
    Long id;
    RolDto rol;
    PermisoDto permiso;
}