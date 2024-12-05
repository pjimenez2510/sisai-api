package ec.com.eeasa.sisai.features.usuarios.services.impl;

import ec.com.eeasa.sisai.features.auditoria.anotaciones.Auditable;
import ec.com.eeasa.sisai.features.auditoria.constantes.Operaciones;
import ec.com.eeasa.sisai.features.auditoria.constantes.Tablas;
import ec.com.eeasa.sisai.features.usuarios.dtos.ActualizarUsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.dtos.CrearUsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.dtos.FiltroUsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.dtos.UsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.entities.Usuario;
import ec.com.eeasa.sisai.features.usuarios.helpers.EspecificacionUsuario;
import ec.com.eeasa.sisai.features.usuarios.mappers.UsuarioMapper;
import ec.com.eeasa.sisai.features.usuarios.repositories.UsuarioRepository;
import ec.com.eeasa.sisai.features.usuarios.services.UsuarioService;
import ec.com.eeasa.sisai.shared.excepciones.RecursoNoEncontrado;
import ec.com.eeasa.sisai.shared.utils.PaginacionUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<UsuarioDto> encontrarTodos(FiltroUsuarioDto filtro) {
        Specification<Usuario> spec = new EspecificacionUsuario(filtro);
        return usuarioRepository.findAll(spec, PaginacionUtils.crearPageRequest(filtro)).map(usuarioMapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDto encontrarPorId(Long id) {
        return usuarioMapper.toDTO(encontrarPorIdEntity(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario encontrarPorIdEntity(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Usuario", "id", id.toString()));
    }

    @Override
    @Transactional
    @Auditable(tabla = Tablas.USUARIO, operacion = Operaciones.CREAR)
    public UsuarioDto crear(CrearUsuarioDto dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        return usuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    @Override
    @Transactional
    @Auditable(tabla = Tablas.USUARIO, operacion = Operaciones.ACTUALIZAR)
    public UsuarioDto actualizar(Long id, ActualizarUsuarioDto dto) {
        Usuario usuario = encontrarPorIdEntity(id);
        usuarioMapper.updateEntity(usuario, dto);
        return usuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    @Override
    @Transactional
    @Auditable(tabla = Tablas.USUARIO, operacion = Operaciones.ELIMINAR)
    public boolean eliminar(Long id) {
        Usuario usuario = encontrarPorIdEntity(id);
        usuarioRepository.delete(usuario);
        return true;
    }
}
