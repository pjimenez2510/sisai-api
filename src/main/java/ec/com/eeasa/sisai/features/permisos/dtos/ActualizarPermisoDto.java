package ec.com.eeasa.sisai.features.permisos.dtos;

import ec.com.eeasa.sisai.features.permisos.entities.Permiso;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * DTO for {@link Permiso}
 */
@Data
public class ActualizarPermisoDto implements Serializable {
    @NotNull(message = "El recurso es requerido")
    @NotBlank(message = "El recurso no debe estar en blanco")
    @Size(min = 1, max = 100, message = "El recurso debe tener entre 1 y 100 caracteres")
    String recurso;

    @NotNull(message = "La acción es requerida")
    @NotBlank(message = "La acción no debe estar en blanco")
    @Size(min = 1, max = 100, message = "La acción debe tener entre 1 y 100 caracteres")
    String accion;

    @NotNull(message = "La descripción es requerida")
    @NotBlank(message = "La descripción no debe estar en blanco")
    @Size(min = 1, max = 100, message = "La descripción debe tener entre 1 y 100 caracteres")
    String descripcion;
}