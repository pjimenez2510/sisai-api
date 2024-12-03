package ec.com.eeasa.sisai.features.usuarios.entities;

import ec.com.eeasa.sisai.features.auditoria.entities.DatosBaseAuditoria;
import ec.com.eeasa.sisai.features.roles.entities.Rol;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "DIST_USU_USUARIO", schema = "ROOTSISAI")
@AttributeOverrides({
        @AttributeOverride(name = "creadoPor", column = @Column(name = "DIUSU_CREADO_POR")),
        @AttributeOverride(name = "fechaCreacion", column = @Column(name = "DIUSU_FECHA_CREACION")),
        @AttributeOverride(name = "modificadoPor", column = @Column(name = "DIUSU_MODIFICADO_POR")),
        @AttributeOverride(name = "fechaModificacion", column = @Column(name = "DIUSU_FECHA_MODIFICACION"))
})
public class Usuario extends DatosBaseAuditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_USU_USUARIO")
    @SequenceGenerator(name = "SEC_DIST_USU_USUARIO", sequenceName = "SEC_DIST_USU_USUARIO", allocationSize = 1)
    @Column(name = "DIUSU_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DIUSU_NOMBRES", nullable = false, length = 100)
    private String nombres;

    @Column(name = "DIUSU_APELLIDOS", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "DIUSU_CEDULA", nullable = false, length = 10)
    private String cedula;

    @Column(name = "DIUSU_NOMBRE_USUARIO", nullable = false, length = 100)
    private String nombreUsuario;

    @Column(name = "DIUSU_EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "DIUSU_CODIGO_UNICO", nullable = false, length = 100)
    private String codigoUnico;

    @Column(name = "DIUSU_SECCION", nullable = false, length = 100)
    private String seccion;

    @Column(name = "DIUSU_DEPARTAMENTO", nullable = false, length = 100)
    private String departamento;

    @Column(name = "DIUSU_ACTIVO", length = 20)
    private String activo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DUROL_CODIGO_ROL", nullable = false)
    private Rol rol;

}