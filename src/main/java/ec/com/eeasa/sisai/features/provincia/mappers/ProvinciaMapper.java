package ec.com.eeasa.sisai.features.provincia.mappers;

import ec.com.eeasa.sisai.features.provincia.dtos.ActualizarProvinciaDto;
import ec.com.eeasa.sisai.features.provincia.dtos.CrearProvinciaDto;
import ec.com.eeasa.sisai.features.provincia.dtos.ProvinciaDto;
import ec.com.eeasa.sisai.features.provincia.entities.Provincia;
import ec.com.eeasa.sisai.shared.constantes.Estado;
import ec.com.eeasa.sisai.shared.interfaces.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProvinciaMapper implements Mapper<Provincia, ProvinciaDto, CrearProvinciaDto, ActualizarProvinciaDto> {
    @Override
    public Provincia toEntity(CrearProvinciaDto crearProvinciaDto) {
        Provincia provincia = new Provincia();
        provincia.setNombre(crearProvinciaDto.getNombre());
        provincia.setDescripcion(crearProvinciaDto.getDescripcion());
        provincia.setActivo(Estado.ACTIVO);
        return provincia;
    }

    @Override
    public ProvinciaDto toDTO(Provincia provincia) {
        return new ProvinciaDto(provincia.getId(), provincia.getNombre(), provincia.getDescripcion());
    }

    @Override
    public void updateEntity(Provincia provincia, ActualizarProvinciaDto actualizarProvinciaDto) {
        Optional.ofNullable(actualizarProvinciaDto.getNombre()).ifPresent(provincia::setNombre);
        Optional.ofNullable(actualizarProvinciaDto.getDescripcion()).ifPresent(provincia::setDescripcion);
    }

    @Override
    public List<ProvinciaDto> toDTOList(List<Provincia> provincias) {
        return provincias.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
