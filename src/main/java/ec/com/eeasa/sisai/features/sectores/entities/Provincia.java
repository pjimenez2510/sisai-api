package ec.com.eeasa.sisai.features.sectores.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_SECT_PROVINCIA", schema = "ROOTSISAI")
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_SECT_PROVINCIA")
    @SequenceGenerator(name = "SEC_DIST_SECT_PROVINCIA", sequenceName = "SEC_DIST_SECT_PROVINCIA", allocationSize = 1)
    @Column(name = "DISPR_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DISPR_NOMBRE", nullable = false, length = 100)
    private String disprNombre;

    @Column(name = "DISPR_DESCRIPCION", length = 500)
    private String disprDescripcion;

    @Column(name = "DISPR_ACTIVO", length = 20)
    private String disprActivo;

    @Column(name = "DISPR_CREADO_POR", length = 100)
    private String disprCreadoPor;

    @Column(name = "DISPR_FECHA_CREACION")
    private Instant disprFechaCreacion;

    @Column(name = "DISPR_MODIFICADO_POR", length = 100)
    private String disprModificadoPor;

    @Column(name = "DISPR_FECHA_MODIFICACION")
    private Instant disprFechaModificacion;

}