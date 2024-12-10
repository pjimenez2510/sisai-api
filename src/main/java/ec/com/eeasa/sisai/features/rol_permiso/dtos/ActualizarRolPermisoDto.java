package ec.com.eeasa.sisai.features.rol_permiso.dtos;

import ec.com.eeasa.sisai.features.rol_permiso.entities.RolPermiso;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * DTO for {@link RolPermiso}
 */
@Value
public class ActualizarRolPermisoDto implements Serializable {
    @NotEmpty(message = "La lista de permisos no puede estar vacía")
    @Size(min = 1, message = "Debe seleccionar al menos un permiso")
    private List<@NotNull(message = "Los IDs de permisos no pueden ser nulos") Long> rolPermisoIds;

    @NotNull(message = "El ID del rol es requerido")
    @Positive(message = "El ID del rol debe ser un número positivo")
    private Long rolId;
}