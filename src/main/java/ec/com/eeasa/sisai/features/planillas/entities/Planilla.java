package ec.com.eeasa.sisai.features.planillas.entities;

import ec.com.eeasa.sisai.features.parametros.entities.Parametro;
import ec.com.eeasa.sisai.features.contratos.entities.Contrato;
import ec.com.eeasa.sisai.features.pagos.entities.PagoPlanilla;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "DIST_PAG_PLANILLA", schema = "ROOTSISAI")
public class Planilla {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_PAG_PLANILLA")
    @SequenceGenerator(name = "SEC_DIST_PAG_PLANILLA", sequenceName = "SEC_DIST_PAG_PLANILLA", allocationSize = 1)
    @Column(name = "DPPP_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DPPP_NUMERO_PAGO", nullable = false, length = 50)
    private String dpppNumeroPago;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DICON_CODIGO_CONTRATO", nullable = false)
    private Contrato diconCodigoContrato;

    @Column(name = "DPPP_FECHA_PAGO_DESDE", nullable = false)
    private LocalDate dpppFechaPagoDesde;

    @Column(name = "DPPP_FECHA_PAGO_HASTA", nullable = false)
    private LocalDate dpppFechaPagoHasta;

    @Column(name = "DPPP_OBSERVACION", length = 500)
    private String dpppObservacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DPAR_CODIGO_PARAMETRO", nullable = false)
    private Parametro dparCodigoParametro;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DPAEP_CODIGO_ESTADO", nullable = false)
    private EstadoPago dpaepCodigoEstado;

    @Column(name = "DPPP_SUBTOTAL", nullable = false, precision = 10, scale = 2)
    private BigDecimal dpppSubtotal;

    @Column(name = "DPPP_VALOR_TOTAL", nullable = false, precision = 10, scale = 2)
    private BigDecimal dpppValorTotal;

    @Column(name = "DPPP_ADICIONAL", nullable = false, precision = 10, scale = 2)
    private BigDecimal dpppAdicional;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DPPAG_CODIGO_PAGO_PLANILLA", nullable = false)
    private PagoPlanilla dppagCodigoPagoPlanilla;

    @Column(name = "DPPAG_ACTIVO", length = 20)
    private String dppagActivo;

    @Column(name = "DPPP_CREADO_POR", length = 100)
    private String dpppCreadoPor;

    @Column(name = "DPPP_FECHA_CREACION")
    private Instant dpppFechaCreacion;

    @Column(name = "DPPP_MODIFICADO_POR", length = 100)
    private String dpppModificadoPor;

    @Column(name = "DPPP_FECHA_MODIFICACION")
    private Instant dpppFechaModificacion;

}