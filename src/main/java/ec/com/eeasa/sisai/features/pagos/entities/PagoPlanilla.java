package ec.com.eeasa.sisai.features.pagos.entities;

import ec.com.eeasa.sisai.features.documentos.entities.Documento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "DIST_PAG_PAGO_PLANILLA", schema = "ROOTSISAI")
public class PagoPlanilla {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_PAG_PAGO_PLANILLA")
    @SequenceGenerator(name = "SEC_DIST_PAG_PAGO_PLANILLA", sequenceName = "SEC_DIST_PAG_PAGO_PLANILLA", allocationSize = 1)
    @Column(name = "DPPAG_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DPPAG_NUMERO_COMPROBANTE", nullable = false, length = 50)
    private String dppagNumeroComprobante;

    @Column(name = "DPPAG_NUMERO_REF_PAGO", nullable = false, length = 50)
    private String dppagNumeroRefPago;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DPATP_CODIGO_TIPO_PAGO", nullable = false)
    private TipoPago dpatpCodigoTipoPago;

    @Column(name = "DPPAG_FECHA_PAGO", nullable = false)
    private LocalDate dppagFechaPago;

    @Column(name = "DPPAG_OBSERVACION", length = 500)
    private String dppagObservacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DIDOC_CODIGO_DOCUMENTO", nullable = false)
    private Documento didocCodigoDocumento;

    @Column(name = "DPPAG_ACTIVO", length = 20)
    private String dppagActivo;

    @Column(name = "DPPAG_CREADO_POR", length = 100)
    private String dppagCreadoPor;

    @Column(name = "DPPAG_FECHA_CREACION")
    private Instant dppagFechaCreacion;

    @Column(name = "DPPAG_MODIFICADO_POR", length = 100)
    private String dppagModificadoPor;

    @Column(name = "DPPAG_FECHA_MODIFICACION")
    private Instant dppagFechaModificacion;

}