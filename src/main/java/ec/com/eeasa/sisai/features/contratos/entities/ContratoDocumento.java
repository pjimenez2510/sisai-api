package ec.com.eeasa.sisai.features.contratos.entities;

import ec.com.eeasa.sisai.features.documentos.entities.Documento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_CONT_CONTRATO_DOCUMENTO", schema = "ROOTSISAI")
public class ContratoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_CONT_CONTRATO_DOCUMENTO")
    @SequenceGenerator(name = "SEC_DIST_CONT_CONTRATO_DOCUMENTO", sequenceName = "SEC_DIST_CONT_CONTRATO_DOCUMENTO", allocationSize = 1)
    @Column(name = "DCCD_CODIGO", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DICON_CODIGO_CONTRATO", nullable = false)
    private Contrato diconCodigoContrato;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DIDOC_CODIGO_DOCUMENTO", nullable = false)
    private Documento didocCodigoDocumento;

    @Column(name = "DCCD_CREADO_POR", length = 100)
    private String dccdCreadoPor;

    @Column(name = "DCCD_FECHA_CREACION")
    private Instant dccdFechaCreacion;

    @Column(name = "DCCD_MODIFICADO_POR", length = 100)
    private String dccdModificadoPor;

    @Column(name = "DCCD_FECHA_MODIFICACION")
    private Instant dccdFechaModificacion;

    @Column(name = "DCCD_ACTIVO", length = 20)
    private String dccdActivo;

}