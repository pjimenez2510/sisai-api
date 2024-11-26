package ec.com.eeasa.sisai.features.tipoContrato.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_CONT_TIPO_CONTRATO", schema = "ROOTSISAI")
public class TipoContrato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_CONT_TIPO_CONTRATO")
    @SequenceGenerator(name = "SEC_DIST_CONT_TIPO_CONTRATO", sequenceName = "SEC_DIST_CONT_TIPO_CONTRATO", allocationSize = 1)
    @Column(name = "DICTP_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DICTP_NOMBRE", nullable = false, length = 50)
    private String dictpNombre;

    @Column(name = "DICTP_DESCRIPCION", length = 50)
    private String dictpDescripcion;

    @Column(name = "DICTP_VALOR_UNITARIO", nullable = false, precision = 2, scale = 2)
    private BigDecimal dictpValorUnitario;

    @Column(name = "DICTP_ACTIVO", length = 20)
    private String dictpActivo;

    @Column(name = "DICTP_CREADO_POR", length = 100)
    private String dictpCreadoPor;

    @Column(name = "DICTP_FECHA_CREACION")
    private Instant dictpFechaCreacion;

    @Column(name = "DICTP_MODIFICADO_POR", length = 100)
    private String dictpModificadoPor;

    @Column(name = "DICTP_FECHA_MODIFICACION")
    private Instant dictpFechaModificacion;

}