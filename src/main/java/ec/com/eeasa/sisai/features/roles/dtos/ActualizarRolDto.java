package ec.com.eeasa.sisai.features.roles.dtos;

import ec.com.eeasa.sisai.features.roles.entities.Rol;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * DTO for {@link Rol}
 */
@Value
public class ActualizarRolDto implements Serializable {
    @NotNull(message = "El rol es requerido")
    @Size(message = "El rol debe tener entre 3 y 50 caracteres", min = 3, max = 50)
    @NotBlank(message = "El rol no debe estar en blanco")
    String descripcion;
}