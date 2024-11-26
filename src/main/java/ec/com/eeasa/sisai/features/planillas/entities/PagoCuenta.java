package ec.com.eeasa.sisai.features.planillas.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_PAG_PAGO_CUENTA", schema = "ROOTSISAI")
public class PagoCuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_PAG_PAGO_CUENTA")
    @SequenceGenerator(name = "SEC_DIST_PAG_PAGO_CUENTA", sequenceName = "SEC_DIST_PAG_PAGO_CUENTA", allocationSize = 1)
    @Column(name = "DPAPC_CODIGO", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DPPP_CODIGO_PLANILLA", nullable = false)
    private Planilla dpppCodigoPlanilla;

    @Column(name = "DPAPC_CUENTA", nullable = false, length = 50)
    private String dpapcCuenta;

    @Column(name = "DPAPC_ACTIVO", length = 20)
    private String dpapcActivo;

    @Column(name = "DPAPC_CREADO_POR", length = 100)
    private String dpapcCreadoPor;

    @Column(name = "DPAPC_FECHA_CREACION")
    private Instant dpapcFechaCreacion;

    @Column(name = "DPAPC_MODIFICADO_POR", length = 100)
    private String dpapcModificadoPor;

    @Column(name = "DPAPC_FECHA_MODIFICACION")
    private Instant dpapcFechaModificacion;

}