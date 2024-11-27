package ec.com.eeasa.sisai.features.usuarios.services;

import ec.com.eeasa.sisai.features.usuarios.dtos.ActualizarUsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.dtos.CrearUsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.dtos.FiltroUsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.dtos.UsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.entities.Usuario;
import org.springframework.data.domain.Page;

public interface UsuarioService {
    public Page<UsuarioDto> encontrarTodos(FiltroUsuarioDto filtro);

    public UsuarioDto encontrarPorId(Long id);

    public Usuario encontrarPorIdEntity(Long id);

    public UsuarioDto crear(CrearUsuarioDto crearUsuarioDto);

    public UsuarioDto actualizar(Long id, ActualizarUsuarioDto actualizarUsuarioDto);

    public boolean eliminar(Long id);
}
