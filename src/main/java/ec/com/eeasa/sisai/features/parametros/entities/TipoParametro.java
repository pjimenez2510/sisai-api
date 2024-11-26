package ec.com.eeasa.sisai.features.parametros.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_PAR_TIPO_PARAMETRO", schema = "ROOTSISAI")
public class TipoParametro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_PAR_TIPO_PARAMETRO")
    @SequenceGenerator(name = "SEC_DIST_PAR_TIPO_PARAMETRO", sequenceName = "SEC_DIST_PAR_TIPO_PARAMETRO", allocationSize = 1)
    @Column(name = "DPTP_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DPTP_NOMBRE", nullable = false, length = 100)
    private String dptpNombre;

    @Column(name = "DPTP_ACTIVO", length = 20)
    private String dptpActivo;

    @Column(name = "DPTP_CREADO_POR", length = 100)
    private String dptpCreadoPor;

    @Column(name = "DPTP_FECHA_CREACION")
    private Instant dptpFechaCreacion;

    @Column(name = "DPTP_MODIFICADO_POR", length = 100)
    private String dptpModificadoPor;

    @Column(name = "DPTP_FECHA_MODIFICACION")
    private Instant dptpFechaModificacion;

}