package ec.com.eeasa.sisai.features.polizas.entities;

import ec.com.eeasa.sisai.features.documentos.entities.Documento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_CONT_POLIZA_DOCUMENTO", schema = "ROOTSISAI")
public class PolizaDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_CONT_POLIZA_DOCUMENTO")
    @SequenceGenerator(name = "SEC_DIST_CONT_POLIZA_DOCUMENTO", sequenceName = "SEC_DIST_CONT_POLIZA_DOCUMENTO", allocationSize = 1)
    @Column(name = "DCPD_CODIGO", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DICP_CODIGO_POLIZA", nullable = false)
    private Poliza dicpCodigoPoliza;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DIDOC_CODIGO_DOCUMENTO", nullable = false)
    private Documento didocCodigoDocumento;

    @Column(name = "DIDOC_ACTIVO", length = 20)
    private String didocActivo;

    @Column(name = "DCPD_CREADO_POR", length = 100)
    private String dcpdCreadoPor;

    @Column(name = "DCPD_FECHA_CREACION")
    private Instant dcpdFechaCreacion;

    @Column(name = "DCPD_MODIFICADO_POR", length = 100)
    private String dcpdModificadoPor;

    @Column(name = "DCPD_FECHA_MODIFICACION")
    private Instant dcpdFechaModificacion;

}