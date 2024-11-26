package ec.com.eeasa.sisai.features.roles.dtos;

import ec.com.eeasa.sisai.features.roles.entities.Rol;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link Rol}
 */
@Data
public class RolDto implements Serializable {
    Long id;
    String descripcion;
}