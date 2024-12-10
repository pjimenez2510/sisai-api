package ec.com.eeasa.sisai.features.provincia.entities;

import ec.com.eeasa.sisai.features.auditoria.entities.DatosBaseAuditoria;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_SECT_PROVINCIA", schema = "ROOTSISAI")
@AttributeOverrides({
        @AttributeOverride(name = "creadoPor", column = @Column(name = "DISPR_CREADO_POR")),
        @AttributeOverride(name = "fechaCreacion", column = @Column(name = "DISPR_FECHA_CREACION")),
        @AttributeOverride(name = "modificadoPor", column = @Column(name = "DISPR_MODIFICADO_POR")),
        @AttributeOverride(name = "fechaModificacion", column = @Column(name = "DISPR_FECHA_MODIFICACION"))
})
public class Provincia extends DatosBaseAuditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_SECT_PROVINCIA")
    @SequenceGenerator(name = "SEC_DIST_SECT_PROVINCIA", sequenceName = "SEC_DIST_SECT_PROVINCIA", allocationSize = 1)
    @Column(name = "DISPR_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DISPR_NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "DISPR_DESCRIPCION", length = 500)
    private String descripcion;

    @Column(name = "DISPR_ACTIVO", length = 20)
    private String activo;

}