package ec.com.eeasa.sisai.features.rol_permiso.services;

import java.util.List;

import org.springframework.data.domain.Page;

import ec.com.eeasa.sisai.features.rol_permiso.dtos.ActualizarRolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.dtos.CrearRolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.dtos.FiltroRolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.dtos.RolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.entities.RolPermiso;

public interface RolPermisoService {
    Page<RolPermisoDto> encontrarTodos(FiltroRolPermisoDto filtro);

    RolPermisoDto encontrarPorId(Long id);

    RolPermiso encontrarPorIdEntity(Long id);

    List<RolPermisoDto> crear(CrearRolPermisoDto crear);

    List<RolPermisoDto> actualizar(ActualizarRolPermisoDto actualizar);

    boolean eliminar(Long id);
}
