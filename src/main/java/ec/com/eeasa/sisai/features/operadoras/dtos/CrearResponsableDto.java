package ec.com.eeasa.sisai.features.operadoras.dtos;

import lombok.Value;

import javax.validation.constraints.*;

import ec.com.eeasa.sisai.features.operadoras.entities.Responsable;
import ec.com.eeasa.sisai.shared.validaciones.TelefonoValido;

import java.io.Serializable;

/**
 * DTO for {@link Responsable}
 */
@Value
public class CrearResponsableDto implements Serializable {

    @NotNull(message = "Los nombres son requeridos")
    @NotBlank(message = "Los nombres no deben estar en blanco")
    @Size(min = 1, max = 100, message = "Los nombres deben tener entre 1 y 100 caracteres")
    String nombres;

    @NotNull(message = "Los apellidos son requeridos")
    @NotBlank(message = "Los apellidos no deben estar en blanco")
    @Size(min = 1, max = 100, message = "Los apellidos deben tener entre 1 y 100 caracteres")
    String apellidos;

    @NotNull(message = "El email es requerido")
    @Email(message = "Debe ser un email valido")
    String email;

    @NotNull(message = "El teléfono es requerido")
    @TelefonoValido(message = "El teléfono no es valido")
    String telefono;
}