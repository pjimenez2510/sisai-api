package ec.com.eeasa.sisai.features.seed;

import java.util.ArrayList;
import java.util.List;

import ec.com.eeasa.sisai.features.permisos.repositories.PermisoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.eeasa.sisai.features.permisos.entities.Permiso;
import ec.com.eeasa.sisai.features.rol_permiso.entities.RolPermiso;
import ec.com.eeasa.sisai.features.rol_permiso.repositories.RolPermisoRepository;
import ec.com.eeasa.sisai.features.roles.entities.Rol;
import ec.com.eeasa.sisai.features.roles.repositories.RolRepository;
import ec.com.eeasa.sisai.features.usuarios.entities.Usuario;
import ec.com.eeasa.sisai.features.usuarios.repositories.UsuarioRepository;
import ec.com.eeasa.sisai.shared.respuesta.GeneradorRespuesta;
import ec.com.eeasa.sisai.shared.respuesta.RespuestaGenerica;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/seed")
@RequiredArgsConstructor
@Validated
@Tag(name = "Seed", description = "API para crear datos por defecto")
public class SeedController {

    private final RolRepository rolRepository;
    private final RolPermisoRepository rolPermisoRepository;
    private final UsuarioRepository usuarioRepository;
    private final GeneradorRespuesta generadorRespuesta;
    private final PermisoRepository permisoRepository;

    @GetMapping
    @Operation(summary = "Ejecutar seed", description = "Obtiene todos los roles registrados en el sistema")
    public ResponseEntity<RespuestaGenerica<Boolean>> seed() {

        rolPermisoRepository.deleteAll();
        permisoRepository.deleteAll();
        usuarioRepository.deleteAll();
        rolRepository.deleteAll();

        List<Permiso> permisos = new ArrayList<>();

        String[] acciones = {
                "CREAR",
                "ACTUALIZAR",
                "ELIMINAR",
                "LEER",
        };

        String[] recursos = {
                "USUARIO",
                "ROL",
                "PERMISO",
                "CONTRATO",
                "ROL_PERMISO",
                "AUDITORIA",
                "DOCUMENTO",
                "INCREMENTO",
                "OPERADORA",
                "PAGO",
                "PARAMETRO",
                "PLANILLA",
                "POLIZAS",
                "SECTORES",
        };

        for (String recurso : recursos) {
            for (String accion : acciones) {
                Permiso permiso = new Permiso();
                permiso.setAccion(accion);
                permiso.setRecurso(recurso);
                permiso.setDescripcion(accion + " " + recurso);
                permisos.add(permiso);
            }
        }

        List<Permiso> rolPermisosCreate = permisoRepository.saveAll(permisos);

        List<Rol> rols = new ArrayList<>();

        Rol rolAdmin = new Rol();
        rolAdmin.setDescripcion("ADMINISTRADOR");
        rols.add(rolAdmin);

        Rol rolUser = new Rol();
        rolUser.setDescripcion("USUARIO");
        rols.add(rolUser);

        List<Rol> rolsCreate = rolRepository.saveAll(rols);

        List<RolPermiso> rolPermisos = new ArrayList<>();

        for (Rol rol : rolsCreate) {
            if (rol.getDescripcion().equals("ADMINISTRADOR")) {
                for (Permiso permiso : rolPermisosCreate) {
                    RolPermiso rolPermiso = new RolPermiso();
                    rolPermiso.setRol(rol);
                    rolPermiso.setPermiso(permiso);
                    rolPermisos.add(rolPermiso);
                }
            }

            if (rol.getDescripcion().equals("USUARIO")) {
                for (Permiso permiso : rolPermisosCreate) {
                    if (permiso.getRecurso().equals("USUARIO") && permiso.getAccion().equals("LEER")) {
                        RolPermiso rolPermiso = new RolPermiso();
                        rolPermiso.setRol(rol);
                        rolPermiso.setPermiso(permiso);
                        rolPermisos.add(rolPermiso);
                    }
                }
            }
        }

        rolPermisoRepository.saveAll(rolPermisos);

        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuarioAdmin = new Usuario();
        usuarioAdmin.setNombres("Maria Isabel");
        usuarioAdmin.setApellidos("Carrion Tobar");
        usuarioAdmin.setCedula("1800231232");
        usuarioAdmin.setCodigoUnico("12902");
        usuarioAdmin.setDepartamento("Sistemas");
        usuarioAdmin.setNombreUsuario("admin");
        usuarioAdmin.setEmail("mariacarrion@gmail.com");
        usuarioAdmin.setRol(rolsCreate.get(0));
        usuarioAdmin.setSeccion("Sistemas");

        usuarios.add(usuarioAdmin);

        Usuario usuarioUser = new Usuario();
        usuarioUser.setNombres("Juan Carlos");
        usuarioUser.setApellidos("Carrion Tobar");
        usuarioUser.setCedula("1800231233");
        usuarioUser.setCodigoUnico("23423");
        usuarioUser.setDepartamento("Sistemas");
        usuarioUser.setNombreUsuario("user");
        usuarioUser.setEmail("juancarrion@gmail.com");
        usuarioUser.setRol(rolsCreate.get(1));
        usuarioUser.setSeccion("Sistemas");

        usuarios.add(usuarioUser);

        usuarioRepository.saveAll(usuarios);

        return generadorRespuesta.buildResponse(
                true,
                HttpStatus.OK.value(),
                "Seed ejecutado correctamente correctamente");
    }

}