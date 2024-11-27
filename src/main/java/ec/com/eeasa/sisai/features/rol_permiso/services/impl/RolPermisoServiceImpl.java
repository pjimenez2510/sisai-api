package ec.com.eeasa.sisai.features.rol_permiso.services.impl;

import ec.com.eeasa.sisai.features.rol_permiso.dtos.ActualizarRolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.dtos.CrearRolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.dtos.FiltroRolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.dtos.RolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.entities.RolPermiso;
import ec.com.eeasa.sisai.features.rol_permiso.helpers.EspecificacionRolPermiso;
import ec.com.eeasa.sisai.features.rol_permiso.mappers.RolPermisoMapper;
import ec.com.eeasa.sisai.features.rol_permiso.repositories.RolPermisoRepository;
import ec.com.eeasa.sisai.features.rol_permiso.services.RolPermisoService;
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
public class RolPermisoServiceImpl implements RolPermisoService {

    private final RolPermisoRepository rolPermisoRepository;
    private final RolPermisoMapper rolPermisoMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<RolPermisoDto> encontrarTodos(FiltroRolPermisoDto filtro) {
        Specification<RolPermiso> spec = new EspecificacionRolPermiso(filtro);
        return rolPermisoRepository.findAll(spec, PaginacionUtils.crearPageRequest(filtro))
                .map(rolPermisoMapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public RolPermisoDto encontrarPorId(Long id) {
        return rolPermisoMapper.toDTO(encontrarPorIdEntity(id));
    }

    @Override
    @Transactional(readOnly = true)
    public RolPermiso encontrarPorIdEntity(Long id) {
        return rolPermisoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Rol - Permiso", "id", id.toString()));
    }

    @Override
    @Transactional
    public List<RolPermisoDto> crear(CrearRolPermisoDto crear) {
        List<RolPermiso> rolPermisos = rolPermisoMapper.toEntity(crear.getPermisoIds(),
                crear.getRolId());
        return rolPermisoRepository.saveAll(rolPermisos).stream().map(rolPermisoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<RolPermisoDto> actualizar(ActualizarRolPermisoDto actualizar) {
        List<RolPermiso> rolPermisos = rolPermisoRepository.findAllById(actualizar.getRolPermisoIds());
        if (rolPermisos.isEmpty()) {
            throw new RecursoNoEncontrado(
                    "Roles - Permisos", "id", actualizar.getRolPermisoIds().toString());
        }
        rolPermisoMapper.updateEntity(rolPermisos, actualizar);
        return rolPermisoRepository.saveAll(rolPermisos).stream().map(rolPermisoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) {
        RolPermiso rolPermiso = encontrarPorIdEntity(id);
        rolPermisoRepository.delete(rolPermiso);
        return true;
    }
}
