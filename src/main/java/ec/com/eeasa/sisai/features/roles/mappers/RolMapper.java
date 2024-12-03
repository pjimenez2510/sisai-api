package ec.com.eeasa.sisai.features.roles.mappers;

import ec.com.eeasa.sisai.features.roles.dtos.ActualizarRolDto;
import ec.com.eeasa.sisai.features.roles.dtos.CrearRolDto;
import ec.com.eeasa.sisai.features.roles.dtos.RolDto;
import ec.com.eeasa.sisai.features.roles.entities.Rol;
import ec.com.eeasa.sisai.shared.constantes.Estado;
import ec.com.eeasa.sisai.shared.interfaces.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RolMapper implements Mapper<Rol, RolDto, CrearRolDto, ActualizarRolDto> {

    @Override
    public Rol toEntity(CrearRolDto crearRolDto) {
        Rol rol = new Rol();
        rol.setDescripcion(crearRolDto.getDescripcion());
        rol.setActivo(Estado.ACTIVO);
        return rol;
    }

    @Override
    public RolDto toDTO(Rol rol) {
        RolDto rolDto = new RolDto();
        rolDto.setId(rol.getId());
        rolDto.setDescripcion(rol.getDescripcion());
        return rolDto;
    }

    @Override
    public void updateEntity(Rol rol, ActualizarRolDto actualizarRolDto) {
        Optional.ofNullable(actualizarRolDto.getDescripcion()).ifPresent(rol::setDescripcion);
    }

    @Override
    public List<RolDto> toDTOList(List<Rol> roles) {
        return roles.stream().map(this::toDTO).collect(Collectors.toList());
    }

}
