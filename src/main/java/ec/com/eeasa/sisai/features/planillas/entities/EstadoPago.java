package ec.com.eeasa.sisai.features.planillas.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_PAG_ESTADO_PAGO", schema = "ROOTSISAI")
public class EstadoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_PAG_ESTADO_PAGO")
    @SequenceGenerator(name = "SEC_DIST_PAG_ESTADO_PAGO", sequenceName = "SEC_DIST_PAG_ESTADO_PAGO", allocationSize = 1)
    @Column(name = "DPAEP_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DPAEP_NOMBRE", nullable = false, length = 100)
    private String dpaepNombre;

    @Column(name = "DPAEP_ACTIVO", length = 20)
    private String dpaepActivo;

    @Column(name = "DPAEP_CREADO_POR", length = 100)
    private String dpaepCreadoPor;

    @Column(name = "DPAEP_FECHA_CREACION")
    private Instant dpaepFechaCreacion;

    @Column(name = "DPAEP_MODIFICADO_POR", length = 100)
    private String dpaepModificadoPor;

    @Column(name = "DPAEP_FECHA_MODIFICACION")
    private Instant dpaepFechaModificacion;

}