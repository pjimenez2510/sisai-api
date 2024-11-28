package ec.com.eeasa.sisai.features.auth.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ec.com.eeasa.sisai.features.permisos.entities.Permiso;
import ec.com.eeasa.sisai.features.roles.entities.Rol;
import ec.com.eeasa.sisai.features.usuarios.entities.Usuario;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    private final Usuario usuario;
    private final List<Permiso> permisos;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permisos.stream()
                .map(permiso -> new SimpleGrantedAuthority(
                        permiso.getRecurso() + "_" + permiso.getAccion()))
                .collect(Collectors.toList());
    }

    public Rol getRol() {
        return usuario.getRol();
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return usuario.getNombreUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return "ACTIVO".equals(usuario.getActivo());
    }
}
