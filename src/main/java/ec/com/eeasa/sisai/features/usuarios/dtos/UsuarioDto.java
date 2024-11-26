package ec.com.eeasa.sisai.features.usuarios.dtos;

import ec.com.eeasa.sisai.features.roles.dtos.RolDto;
import ec.com.eeasa.sisai.features.usuarios.entities.Usuario;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link Usuario}
 */
@Data
public class UsuarioDto implements Serializable {
    Long id;
    String nombres;
    String apellidos;
    String cedula;
    String nombreUsuario;
    String email;
    String codigoUnico;
    String seccion;
    String departamento;
    RolDto rol;
}