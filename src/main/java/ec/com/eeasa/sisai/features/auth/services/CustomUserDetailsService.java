package ec.com.eeasa.sisai.features.auth.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ec.com.eeasa.sisai.features.auth.entities.CustomUserDetails;
import ec.com.eeasa.sisai.features.permisos.entities.Permiso;
import ec.com.eeasa.sisai.features.permisos.repositories.PermisoRepository;
import ec.com.eeasa.sisai.features.usuarios.entities.Usuario;
import ec.com.eeasa.sisai.features.usuarios.repositories.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PermisoRepository permisoRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository,
            PermisoRepository permisoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.permisoRepository = permisoRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombreUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        List<Permiso> permisos = permisoRepository.findByRolPermisos_Rol_Id(usuario.getRol().getId());

        return new CustomUserDetails(usuario, permisos);
    }
}
