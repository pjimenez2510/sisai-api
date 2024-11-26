package ec.com.eeasa.sisai.features.usuarios.mappers;

import ec.com.eeasa.sisai.features.roles.RolService;
import ec.com.eeasa.sisai.features.roles.entities.Rol;
import ec.com.eeasa.sisai.features.roles.mappers.RolMapper;
import ec.com.eeasa.sisai.features.usuarios.dtos.ActualizarUsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.dtos.CrearUsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.dtos.UsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.entities.Usuario;
import ec.com.eeasa.sisai.shared.interfaces.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UsuarioMapper implements Mapper<Usuario, UsuarioDto, CrearUsuarioDto, ActualizarUsuarioDto> {

    private final RolService rolService;
    private final RolMapper rolMapper;

    @Override
    public Usuario toEntity(CrearUsuarioDto crearUsuarioDto) {

        Rol rol = rolService.encontrarPorIdEntity(crearUsuarioDto.getRolId());

        Usuario usuario = new Usuario();
        usuario.setNombres(crearUsuarioDto.getNombres());
        usuario.setApellidos(crearUsuarioDto.getApellidos());
        usuario.setCedula(crearUsuarioDto.getCedula());
        usuario.setNombreUsuario(crearUsuarioDto.getNombreUsuario());
        usuario.setEmail(crearUsuarioDto.getEmail());
        usuario.setCodigoUnico(crearUsuarioDto.getCodigoUnico());
        usuario.setSeccion(crearUsuarioDto.getSeccion());
        usuario.setDepartamento(crearUsuarioDto.getDepartamento());
        usuario.setRol(rol);
        return usuario;
    }

    @Override
    public UsuarioDto toDTO(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setNombres(usuario.getNombres());
        usuarioDto.setApellidos(usuario.getApellidos());
        usuarioDto.setCedula(usuario.getCedula());
        usuarioDto.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setCodigoUnico(usuario.getCodigoUnico());
        usuarioDto.setSeccion(usuario.getSeccion());
        usuarioDto.setDepartamento(usuario.getDepartamento());
        usuarioDto.setRol(rolMapper.toDTO(usuario.getRol()));
        return usuarioDto;
    }

    @Override
    public void updateEntity(Usuario usuario, ActualizarUsuarioDto actualizarUsuarioDto) {
        Rol rol = rolService.encontrarPorIdEntity(actualizarUsuarioDto.getRolId());

        usuario.setNombres(actualizarUsuarioDto.getNombres());
        usuario.setApellidos(actualizarUsuarioDto.getApellidos());
        usuario.setCedula(actualizarUsuarioDto.getCedula());
        usuario.setNombreUsuario(actualizarUsuarioDto.getNombreUsuario());
        usuario.setEmail(actualizarUsuarioDto.getEmail());
        usuario.setCodigoUnico(actualizarUsuarioDto.getCodigoUnico());
        usuario.setSeccion(actualizarUsuarioDto.getSeccion());
        usuario.setDepartamento(actualizarUsuarioDto.getDepartamento());
        usuario.setRol(rol);
    }

    @Override
    public List<UsuarioDto> toDTOList(List<Usuario> usuarios) {
        return usuarios.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
