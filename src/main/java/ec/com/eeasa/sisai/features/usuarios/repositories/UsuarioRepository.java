package ec.com.eeasa.sisai.features.usuarios.repositories;

import ec.com.eeasa.sisai.features.usuarios.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}