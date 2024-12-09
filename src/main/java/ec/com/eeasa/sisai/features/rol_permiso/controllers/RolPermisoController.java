package ec.com.eeasa.sisai.features.rol_permiso.controllers;

import ec.com.eeasa.sisai.features.rol_permiso.dtos.ActualizarRolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.dtos.CrearRolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.dtos.FiltroRolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.dtos.RolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.services.RolPermisoService;
import ec.com.eeasa.sisai.shared.utils.GeneradorRespuesta;
import ec.com.eeasa.sisai.shared.models.RespuestaGenerica;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rol-permisos")
@RequiredArgsConstructor
@Validated
@Tag(name = "Rol - Permisos", description = "API para gestionar los roles y permisos")
public class RolPermisoController {

        private final RolPermisoService rolPermisoService;
        private final GeneradorRespuesta generadorRespuesta;

        @PreAuthorize("hasPermission(@recursoPermiso.ROL_PERMISO, @accionPermiso.LEER)")
        @GetMapping
        @Operation(summary = "Listar Roles - Permisos", description = "Obtiene todos los Rol - Permisos registrados en el sistema")
        public ResponseEntity<RespuestaGenerica<RolPermisoDto>> getAll(
                        @ParameterObject FiltroRolPermisoDto filtro) {
                Page<RolPermisoDto> rolPermisoDtos = rolPermisoService.encontrarTodos(filtro);
                return generadorRespuesta.buildPagedResponse(
                                rolPermisoDtos,
                                "Roles - Permisos obtenidos correctamente");
        }

        @PreAuthorize("hasPermission(@recursoPermiso.ROL_PERMISO, @accionPermiso.LEER)")
        @GetMapping("/{id}")
        @Operation(summary = "Obtener Rol - Permiso por ID", description = "Obtiene un Rol - Permiso específico por su identificador")
        public ResponseEntity<RespuestaGenerica<RolPermisoDto>> getById(
                        @Parameter(description = "ID del rol - permiso", required = true) @PathVariable("id") Long id) {
                return generadorRespuesta.buildResponse(
                                rolPermisoService.encontrarPorId(id),
                                HttpStatus.OK.value(),
                                "Rol - Permiso obtenido correctamente");
        }

        @PreAuthorize("hasPermission(@recursoPermiso.ROL_PERMISO, @accionPermiso.CREAR)")
        @PostMapping
        @Operation(summary = "Crear Rol - Permiso", description = "Crea un nuevo Rol - Permiso en el sistema")
        public ResponseEntity<RespuestaGenerica<List<RolPermisoDto>>> create(
                        @Valid @RequestBody CrearRolPermisoDto dto) {
                return generadorRespuesta.buildResponse(
                                rolPermisoService.crear(dto),
                                HttpStatus.CREATED.value(),
                                "Rol - Permiso creado correctamente");
        }

        @PreAuthorize("hasPermission(@recursoPermiso.ROL_PERMISO, @accionPermiso.ACTUALIZAR)")
        @PutMapping
        @Operation(summary = "Actualizar Rol - Permiso", description = "Actualiza un Rol - Permiso existente por su ID")
        public ResponseEntity<RespuestaGenerica<List<RolPermisoDto>>> update(
                        @RequestBody @Valid ActualizarRolPermisoDto dto) {
                return generadorRespuesta.buildResponse(
                                rolPermisoService.actualizar(dto),
                                HttpStatus.OK.value(),
                                "Rol - Permiso actualizado correctamente");
        }

        @PreAuthorize("hasPermission(@recursoPermiso.ROL_PERMISO, @accionPermiso.ELIMINAR)")
        @DeleteMapping("/{id}")
        @Operation(summary = "Eliminar Rol - Permiso", description = "Elimina un Rol - Permiso del sistema por su ID")
        public ResponseEntity<RespuestaGenerica<Boolean>> delete(
                        @Parameter(description = "ID del Rol - Permiso", required = true) @PathVariable("id") Long id) {
                return generadorRespuesta.buildResponse(
                                rolPermisoService.eliminar(id),
                                HttpStatus.OK.value(),
                                "Rol - Permiso eliminado correctamente");
        }

}
