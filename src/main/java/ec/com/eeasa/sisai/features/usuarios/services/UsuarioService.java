package ec.com.eeasa.sisai.features.usuarios.services;

import ec.com.eeasa.sisai.features.usuarios.dtos.ActualizarUsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.dtos.CrearUsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.dtos.FiltroUsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.dtos.UsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.entities.Usuario;
import org.springframework.data.domain.Page;

public interface UsuarioService {
    Page<UsuarioDto> encontrarTodos(FiltroUsuarioDto filtro);

    UsuarioDto encontrarPorId(Long id);

    Usuario encontrarPorIdEntity(Long id);

    UsuarioDto crear(CrearUsuarioDto dto);

    UsuarioDto actualizar(Long id, ActualizarUsuarioDto dto);

    boolean eliminar(Long id);
}
