package ec.com.eeasa.sisai.features.tipo_contrato.services;

import org.springframework.data.domain.Page;

import ec.com.eeasa.sisai.features.tipo_contrato.dtos.ActualizarTipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.dtos.CrearTipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.dtos.FiltroTipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.dtos.TipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.entities.TipoContrato;

public interface TipoContratoService {
    Page<TipoContratoDto> encontrarTodos(FiltroTipoContratoDto filtro);

    TipoContratoDto encontrarPorId(Long id);

    TipoContrato encontrarPorIdEntity(Long id);

    TipoContratoDto crear(CrearTipoContratoDto dto);

    TipoContratoDto actualizar(Long id, ActualizarTipoContratoDto dto);

    boolean eliminar(Long id);
}
