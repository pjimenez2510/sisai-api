package ec.com.eeasa.sisai.features.provincia.dtos;

import ec.com.eeasa.sisai.features.provincia.entities.Provincia;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * DTO for {@link Provincia}
 */
@Value
public class CrearProvinciaDto implements Serializable {
    @NotNull(message = "El nombre es requerido")
    @NotBlank(message = "El nombre no debe estar en blanco")
    @Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    String nombre;

    @NotBlank(message = "La descripcion no debe estar en blanco")
    @Size( max = 500, message = "La descripcion debe tener maximo 500 caracteres")
    String descripcion;
}