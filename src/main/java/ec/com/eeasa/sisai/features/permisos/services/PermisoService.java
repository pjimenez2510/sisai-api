package ec.com.eeasa.sisai.features.permisos.services;

import org.springframework.data.domain.Page;

import ec.com.eeasa.sisai.features.permisos.dtos.ActualizarPermisoDto;
import ec.com.eeasa.sisai.features.permisos.dtos.CrearPermisoDto;
import ec.com.eeasa.sisai.features.permisos.dtos.FiltroPermisoDto;
import ec.com.eeasa.sisai.features.permisos.dtos.PermisoDto;
import ec.com.eeasa.sisai.features.permisos.entities.Permiso;

public interface PermisoService {
    public Page<PermisoDto> encontrarTodos(FiltroPermisoDto filtro);

    public PermisoDto encontrarPorId(Long id);

    public Permiso encontrarPorIdEntity(Long id);

    public PermisoDto crear(CrearPermisoDto dto);

    public PermisoDto actualizar(Long id, ActualizarPermisoDto dto);

    public boolean eliminar(Long id);
}
