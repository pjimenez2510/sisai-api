package ec.com.eeasa.sisai.features.permisos;

import ec.com.eeasa.sisai.features.permisos.dtos.CrearPermisoDto;
import ec.com.eeasa.sisai.features.permisos.dtos.FiltroPermisoDto;
import ec.com.eeasa.sisai.features.permisos.dtos.PermisoDto;
import ec.com.eeasa.sisai.features.permisos.dtos.ActualizarPermisoDto;
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
@RequestMapping("/api/v1/permisos")
@RequiredArgsConstructor
@Validated
@Tag(name = "Permisos", description = "API para gestionar los permisos de usuarios")
public class PermisoController {

        private final PermisoService permisoService;
        private final GeneradorRespuesta generadorRespuesta;

        @GetMapping
        @Operation(summary = "Listar permisos", description = "Obtiene todos los permisos registrados en el sistema")
        public ResponseEntity<RespuestaGenerica<PermisoDto>> getAll(
                        @ParameterObject FiltroPermisoDto filtroPermisoDto) {
                Page<PermisoDto> permisos = permisoService.encontrarTodos(filtroPermisoDto);
                return generadorRespuesta.buildPagedResponse(
                                permisos,
                                "Permisos obtenidos correctamente");

        }

        @GetMapping("/{id}")
        @Operation(summary = "Obtener permiso por ID", description = "Obtiene un permiso específico por su identificador")
        public ResponseEntity<RespuestaGenerica<PermisoDto>> getById(
                        @Parameter(description = "ID del permiso", required = true) @PathVariable("id") Long id) {
                return generadorRespuesta.buildResponse(
                                permisoService.encontrarPorId(id),
                                HttpStatus.OK.value(),
                                "Permiso obtenido correctamente");
        }

        @PostMapping
        @Operation(summary = "Crear permiso", description = "Crea un nuevo permiso en el sistema")
        public ResponseEntity<RespuestaGenerica<PermisoDto>> create(
                        @Valid @RequestBody CrearPermisoDto permiso) {
                return generadorRespuesta.buildResponse(
                                permisoService.crear(permiso),
                                HttpStatus.CREATED.value(),
                                "Permiso creado correctamente");
        }

        @PutMapping("/{id}")
        @Operation(summary = "Actualizar permiso", description = "Actualiza un permiso existente por su ID")
        public ResponseEntity<RespuestaGenerica<PermisoDto>> update(
                        @Parameter(description = "ID del permiso", required = true) @PathVariable("id") Long id,
                        @RequestBody @Valid ActualizarPermisoDto permiso) {
                return generadorRespuesta.buildResponse(
                                permisoService.actualizar(id, permiso),
                                HttpStatus.OK.value(),
                                "Permiso actualizado correctamente");
        }

        @DeleteMapping("/{id}")
        @Operation(summary = "Eliminar permiso", description = "Elimina un permiso del sistema por su ID")
        public ResponseEntity<RespuestaGenerica<Boolean>> delete(@PathVariable("id") Long id) {
                return generadorRespuesta.buildResponse(
                                permisoService.eliminar(id),
                                HttpStatus.OK.value(),
                                "Permiso eliminado correctamente");
        }
}