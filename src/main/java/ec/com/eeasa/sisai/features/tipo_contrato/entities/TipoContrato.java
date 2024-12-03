package ec.com.eeasa.sisai.features.tipo_contrato.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import ec.com.eeasa.sisai.features.auditoria.entities.DatosBaseAuditoria;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "DIST_CONT_TIPO_CONTRATO", schema = "ROOTSISAI")
@AttributeOverrides({
        @AttributeOverride(name = "creadoPor", column = @Column(name = "DICTP_CREADO_POR")),
        @AttributeOverride(name = "fechaCreacion", column = @Column(name = "DICTP_FECHA_CREACION")),
        @AttributeOverride(name = "modificadoPor", column = @Column(name = "DICTP_MODIFICADO_POR")),
        @AttributeOverride(name = "fechaModificacion", column = @Column(name = "DICTP_FECHA_MODIFICACION"))
})
public class TipoContrato extends DatosBaseAuditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_CONT_TIPO_CONTRATO")
    @SequenceGenerator(name = "SEC_DIST_CONT_TIPO_CONTRATO", sequenceName = "SEC_DIST_CONT_TIPO_CONTRATO", allocationSize = 1)
    @Column(name = "DICTP_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DICTP_NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "DICTP_DESCRIPCION", length = 50)
    private String descripcion;

    @Column(name = "DICTP_VALOR_UNITARIO", nullable = false, precision = 2, scale = 2)
    private BigDecimal valorUnitario;

    @Column(name = "DICTP_ACTIVO", length = 20)
    private String activo;

}