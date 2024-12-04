package ec.com.eeasa.sisai.features.tipo_contrato.mappers;

import ec.com.eeasa.sisai.features.tipo_contrato.dtos.ActualizarTipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.dtos.CrearTipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.dtos.TipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.entities.TipoContrato;
import ec.com.eeasa.sisai.shared.constantes.Estado;
import ec.com.eeasa.sisai.shared.interfaces.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TipoContratoMapper
        implements Mapper<TipoContrato, TipoContratoDto, CrearTipoContratoDto, ActualizarTipoContratoDto> {

    @Override
    public TipoContrato toEntity(CrearTipoContratoDto dto) {
        TipoContrato contrato = new TipoContrato();
        contrato.setNombre(dto.getNombre());
        contrato.setValorUnitario(dto.getValorUnitario());
        contrato.setDescripcion(dto.getDescripcion());
        contrato.setActivo(Estado.ACTIVO);
        return contrato;
    }

    @Override
    public TipoContratoDto toDTO(TipoContrato entity) {
        TipoContratoDto contratoDto = new TipoContratoDto();
        contratoDto.setId(entity.getId());
        contratoDto.setNombre(entity.getNombre());
        contratoDto.setDescripcion(entity.getDescripcion());
        contratoDto.setValorUnitario(entity.getValorUnitario());
        return contratoDto;
    }

    @Override
    public void updateEntity(TipoContrato entity, ActualizarTipoContratoDto dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getValorUnitario()).ifPresent(entity::setValorUnitario);
    }

    @Override
    public List<TipoContratoDto> toDTOList(List<TipoContrato> entityList) {
        return entityList.stream().map(this::toDTO).collect(Collectors.toList());
    }

}
