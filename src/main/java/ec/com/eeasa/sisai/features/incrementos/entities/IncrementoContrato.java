package ec.com.eeasa.sisai.features.incrementos.entities;

import ec.com.eeasa.sisai.features.contratos.entities.Contrato;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "DIST_CONT_INCREMENTO_CONTRATO", schema = "ROOTSISAI")
public class IncrementoContrato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_CONT_INCREMENTO_CONTRATO")
    @SequenceGenerator(name = "SEC_DIST_CONT_INCREMENTO_CONTRATO", sequenceName = "SEC_DIST_CONT_INCREMENTO_CONTRATO", allocationSize = 1)
    @Column(name = "DICIC_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DICIC_CANTIDAD", nullable = false)
    private Integer dicicCantidad;

    @Column(name = "DICIC_NUMERO_AUTORIZACION", length = 30)
    private String dicicNumeroAutorizacion;

    @Column(name = "DICIC_FECHA", nullable = false)
    private LocalDate dicicFecha;

    @Column(name = "DICIC_FECHA_ULTIMO_PAGO", nullable = false)
    private LocalDate dicicFechaUltimoPago;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DICON_CODIGO_CONTRATO", nullable = false)
    private Contrato diconCodigoContrato;

    @Column(name = "DICIC_CREADO_POR", length = 100)
    private String dicicCreadoPor;

    @Column(name = "DICIC_FECHA_CREACION")
    private Instant dicicFechaCreacion;

    @Column(name = "DICIC_MODIFICADO_POR", length = 100)
    private String dicicModificadoPor;

    @Column(name = "DICIC_FECHA_MODIFICACION")
    private Instant dicicFechaModificacion;

    @Column(name = "DICIC_ACTIVO", length = 20)
    private String dicicActivo;

}