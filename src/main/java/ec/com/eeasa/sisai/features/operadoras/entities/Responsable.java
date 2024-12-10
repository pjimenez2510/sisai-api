package ec.com.eeasa.sisai.features.operadoras.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import ec.com.eeasa.sisai.features.auditoria.entities.DatosBaseAuditoria;

@Getter
@Setter
@Entity
@Table(name = "DIST_OPE_RESPONSABLE", schema = "ROOTSISAI")
@AttributeOverrides({
        @AttributeOverride(name = "creadoPor", column = @Column(name = "DORES_CREADO_POR")),
        @AttributeOverride(name = "fechaCreacion", column = @Column(name = "DORES_FECHA_CREACION")),
        @AttributeOverride(name = "modificadoPor", column = @Column(name = "DORES_MODIFICADO_POR")),
        @AttributeOverride(name = "fechaModificacion", column = @Column(name = "DORES_FECHA_MODIFICACION"))
})
public class Responsable extends DatosBaseAuditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_OPE_RESPONSABLE")
    @SequenceGenerator(name = "SEC_DIST_OPE_RESPONSABLE", sequenceName = "SEC_DIST_OPE_RESPONSABLE", allocationSize = 1)
    @Column(name = "DORES_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DORES_NOMBRES", nullable = false, length = 100)
    private String nombres;

    @Column(name = "DORES_APELLIDOS", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "DORES_EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "DORES_TELEFONO", length = 15)
    private String telefono;

    @Column(name = "DORES_ACTIVO", length = 20)
    private String activo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DISOP_CODIGO_OPERADORA", nullable = false)
    private Operadora codigoOperadora;

}