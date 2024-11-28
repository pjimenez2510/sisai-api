package ec.com.eeasa.sisai.features.permisos.entities;

import ec.com.eeasa.sisai.features.rol_permiso.entities.RolPermiso;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "DIST_USU_PERMISO", schema = "ROOTSISAI")
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_USU_PERMISO")
    @SequenceGenerator(name = "SEC_DIST_USU_PERMISO", sequenceName = "SEC_DIST_USU_PERMISO", allocationSize = 1)
    @Column(name = "DUPER_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DUPER_RECURSO", nullable = false, length = 100)
    private String recurso;

    @Column(name = "DUPER_ACCION", nullable = false, length = 50)
    private String accion;

    @Column(name = "DUPER_DESCRIPCION", length = 200)
    private String descripcion;

    @Column(name = "DUPER_ACTIVO", length = 20)
    private String activo;

    @Column(name = "DUPER_CREADO_POR", length = 100)
    private String creadoPor;

    @Column(name = "DUPER_FECHA_CREACION")
    private Instant fechaCreacion;

    @Column(name = "DUPER_MODIFICADO_POR", length = 100)
    private String modificadoPor;

    @Column(name = "DUPER_FECHA_MODIFICACION")
    private Instant fechaModificacion;

    @OneToMany(mappedBy = "permiso")
    private Set<RolPermiso> rolPermisos = new LinkedHashSet<>();

}