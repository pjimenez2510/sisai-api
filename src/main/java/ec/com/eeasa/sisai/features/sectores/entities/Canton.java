package ec.com.eeasa.sisai.features.sectores.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_SECT_CANTON", schema = "ROOTSISAI")
public class Canton {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_SECT_CANTON")
    @SequenceGenerator(name = "SEC_DIST_SECT_CANTON", sequenceName = "SEC_DIST_SECT_CANTON", allocationSize = 1)
    @Column(name = "DISCA_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DISCA_NOMBRE", nullable = false, length = 100)
    private String discaNombre;

    @Column(name = "DISCA_DESCRIPCION", length = 500)
    private String discaDescripcion;

    @Column(name = "DISCA_ACTIVO", length = 20)
    private String discaActivo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DISPR_CODIGO_PROVINCIA", nullable = false)
    private Provincia disprCodigoProvincia;

    @Column(name = "DISCA_CREADO_POR", length = 100)
    private String discaCreadoPor;

    @Column(name = "DISCA_FECHA_CREACION")
    private Instant discaFechaCreacion;

    @Column(name = "DISCA_MODIFICADO_POR", length = 100)
    private String discaModificadoPor;

    @Column(name = "DISCA_FECHA_MODIFICACION")
    private Instant discaFechaModificacion;

}