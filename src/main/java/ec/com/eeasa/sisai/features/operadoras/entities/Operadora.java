package ec.com.eeasa.sisai.features.operadoras.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import ec.com.eeasa.sisai.features.auditoria.entities.DatosBaseAuditoria;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "DIST_OPE_OPERADORA", schema = "ROOTSISAI")
@AttributeOverrides({
        @AttributeOverride(name = "creadoPor", column = @Column(name = "DISOP_CREADO_POR")),
        @AttributeOverride(name = "fechaCreacion", column = @Column(name = "DISOP_FECHA_CREACION")),
        @AttributeOverride(name = "modificadoPor", column = @Column(name = "DISOP_MODIFICADO_POR")),
        @AttributeOverride(name = "fechaModificacion", column = @Column(name = "DISOP_FECHA_MODIFICACION"))
})
public class Operadora extends DatosBaseAuditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_OPE_OPERADORA")
    @SequenceGenerator(name = "SEC_DIST_OPE_OPERADORA", sequenceName = "SEC_DIST_OPE_OPERADORA", allocationSize = 1)
    @Column(name = "DISOP_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DISOP_NOMBRE", nullable = false, length = 200)
    private String nombre;

    @Column(name = "DISOP_RUC", nullable = false, length = 15)
    private String ruc;

    @Column(name = "DISOP_TELEFONO1", length = 15)
    private String telefono1;

    @Column(name = "DISOP_TELEFONO2", length = 15)
    private String telefono2;

    @Column(name = "DISOP_DIRECCION", nullable = false, length = 250)
    private String direccion;

    @Column(name = "DISOP_OBSERVACION", length = 500)
    private String observacion;

    @Column(name = "DISOP_ACTIVO", length = 20)
    private String activo;

    @Column(name = "DISOP_EMAIL", nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy = "codigoOperadora")
    private Set<Responsable> responsables = new LinkedHashSet<>();

}