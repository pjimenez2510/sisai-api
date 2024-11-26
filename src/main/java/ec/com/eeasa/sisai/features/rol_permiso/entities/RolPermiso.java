package ec.com.eeasa.sisai.features.rol_permiso.entities;

import ec.com.eeasa.sisai.features.permisos.entities.Permiso;
import ec.com.eeasa.sisai.features.roles.entities.Rol;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_USU_ROL_PERMISO", schema = "ROOTSISAI")
public class RolPermiso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_USU_ROL_PERMISO")
    @SequenceGenerator(name = "SEC_DIST_USU_ROL_PERMISO", sequenceName = "SEC_DIST_USU_ROL_PERMISO", allocationSize = 1)
    @Column(name = "DURP_CODIGO", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DUROL_CODIGO_ROL", nullable = false)
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DUPER_CODIGO_PERMISO", nullable = false)
    private Permiso permiso;

    @Column(name = "DURP_ACTIVO", length = 20)
    private String activo;

    @Column(name = "DURP_CREADO_POR", length = 100)
    private String creadoPor;

    @Column(name = "DURP_FECHA_CREACION")
    private Instant fechaCreacion;

    @Column(name = "DURP_MODIFICADO_POR", length = 100)
    private String modificadoPor;

    @Column(name = "DURP_FECHA_MODIFICACION")
    private Instant fechaModificacion;

}