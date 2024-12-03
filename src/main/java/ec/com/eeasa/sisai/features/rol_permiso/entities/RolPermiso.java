package ec.com.eeasa.sisai.features.rol_permiso.entities;

import ec.com.eeasa.sisai.features.auditoria.entities.DatosBaseAuditoria;
import ec.com.eeasa.sisai.features.permisos.entities.Permiso;
import ec.com.eeasa.sisai.features.roles.entities.Rol;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "DIST_USU_ROL_PERMISO", schema = "ROOTSISAI")
@AttributeOverrides({
        @AttributeOverride(name = "creadoPor", column = @Column(name = "DURP_CREADO_POR")),
        @AttributeOverride(name = "fechaCreacion", column = @Column(name = "DURP_FECHA_CREACION")),
        @AttributeOverride(name = "modificadoPor", column = @Column(name = "DURP_MODIFICADO_POR")),
        @AttributeOverride(name = "fechaModificacion", column = @Column(name = "DURP_FECHA_MODIFICACION"))
})
public class RolPermiso extends DatosBaseAuditoria {
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

}