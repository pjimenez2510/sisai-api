package ec.com.eeasa.sisai.features.polizas.entities;

import ec.com.eeasa.sisai.features.contratos.entities.Contrato;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "DIST_CONT_POLIZA", schema = "ROOTSISAI")
public class Poliza {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_CONT_POLIZA")
    @SequenceGenerator(name = "SEC_DIST_CONT_POLIZA", sequenceName = "SEC_DIST_CONT_POLIZA", allocationSize = 1)
    @Column(name = "DICP_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DICP_NUMERO", nullable = false, length = 100)
    private String dicpNumero;

    @Column(name = "DICP_VALOR", nullable = false, precision = 6, scale = 4)
    private BigDecimal dicpValor;

    @Column(name = "DICP_FECHA_INICIO", nullable = false)
    private LocalDate dicpFechaInicio;

    @Column(name = "DICP_FECHA_FIN", nullable = false)
    private LocalDate dicpFechaFin;

    @Column(name = "DICP_ACTIVO", length = 20)
    private String dicpActivo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DICON_CODIGO_CONTRATO", nullable = false)
    private Contrato diconCodigoContrato;

    @Column(name = "DICP_CREADO_POR", length = 100)
    private String dicpCreadoPor;

    @Column(name = "DICP_FECHA_CREACION")
    private Instant dicpFechaCreacion;

    @Column(name = "DICP_MODIFICADO_POR", length = 100)
    private String dicpModificadoPor;

    @Column(name = "DICP_FECHA_MODIFICACION")
    private Instant dicpFechaModificacion;

}