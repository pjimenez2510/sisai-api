package ec.com.eeasa.sisai.features.operadoras.dtos;

import ec.com.eeasa.sisai.features.operadoras.entities.Operadora;
import ec.com.eeasa.sisai.shared.validaciones.CedulaEcuatoriana;
import ec.com.eeasa.sisai.shared.validaciones.TelefonoValido;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * DTO for {@link Operadora}
 */
@Value
public class CrearOperadoraDto implements Serializable {
    @NotNull(message = "El nombre es requerido requerido")
    @NotBlank(message = "El nombre no debe estar en blanco")
    @Size(min = 1, max = 100, message = "EL nombre debe tener entre 1 y 100 caracteres")
    String nombre;

    @NotNull(message = "El ruc es requerido requerido")
    @NotBlank(message = "El ruc no debe estar en blanco")
    @CedulaEcuatoriana(message = "El ruc no es valido")
    String ruc;

    @NotNull(message = "El teléfono es requerido")
    @TelefonoValido(message = "El teléfono no es valido")
    String telefono1;

    @TelefonoValido(message = "El teléfono no es valido")
    String telefono2;

    @NotNull(message = "La dirección es requerida requerido")
    @NotBlank(message = "La dirección no debe estar en blanco")
    @Size(min = 5, max = 250, message = "La dirección debe tener entre 1 y 250 caracteres")
    String direccion;

    String observacion;

    @NotNull(message = "El email es requerido")
    @Email(message = "Debe ser un email valido")
    String email;

    Set<CrearResponsableDto> responsables;
}