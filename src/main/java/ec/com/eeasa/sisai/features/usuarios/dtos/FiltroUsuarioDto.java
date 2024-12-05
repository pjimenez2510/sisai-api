package ec.com.eeasa.sisai.features.usuarios.dtos;

import ec.com.eeasa.sisai.shared.models.FiltroBase;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FiltroUsuarioDto extends FiltroBase {
    @Parameter(description = "Nombre del usuario")
    private String nombres;

    @Parameter(description = "Apellido del usuario")
    private String apellidos;

    @Parameter(description = "Cedula del usuario")
    private String cedula;

    @Parameter(description = "Nombre de usuario")
    private String nombreUsuario;

    @Parameter(description = "Correo electronico del usuario")
    private String email;

    @Parameter(description = "Codigo unico del usuario")
    private String codigoUnico;

    @Parameter(description = "Seccion del usuario")
    private String seccion;

    @Parameter(description = "Departamento del usuario")
    private String departamento;
}
