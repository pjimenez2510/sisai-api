package ec.com.eeasa.sisai.features.permisos.services.impl;

import ec.com.eeasa.sisai.features.permisos.repositories.PermisoRepository;
import ec.com.eeasa.sisai.features.permisos.services.PermisoService;
import ec.com.eeasa.sisai.features.permisos.dtos.CrearPermisoDto;
import ec.com.eeasa.sisai.features.permisos.dtos.FiltroPermisoDto;
import ec.com.eeasa.sisai.features.permisos.dtos.PermisoDto;
import ec.com.eeasa.sisai.features.auditoria.anotaciones.Auditable;
import ec.com.eeasa.sisai.features.auditoria.constantes.Operaciones;
import ec.com.eeasa.sisai.features.auditoria.constantes.Tablas;
import ec.com.eeasa.sisai.features.permisos.dtos.ActualizarPermisoDto;
import ec.com.eeasa.sisai.features.permisos.entities.Permiso;
import ec.com.eeasa.sisai.features.permisos.helpers.EspecificacionPermiso;
import ec.com.eeasa.sisai.features.permisos.mappers.PermisoMapper;
import ec.com.eeasa.sisai.shared.excepciones.RecursoNoEncontrado;
import ec.com.eeasa.sisai.shared.utils.PaginacionUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PermisoServiceImpl implements PermisoService {

    private final PermisoRepository permisoRepository;
    private final PermisoMapper permisoMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<PermisoDto> encontrarTodos(FiltroPermisoDto filtro) {
        Specification<Permiso> spec = new EspecificacionPermiso(filtro);
        return permisoRepository.findAll(spec, PaginacionUtils.crearPageRequest(filtro)).map(permisoMapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public PermisoDto encontrarPorId(Long id) {
        return permisoMapper.toDTO(encontrarPorIdEntity(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Permiso encontrarPorIdEntity(Long id) {
        return permisoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Permiso", "id", id.toString()));
    }

    @Override
    @Transactional
    @Auditable(tabla = Tablas.PERMISO, operacion = Operaciones.CREAR)
    public PermisoDto crear(CrearPermisoDto dto) {
        Permiso permiso = permisoMapper.toEntity(dto);
        return permisoMapper.toDTO(permisoRepository.save(permiso));
    }

    @Override
    @Transactional
    @Auditable(tabla = Tablas.PERMISO, operacion = Operaciones.ACTUALIZAR)
    public PermisoDto actualizar(Long id, ActualizarPermisoDto dto) {
        Permiso permiso = encontrarPorIdEntity(id);
        permisoMapper.updateEntity(permiso, dto);
        return permisoMapper.toDTO(permisoRepository.save(permiso));
    }

    @Override
    @Transactional
    @Auditable(tabla = Tablas.PERMISO, operacion = Operaciones.ELIMINAR)
    public boolean eliminar(Long id) {
        Permiso permiso = encontrarPorIdEntity(id);
        permisoRepository.delete(permiso);
        return true;
    }

}
