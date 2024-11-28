package ec.com.eeasa.sisai.features.roles.services;

import org.springframework.data.domain.Page;

import ec.com.eeasa.sisai.features.roles.dtos.ActualizarRolDto;
import ec.com.eeasa.sisai.features.roles.dtos.CrearRolDto;
import ec.com.eeasa.sisai.features.roles.dtos.FiltroRolDto;
import ec.com.eeasa.sisai.features.roles.dtos.RolDto;
import ec.com.eeasa.sisai.features.roles.entities.Rol;

public interface RolService {

    Page<RolDto> encontrarTodos(FiltroRolDto filtro);

    RolDto encontrarPorId(Long id);

    Rol encontrarPorIdEntity(Long id);

    RolDto crear(CrearRolDto dto);

    RolDto actualizar(Long id, ActualizarRolDto dto);

    boolean eliminar(Long id);
}
