package ec.com.eeasa.sisai.features.rol_permiso;

import ec.com.eeasa.sisai.features.rol_permiso.dtos.ActualizarRolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.dtos.CrearRolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.dtos.FiltroRolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.dtos.RolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.entities.RolPermiso;
import ec.com.eeasa.sisai.features.rol_permiso.helpers.EspecificacionRolPermiso;
import ec.com.eeasa.sisai.features.rol_permiso.mappers.RolPermisoMapper;
import ec.com.eeasa.sisai.shared.excepciones.RecursoNoEncontrado;
import ec.com.eeasa.sisai.utils.PaginacionUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RolPermisoService {

    private final RolPermisoRepository rolPermisoRepository;
    private final RolPermisoMapper rolPermisoMapper;

    @Transactional(readOnly = true)
    public Page<RolPermisoDto> encontrarTodos(FiltroRolPermisoDto filtro) {
        Specification<RolPermiso> spec = new EspecificacionRolPermiso(filtro);
        return rolPermisoRepository.findAll(spec, PaginacionUtils.crearPageRequest(filtro))
                .map(rolPermisoMapper::toDTO);
    }

    @Transactional(readOnly = true)
    public RolPermisoDto encontrarPorId(Long id) {
        return rolPermisoMapper.toDTO(encontrarPorIdEntity(id));
    }

    @Transactional(readOnly = true)
    public RolPermiso encontrarPorIdEntity(Long id) {
        return rolPermisoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Rol - Permiso", "id", id.toString()));
    }

    @Transactional
    public List<RolPermisoDto> crear(CrearRolPermisoDto crearRolPermisoDto) {
        List<RolPermiso> rolPermisos = rolPermisoMapper.toEntity(crearRolPermisoDto.getPermisoIds(),
                crearRolPermisoDto.getRolId());
        return rolPermisoRepository.saveAll(rolPermisos).stream().map(rolPermisoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<RolPermisoDto> actualizar(ActualizarRolPermisoDto actualizarRolPermisoDto) {
        List<RolPermiso> rolPermisos = rolPermisoRepository.findAllById(actualizarRolPermisoDto.getRolPermisoIds());
        if (rolPermisos.isEmpty()) {
            throw new RecursoNoEncontrado(
                    "Roles - Permisos", "id", actualizarRolPermisoDto.getRolPermisoIds().toString());
        }
        rolPermisoMapper.updateEntity(rolPermisos, actualizarRolPermisoDto);
        return rolPermisoRepository.saveAll(rolPermisos).stream().map(rolPermisoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean eliminar(Long id) {
        RolPermiso rolPermiso = encontrarPorIdEntity(id);
        rolPermisoRepository.delete(rolPermiso);
        return true;
    }
}
