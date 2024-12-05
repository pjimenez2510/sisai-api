package ec.com.eeasa.sisai.features.tipo_contrato.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ec.com.eeasa.sisai.features.tipo_contrato.dtos.ActualizarTipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.dtos.CrearTipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.dtos.FiltroTipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.dtos.TipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.services.TipoContratoService;
import ec.com.eeasa.sisai.shared.utils.GeneradorRespuesta;
import ec.com.eeasa.sisai.shared.models.RespuestaGenerica;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/tipo-contrato")
@RequiredArgsConstructor
@Validated
@Tag(name = "Tipo de contratos", description = "API para gestionar los tipos de contratos")
public class TipoContratoController {
    private final TipoContratoService service;
    private final GeneradorRespuesta generadorRespuesta;

    @PreAuthorize("hasPermission(@recursoPermiso.TIPO_CONTRATO, @accionPermiso.LEER)")
    @GetMapping
    @Operation(summary = "Listar tipos de contratos", description = "Obtiene todos los tipos de contratos registrados en el sistema")
    public ResponseEntity<RespuestaGenerica<TipoContratoDto>> getAll(
            @ParameterObject FiltroTipoContratoDto filtro) {
        Page<TipoContratoDto> permisos = service.encontrarTodos(filtro);
        return generadorRespuesta.buildPagedResponse(
                permisos,
                "Tipos de contratos obtenidos correctamente");
    }

    @PreAuthorize("hasPermission(@recursoPermiso.TIPO_CONTRATO, @accionPermiso.LEER)")
    @GetMapping("/{id}")
    @Operation(summary = "Obtener tipo de contrato por ID", description = "Obtiene un tipo de contrato específico por su identificador")
    public ResponseEntity<RespuestaGenerica<TipoContratoDto>> getById(
            @Parameter(description = "ID del tipo de contrato", required = true) @PathVariable("id") Long id) {
        return generadorRespuesta.buildResponse(
                service.encontrarPorId(id),
                HttpStatus.OK.value(),
                "Tipo de contrato obtenido correctamente");
    }

    @PreAuthorize("hasPermission(@recursoPermiso.TIPO_CONTRATO, @accionPermiso.CREAR)")
    @PostMapping
    @Operation(summary = "Crear tipo de contrato", description = "Crea un nuevo tipo de contrato en el sistema")
    public ResponseEntity<RespuestaGenerica<TipoContratoDto>> create(
            @Valid @RequestBody CrearTipoContratoDto dto) {
        return generadorRespuesta.buildResponse(
                service.crear(dto),
                HttpStatus.CREATED.value(),
                "Tipo de contrato creado correctamente");
    }

    @PreAuthorize("hasPermission(@recursoPermiso.TIPO_CONTRATO, @accionPermiso.ACTUALIZAR)")
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar tipo de contrato", description = "Actualiza un tipo de contrato existente por su ID")
    public ResponseEntity<RespuestaGenerica<TipoContratoDto>> update(
            @Parameter(description = "ID del tipo de contrato", required = true) @PathVariable("id") Long id,
            @RequestBody @Valid ActualizarTipoContratoDto dto) {
        return generadorRespuesta.buildResponse(
                service.actualizar(id, dto),
                HttpStatus.OK.value(),
                "Tipo de contrato actualizado correctamente");
    }

    @PreAuthorize("hasPermission(@recursoPermiso.TIPO_CONTRATO, @accionPermiso.ELIMINAR)")
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar tipo de contrato", description = "Elimina un tipo de contrato del sistema por su ID")
    public ResponseEntity<RespuestaGenerica<Boolean>> delete(
            @Parameter(description = "ID del tipo de contrato", required = true) @PathVariable("id") Long id) {
        return generadorRespuesta.buildResponse(
                service.eliminar(id),
                HttpStatus.OK.value(),
                "Tipo de contrato eliminado correctamente");
    }
}
