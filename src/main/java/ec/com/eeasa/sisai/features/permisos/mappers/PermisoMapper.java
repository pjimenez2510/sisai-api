package ec.com.eeasa.sisai.features.permisos.mappers;

import ec.com.eeasa.sisai.features.permisos.dtos.CrearPermisoDto;
import ec.com.eeasa.sisai.features.permisos.dtos.PermisoDto;
import ec.com.eeasa.sisai.features.permisos.dtos.ActualizarPermisoDto;
import ec.com.eeasa.sisai.features.permisos.entities.Permiso;
import ec.com.eeasa.sisai.shared.interfaces.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PermisoMapper implements Mapper<Permiso, PermisoDto, CrearPermisoDto, ActualizarPermisoDto> {

    @Override
    public Permiso toEntity(CrearPermisoDto crearPermisoDto) {
        Permiso permiso = new Permiso();
        permiso.setRecurso(crearPermisoDto.getRecurso());
        permiso.setAccion(crearPermisoDto.getAccion());
        permiso.setDescripcion(crearPermisoDto.getDescripcion());
        return permiso;
    }

    @Override
    public PermisoDto toDTO(Permiso permiso) {
        PermisoDto permisoDto = new PermisoDto();
        permisoDto.setId(permiso.getId());
        permisoDto.setRecurso(permiso.getRecurso());
        permisoDto.setAccion(permiso.getAccion());
        permisoDto.setDescripcion(permiso.getDescripcion());
        return permisoDto;
    }

    @Override
    public void updateEntity(Permiso permiso, ActualizarPermisoDto actualizarPermisoDto) {
        Optional.ofNullable(actualizarPermisoDto.getRecurso())
                .ifPresent(permiso::setRecurso);
        Optional.ofNullable(actualizarPermisoDto.getAccion())
                .ifPresent(permiso::setAccion);
        Optional.ofNullable(actualizarPermisoDto.getDescripcion())
                .ifPresent(permiso::setDescripcion);
    }

    @Override
    public List<PermisoDto> toDTOList(List<Permiso> permisos) {
        return permisos.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
