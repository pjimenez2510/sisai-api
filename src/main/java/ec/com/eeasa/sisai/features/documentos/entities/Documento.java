package ec.com.eeasa.sisai.features.documentos.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_DOC_DOCUMENTO", schema = "ROOTSISAI")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_DOC_DOCUMENTO")
    @SequenceGenerator(name = "SEC_DIST_DOC_DOCUMENTO", sequenceName = "SEC_DIST_DOC_DOCUMENTO", allocationSize = 1)
    @Column(name = "DIDOC_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DIDOC_NOMBRE", nullable = false, length = 250)
    private String didocNombre;

    @Column(name = "DIDOC_DESCRIPCION", length = 500)
    private String didocDescripcion;

    @Column(name = "DIDOC_FECHA_REGISTRO")
    private Instant didocFechaRegistro;

    @Column(name = "DIDOC_DOCUMENTO", nullable = false)
    private byte[] didocDocumento;

    @Column(name = "DIDOC_EXTENSION", nullable = false, length = 20)
    private String didocExtension;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DDOTD_CODIGO_TIPO_DOCUMENTO", nullable = false)
    private TipoDocumento ddotdCodigoTipoDocumento;

    @Column(name = "DIDOC_ACTIVO", length = 20)
    private String didocActivo;

    @Column(name = "DIDOC_CREADO_POR", length = 100)
    private String didocCreadoPor;

    @Column(name = "DIDOC_FECHA_CREACION")
    private Instant didocFechaCreacion;

    @Column(name = "DIDOC_MODIFICADO_POR", length = 100)
    private String didocModificadoPor;

    @Column(name = "DIDOC_FECHA_MODIFICACION")
    private Instant didocFechaModificacion;

}