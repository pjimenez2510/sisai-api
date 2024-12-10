package ec.com.eeasa.sisai.features.usuarios.dtos;

import ec.com.eeasa.sisai.features.usuarios.entities.Usuario;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * DTO for {@link Usuario}
 */
@Data
public class CrearUsuarioDto implements Serializable {
    @NotNull(message = "El nombre es requerido")
    String nombres;

    @NotNull(message = "El apellido es requerido")
    String apellidos;

    @NotNull(message = "La cédula es requerida")
    String cedula;

    @NotNull(message = "El nombre de usuario es requerido")
    String nombreUsuario;

    @NotNull(message = "El email es requerido")
    String email;

    @NotNull(message = "El código único es requerido")
    String codigoUnico;

    @NotNull(message = "La sección es requerida")
    String seccion;

    @NotNull(message = "El departamento es requerido")
    String departamento;

    @NotNull(message = "El rol es requerido")
    Long rolId;
}