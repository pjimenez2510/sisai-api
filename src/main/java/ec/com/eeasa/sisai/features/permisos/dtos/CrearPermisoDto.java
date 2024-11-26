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
public class CrearPermisoDto implements Serializable {
    @NotNull(message = "El recurso es requerido")
    @NotBlank(message = "El rucurso no debe estar en blanco")
    @Size(min = 1, max = 100, message = "El recurso debe tener entre 1 y 100 caracteres")
    String recurso;

    @NotNull(message = "La accion es requerida")
    @NotBlank(message = "La accion no debe estar en blanco")
    @Size(min = 1, max = 100, message = "La accion debe tener entre 1 y 100 caracteres")
    String accion;

    @NotNull(message = "La descripcion es requerida")
    @NotBlank(message = "La descripcion no debe estar en blanco")
    @Size(min = 1, max = 100, message = "La descripcion debe tener entre 1 y 100 caracteres")
    String descripcion;
}