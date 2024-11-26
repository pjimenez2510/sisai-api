package ec.com.eeasa.sisai.features.contratos.entities;

import ec.com.eeasa.sisai.features.tipoContrato.entities.TipoContrato;
import ec.com.eeasa.sisai.features.operadoras.entities.Operadora;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter

@Entity
@Table(name = "DIST_CONT_CONTRATO", schema = "ROOTSISAI")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_CONT_CONTRATO")
    @SequenceGenerator(name = "SEC_DIST_CONT_CONTRATO", sequenceName = "SEC_DIST_CONT_CONTRATO", allocationSize = 1)
    @Column(name = "DICON_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DICON_NUMERO", nullable = false, length = 20)
    private String diconNumero;

    @Column(name = "DICON_FECHA_FIRMA", nullable = false)
    private LocalDate diconFechaFirma;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DICTP_CODIGO_TIPO_CONTRATO", nullable = false)
    private TipoContrato dictpCodigoTipoContrato;

    @Column(name = "DICON_CANTIDAD", nullable = false)
    private Integer diconCantidad;

    @Column(name = "DICON_FECHA_INICIO", nullable = false)
    private LocalDate diconFechaInicio;

    @Column(name = "DICON_FECHA_FIN", nullable = false)
    private LocalDate diconFechaFin;

    @Column(name = "DICON_VALOR_TOTAL", nullable = false, precision = 6, scale = 4)
    private BigDecimal diconValorTotal;

    @Column(name = "DICON_OBSERVACION", nullable = false, length = 500)
    private String diconObservacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DCSEC_CODIGO_CONTRATO_SECTOR", nullable = false)
    private ContratoSector dcsecCodigoContratoSector;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DISOP_CODIGO_OPERADORA", nullable = false)
    private Operadora disopCodigoOperadora;

    @Column(name = "DICON_ACTIVO", length = 20)
    private String diconActivo;

    @Column(name = "DICON_CREADO_POR", length = 100)
    private String diconCreadoPor;

    @Column(name = "DICON_FECHA_CREACION")
    private Instant diconFechaCreacion;

    @Column(name = "DICON_MODIFICADO_POR", length = 100)
    private String diconModificadoPor;

    @Column(name = "DICON_FECHA_MODIFICACION")
    private Instant diconFechaModificacion;

}