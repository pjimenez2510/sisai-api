package ec.com.eeasa.sisai.features.parametros.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_PAR_PARAMETRO", schema = "ROOTSISAI")
public class Parametro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_PAR_PARAMETRO")
    @SequenceGenerator(name = "SEC_DIST_PAR_PARAMETRO", sequenceName = "SEC_DIST_PAR_PARAMETRO", allocationSize = 1)
    @Column(name = "DPAR_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DPAR_VALOR", nullable = false, length = 200)
    private String dparValor;

    @Column(name = "DPAR_ACTIVO", length = 20)
    private String dparActivo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DPTP_CODIGO_TIPO_PARAMETRO", nullable = false)
    private TipoParametro dptpCodigoTipoParametro;

    @Column(name = "DPAR_CREADO_POR", length = 100)
    private String dparCreadoPor;

    @Column(name = "DPAR_FECHA_CREACION")
    private Instant dparFechaCreacion;

    @Column(name = "DPAR_MODIFICADO_POR", length = 100)
    private String dparModificadoPor;

    @Column(name = "DPAR_FECHA_MODIFICACION")
    private Instant dparFechaModificacion;

}