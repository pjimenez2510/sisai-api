package ec.com.eeasa.sisai.features.contratos.entities;

import ec.com.eeasa.sisai.features.sectores.entities.Canton;
import ec.com.eeasa.sisai.features.sectores.entities.Parroquia;
import ec.com.eeasa.sisai.features.sectores.entities.Provincia;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_CONT_CONTRATO_SECTOR", schema = "ROOTSISAI")
public class ContratoSector {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_CONT_CONTRATO_SECTOR")
    @SequenceGenerator(name = "SEC_DIST_CONT_CONTRATO_SECTOR", sequenceName = "SEC_DIST_CONT_CONTRATO_SECTOR", allocationSize = 1)
    @Column(name = "DCSEC_CODIGO", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DISPR_CODIGO_PROVINCIA", nullable = false)
    private Provincia disprCodigoProvincia;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DISCA_CODIGO_CANTON", nullable = false)
    private Canton discaCodigoCanton;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DISPAR_CODIGO_PARROQUIA", nullable = false)
    private Parroquia disparCodigoParroquia;

    @Column(name = "DCSEC_SECTORES", nullable = false, length = 500)
    private String dcsecSectores;

    @Column(name = "DCSEC_DIRECCIONES", nullable = false, length = 500)
    private String dcsecDirecciones;

    @Column(name = "DCSEC_ACTIVO", length = 20)
    private String dcsecActivo;

    @Column(name = "DCSEC_CREADO_POR", length = 100)
    private String dcsecCreadoPor;

    @Column(name = "DCSEC_FECHA_CREACION")
    private Instant dcsecFechaCreacion;

    @Column(name = "DCSEC_MODIFICADO_POR", length = 100)
    private String dcsecModificadoPor;

    @Column(name = "DCSEC_FECHA_MODIFICACION")
    private Instant dcsecFechaModificacion;

}