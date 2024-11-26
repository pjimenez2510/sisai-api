package ec.com.eeasa.sisai.features.permisos;

import ec.com.eeasa.sisai.features.permisos.dtos.CrearPermisoDto;
import ec.com.eeasa.sisai.features.permisos.dtos.FiltroPermisoDto;
import ec.com.eeasa.sisai.features.permisos.dtos.PermisoDto;
import ec.com.eeasa.sisai.features.permisos.dtos.ActualizarPermisoDto;
import ec.com.eeasa.sisai.features.permisos.entities.Permiso;
import ec.com.eeasa.sisai.features.permisos.helpers.EspecificacionPermiso;
import ec.com.eeasa.sisai.features.permisos.mappers.PermisoMapper;
import ec.com.eeasa.sisai.shared.excepciones.RecursoNoEncontrado;
import ec.com.eeasa.sisai.utils.PaginacionUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PermisoService {

    private final PermisoRepository permisoRepository;
    private final PermisoMapper permisoMapper;

    @Transactional(readOnly = true)
    public Page<PermisoDto> encontrarTodos(FiltroPermisoDto filtro) {
        Specification<Permiso> spec = new EspecificacionPermiso(filtro);
        return permisoRepository.findAll(spec, PaginacionUtils.crearPageRequest(filtro)).map(permisoMapper::toDTO);
    }

    @Transactional(readOnly = true)
    public PermisoDto encontrarPorId(Long id) {
        return permisoMapper.toDTO(encontrarPorIdEntity(id));
    }

    @Transactional(readOnly = true)
    public Permiso encontrarPorIdEntity(Long id) {
        return permisoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Permiso", "id", id.toString()));
    }

    @Transactional
    public PermisoDto crear(CrearPermisoDto crearPermisoDto) {
        Permiso permiso = permisoMapper.toEntity(crearPermisoDto);
        return permisoMapper.toDTO(permisoRepository.save(permiso));
    }

    @Transactional
    public PermisoDto actualizar(Long id, ActualizarPermisoDto actualizarPermisoDto) {
        Permiso permiso = encontrarPorIdEntity(id);
        permisoMapper.updateEntity(permiso, actualizarPermisoDto);
        return permisoMapper.toDTO(permisoRepository.save(permiso));
    }

    @Transactional
    public boolean eliminar(Long id) {
        Permiso permiso = encontrarPorIdEntity(id);
        permisoRepository.delete(permiso);
        return true;
    }
}
