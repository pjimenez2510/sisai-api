package ec.com.eeasa.sisai.features.roles;

import ec.com.eeasa.sisai.features.roles.dtos.ActualizarRolDto;
import ec.com.eeasa.sisai.features.roles.dtos.CrearRolDto;
import ec.com.eeasa.sisai.features.roles.dtos.FiltroRolDto;
import ec.com.eeasa.sisai.features.roles.dtos.RolDto;
import ec.com.eeasa.sisai.shared.respuesta.GeneradorRespuesta;
import ec.com.eeasa.sisai.shared.respuesta.RespuestaGenerica;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
@Validated
@Tag(name = "Roles", description = "API para gestionar los roles")
public class RolController {


    private final RolService rolService;
    private final GeneradorRespuesta generadorRespuesta;

    @GetMapping
    @Operation(summary = "Listar roles", description = "Obtiene todos los roles registrados en el sistema")
    public ResponseEntity<RespuestaGenerica<RolDto>> getAll(
            @ParameterObject FiltroRolDto filtroRolDto) {
        Page<RolDto> permisos = rolService.encontrarTodos(filtroRolDto);
        return generadorRespuesta.buildPagedResponse(
                permisos,
                "Roles obtenidos correctamente");

    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener rol por ID", description = "Obtiene un rol específico por su identificador")
    public ResponseEntity<RespuestaGenerica<RolDto>> getById(
            @Parameter(description = "ID del rol", required = true) @PathVariable("id") Long id) {
        return generadorRespuesta.buildResponse(
                rolService.encontrarPorId(id),
                HttpStatus.OK.value(),
                "Rol obtenido correctamente");
    }

    @PostMapping
    @Operation(summary = "Crear rol", description = "Crea un nuevo rol en el sistema")
    public ResponseEntity<RespuestaGenerica<RolDto>> create(
            @Valid @RequestBody CrearRolDto rolDto) {
        return generadorRespuesta.buildResponse(
                rolService.crear(rolDto),
                HttpStatus.CREATED.value(),
                "Rol creado correctamente");
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar rol", description = "Actualiza un rol existente por su ID")
    public ResponseEntity<RespuestaGenerica<RolDto>> update(
            @Parameter(description = "ID del rol", required = true) @PathVariable("id") Long id,
            @RequestBody @Valid ActualizarRolDto rolDto) {
        return generadorRespuesta.buildResponse(
                rolService.actualizar(id, rolDto),
                HttpStatus.OK.value(),
                "Rol actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar rol", description = "Elimina un rol del sistema por su ID")
    public ResponseEntity<RespuestaGenerica<Boolean>> delete(
            @Parameter(description = "ID del rol", required = true) @PathVariable("id") Long id) {
        return generadorRespuesta.buildResponse(
                rolService.eliminar(id),
                HttpStatus.OK.value(),
                "Rol eliminado correctamente");
    }

}
