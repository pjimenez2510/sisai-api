package ec.com.eeasa.sisai.features.rol_permiso.services.impl;

import ec.com.eeasa.sisai.features.auditoria.anotaciones.Auditable;
import ec.com.eeasa.sisai.features.auditoria.constantes.Operaciones;
import ec.com.eeasa.sisai.features.auditoria.constantes.Tablas;
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
    @Auditable(tabla = Tablas.ROL_PERMISO, operacion = Operaciones.CREAR)
    public List<RolPermisoDto> crear(CrearRolPermisoDto dto) {
        List<RolPermiso> rolPermisos = rolPermisoMapper.toEntity(dto.getRolPermisoIds(),
                dto.getRolId());
        return rolPermisoRepository.saveAll(rolPermisos).stream().map(rolPermisoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    @Auditable(tabla = Tablas.ROL_PERMISO, operacion = Operaciones.ACTUALIZAR)
    public List<RolPermisoDto> actualizar(ActualizarRolPermisoDto dto) {
        List<RolPermiso> rolPermisos = rolPermisoRepository.findAllById(dto.getRolPermisoIds());
        if (rolPermisos.isEmpty()) {
            throw new RecursoNoEncontrado(
                    "Roles - Permisos", "id", dto.getRolPermisoIds().toString());
        }
        rolPermisoMapper.updateEntity(rolPermisos, dto);
        return rolPermisoRepository.saveAll(rolPermisos).stream().map(rolPermisoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    @Auditable(tabla = Tablas.ROL_PERMISO, operacion = Operaciones.ELIMINAR)
    public boolean eliminar(Long id) {
        RolPermiso rolPermiso = encontrarPorIdEntity(id);
        rolPermisoRepository.delete(rolPermiso);
        return true;
    }
}
