package ec.com.eeasa.sisai.features.documentos.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_DOC_TIPO_DOCUMENTO", schema = "ROOTSISAI")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_DOC_TIPO_DOCUMENTO")
    @SequenceGenerator(name = "SEC_DIST_DOC_TIPO_DOCUMENTO", sequenceName = "SEC_DIST_DOC_TIPO_DOCUMENTO", allocationSize = 1)
    @Column(name = "DDOTD_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DDOTD_NOMBRE", nullable = false, length = 100)
    private String ddotdNombre;

    @Column(name = "DDOTD_DESCRIPCION", length = 500)
    private String ddotdDescripcion;

    @Column(name = "DDOTD_ACTIVO", length = 20)
    private String ddotdActivo;

    @Column(name = "DDOTD_CREADO_POR", length = 100)
    private String ddotdCreadoPor;

    @Column(name = "DDOTD_FECHA_CREACION")
    private Instant ddotdFechaCreacion;

    @Column(name = "DDOTD_MODIFICADO_POR", length = 100)
    private String ddotdModificadoPor;

    @Column(name = "DDOTD_FECHA_MODIFICACION")
    private Instant ddotdFechaModificacion;

}