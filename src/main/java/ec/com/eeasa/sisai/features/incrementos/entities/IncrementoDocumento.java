package ec.com.eeasa.sisai.features.incrementos.entities;

import ec.com.eeasa.sisai.features.documentos.entities.Documento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_CONT_INCREMENTO_DOCUMENTO", schema = "ROOTSISAI")
public class IncrementoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_CONT_INCREMENTO_DOCUMENTO")
    @SequenceGenerator(name = "SEC_DIST_CONT_INCREMENTO_DOCUMENTO", sequenceName = "SEC_DIST_CONT_INCREMENTO_DOCUMENTO", allocationSize = 1)
    @Column(name = "DCID_CODIGO", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DICIC_CODIGO_INCREMENTO_CONTRATO", nullable = false)
    private IncrementoContrato dicicCodigoIncrementoContrato;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DIDOC_CODIGO_DOCUMENTO", nullable = false)
    private Documento didocCodigoDocumento;

    @Column(name = "DCID_CREADO_POR", length = 100)
    private String dcidCreadoPor;

    @Column(name = "DCID_FECHA_CREACION")
    private Instant dcidFechaCreacion;

    @Column(name = "DCID_MODIFICADO_POR", length = 100)
    private String dcidModificadoPor;

    @Column(name = "DCID_FECHA_MODIFICACION")
    private Instant dcidFechaModificacion;

    @Column(name = "DCID_ACTIVO", length = 20)
    private String dcidActivo;

}