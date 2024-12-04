package ec.com.eeasa.sisai.features.tipo_contrato.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.com.eeasa.sisai.features.auditoria.anotaciones.Auditable;
import ec.com.eeasa.sisai.features.auditoria.constantes.Operaciones;
import ec.com.eeasa.sisai.features.auditoria.constantes.Tablas;
import ec.com.eeasa.sisai.features.tipo_contrato.dtos.ActualizarTipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.dtos.CrearTipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.dtos.FiltroTipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.dtos.TipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.entities.TipoContrato;
import ec.com.eeasa.sisai.features.tipo_contrato.helpers.EspecificacionTipoContrato;
import ec.com.eeasa.sisai.features.tipo_contrato.mappers.TipoContratoMapper;
import ec.com.eeasa.sisai.features.tipo_contrato.repositories.TipoContratoRepository;
import ec.com.eeasa.sisai.features.tipo_contrato.services.TipoContratoService;
import ec.com.eeasa.sisai.shared.constantes.Estado;
import ec.com.eeasa.sisai.shared.excepciones.RecursoNoEncontrado;
import ec.com.eeasa.sisai.utils.PaginacionUtils;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoContratoServiceImpl implements TipoContratoService {

    private final TipoContratoRepository tipoContratoRepository;
    private final TipoContratoMapper tipoContratoMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<TipoContratoDto> encontrarTodos(FiltroTipoContratoDto filtro) {
        Specification<TipoContrato> spec = new EspecificacionTipoContrato(filtro);
        return tipoContratoRepository.findAll(spec, PaginacionUtils.crearPageRequest(filtro))
                .map(tipoContratoMapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public TipoContratoDto encontrarPorId(Long id) {
        return tipoContratoMapper.toDTO(encontrarPorIdEntity(id));

    }

    @Override
    @Transactional(readOnly = true)
    public TipoContrato encontrarPorIdEntity(Long id) {
        return tipoContratoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Tipo contrato", "id", id.toString()));
    }

    @Override
    @Transactional
    @Auditable(tabla = Tablas.TIPO_CONTRATO, operacion = Operaciones.CREAR)
    public TipoContratoDto crear(CrearTipoContratoDto dto) {
        TipoContrato tipoContrato = tipoContratoMapper.toEntity(dto);
        return tipoContratoMapper.toDTO(tipoContratoRepository.save(tipoContrato));
    }

    @Override
    @Transactional
    @Auditable(tabla = Tablas.TIPO_CONTRATO, operacion = Operaciones.ACTUALIZAR)
    public TipoContratoDto actualizar(Long id, ActualizarTipoContratoDto dto) {
        TipoContrato tipoContrato = encontrarPorIdEntity(id);
        tipoContratoMapper.updateEntity(tipoContrato, dto);
        return tipoContratoMapper.toDTO(tipoContratoRepository.save(tipoContrato));
    }

    @Override
    @Transactional
    @Auditable(tabla = Tablas.TIPO_CONTRATO, operacion = Operaciones.ELIMINAR)
    public boolean eliminar(Long id) {
        TipoContrato tipoContrato = encontrarPorIdEntity(id);
        tipoContrato.setActivo(Estado.INACTIVO);
        TipoContrato inactivo = tipoContratoRepository.save(tipoContrato);
        return inactivo.getActivo() == Estado.INACTIVO;
    }

}
