package ec.com.eeasa.sisai.features.pagos.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_PAG_TIPO_PAGO", schema = "ROOTSISAI")
public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_PAG_TIPO_PAGO")
    @SequenceGenerator(name = "SEC_DIST_PAG_TIPO_PAGO", sequenceName = "SEC_DIST_PAG_TIPO_PAGO", allocationSize = 1)
    @Column(name = "DPATP_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DPATP_NOMBRE", nullable = false, length = 100)
    private String dpatpNombre;

    @Column(name = "DPATP_ACTIVO", length = 20)
    private String dpatpActivo;

    @Column(name = "DPATP_CREADO_POR", length = 100)
    private String dpatpCreadoPor;

    @Column(name = "DPATP_FECHA_CREACION")
    private Instant dpatpFechaCreacion;

    @Column(name = "DPATP_MODIFICADO_POR", length = 100)
    private String dpatpModificadoPor;

    @Column(name = "DPATP_FECHA_MODIFICACION")
    private Instant dpatpFechaModificacion;

}