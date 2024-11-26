package ec.com.eeasa.sisai.features.sectores.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_SECT_PARROQUIA", schema = "ROOTSISAI")
public class Parroquia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_SECT_PARROQUIA")
    @SequenceGenerator(name = "SEC_DIST_SECT_PARROQUIA", sequenceName = "SEC_DIST_SECT_PARROQUIA", allocationSize = 1)
    @Column(name = "DISPAR_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DISPAR_NOMBRE", nullable = false, length = 100)
    private String disparNombre;

    @Column(name = "DISPAR_DESCRIPCION", length = 500)
    private String disparDescripcion;

    @Column(name = "DISPAR_ACTIVO", length = 20)
    private String disparActivo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DISCA_CODIGO_CANTON", nullable = false)
    private Canton discaCodigoCanton;

    @Column(name = "DISPAR_CREADO_POR", length = 100)
    private String disparCreadoPor;

    @Column(name = "DISPAR_FECHA_CREACION")
    private Instant disparFechaCreacion;

    @Column(name = "DISPAR_MODIFICADO_POR", length = 100)
    private String disparModificadoPor;

    @Column(name = "DISPAR_FECHA_MODIFICACION")
    private Instant disparFechaModificacion;

}