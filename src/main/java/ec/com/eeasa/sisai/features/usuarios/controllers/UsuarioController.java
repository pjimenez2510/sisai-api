package ec.com.eeasa.sisai.features.usuarios.controllers;

import ec.com.eeasa.sisai.features.usuarios.services.UsuarioService;
import ec.com.eeasa.sisai.features.usuarios.dtos.ActualizarUsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.dtos.CrearUsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.dtos.FiltroUsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.dtos.UsuarioDto;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
@Validated
@Tag(name = "Usuarios", description = "API para gestionar los usuarios")
public class UsuarioController {

        private final UsuarioService usuarioService;
        private final GeneradorRespuesta generadorRespuesta;

        @PreAuthorize("hasPermission('USUARIOS', 'LEER')")
        @GetMapping
        @Operation(summary = "Listar usuarios", description = "Obtiene todos los usuarios registrados en el sistema")
        public ResponseEntity<RespuestaGenerica<UsuarioDto>> getAll(
                        @ParameterObject FiltroUsuarioDto filtro) {
                Page<UsuarioDto> usuarioDtos = usuarioService.encontrarTodos(filtro);
                return generadorRespuesta.buildPagedResponse(
                                usuarioDtos,
                                "Usuarios obtenidos correctamente");

        }

        @PreAuthorize("hasPermission('USUARIOS', 'LEER')")
        @GetMapping("/{id}")
        @Operation(summary = "Obtener usuario por ID", description = "Obtiene un usuario específico por su identificador")
        public ResponseEntity<RespuestaGenerica<UsuarioDto>> getById(
                        @Parameter(description = "ID del usuario", required = true) @PathVariable("id") Long id) {
                return generadorRespuesta.buildResponse(
                                usuarioService.encontrarPorId(id),
                                HttpStatus.OK.value(),
                                "Usuario obtenido correctamente");
        }

        @PreAuthorize("hasPermission('USUARIOS', 'CREAR')")
        @PostMapping
        @Operation(summary = "Crear usuario", description = "Crea un nuevo usuario en el sistema")
        public ResponseEntity<RespuestaGenerica<UsuarioDto>> create(
                        @Valid @RequestBody CrearUsuarioDto dto) {
                return generadorRespuesta.buildResponse(
                                usuarioService.crear(dto),
                                HttpStatus.CREATED.value(),
                                "Usuario creado correctamente");
        }

        @PreAuthorize("hasPermission('USUARIOS', 'ACTUALIZAR')")
        @PutMapping("/{id}")
        @Operation(summary = "Actualizar usuario", description = "Actualiza un usuario existente por su ID")
        public ResponseEntity<RespuestaGenerica<UsuarioDto>> update(
                        @Parameter(description = "ID del usuario", required = true) @PathVariable("id") Long id,
                        @RequestBody @Valid ActualizarUsuarioDto dto) {
                return generadorRespuesta.buildResponse(
                                usuarioService.actualizar(id, dto),
                                HttpStatus.OK.value(),
                                "Usuario actualizado correctamente");
        }

        @DeleteMapping("/{id}")
        @Operation(summary = "Eliminar usuario", description = "Elimina un usuario del sistema por su ID")
        public ResponseEntity<RespuestaGenerica<Boolean>> delete(
                        @Parameter(description = "ID del usuario", required = true) @PathVariable("id") Long id) {
                return generadorRespuesta.buildResponse(
                                usuarioService.eliminar(id),
                                HttpStatus.OK.value(),
                                "Usuario eliminado correctamente");
        }

}
