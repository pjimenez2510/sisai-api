package ec.com.eeasa.sisai.features.rol_permiso.mappers;

import ec.com.eeasa.sisai.features.permisos.mappers.PermisoMapper;
import ec.com.eeasa.sisai.features.permisos.services.impl.PermisoServiceImpl;
import ec.com.eeasa.sisai.features.rol_permiso.dtos.ActualizarRolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.dtos.CrearRolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.dtos.RolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.entities.RolPermiso;
import ec.com.eeasa.sisai.features.roles.RolService;
import ec.com.eeasa.sisai.features.roles.mappers.RolMapper;
import ec.com.eeasa.sisai.shared.interfaces.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class RolPermisoMapper
        implements Mapper<RolPermiso, RolPermisoDto, CrearRolPermisoDto, ActualizarRolPermisoDto> {

    private final RolService rolService;
    private final PermisoServiceImpl permisoService;
    private final RolMapper rolMapper;
    private final PermisoMapper permisoMapper;

    @Override
    public RolPermiso toEntity(CrearRolPermisoDto crearRolPermisoDto) {
        return null;
    }

    public List<RolPermiso> toEntity(List<Long> permisoIds, Long rolId) {
        List<RolPermiso> rolPermisos = new ArrayList<>();
        for (Long permisoId : permisoIds) {
            RolPermiso rolPermiso = new RolPermiso();
            rolPermiso.setRol(rolService.encontrarPorIdEntity(rolId));
            rolPermiso.setPermiso(permisoService.encontrarPorIdEntity(permisoId));
            rolPermisos.add(rolPermiso);
        }
        return rolPermisos;
    }

    @Override
    public RolPermisoDto toDTO(RolPermiso rolPermiso) {
        RolPermisoDto rolPermisoDto = new RolPermisoDto();
        rolPermisoDto.setId(rolPermiso.getId());
        rolPermisoDto.setRol(rolMapper.toDTO(rolPermiso.getRol()));
        rolPermisoDto.setPermiso(permisoMapper.toDTO(rolPermiso.getPermiso()));
        return rolPermisoDto;
    }

    @Override
    public void updateEntity(RolPermiso rolPermiso, ActualizarRolPermisoDto actualizarRolPermisoDto) {
    }

    public void updateEntity(List<RolPermiso> rolPermisos, ActualizarRolPermisoDto actualizarRolPermisoDto) {
        for (RolPermiso rolPermiso : rolPermisos) {
            rolPermiso.setRol(rolService.encontrarPorIdEntity(actualizarRolPermisoDto.getRolId()));
        }
    }

    @Override
    public List<RolPermisoDto> toDTOList(List<RolPermiso> rolPermisos) {
        return rolPermisos.stream().map(this::toDTO).collect(Collectors.toList());
    }

}
