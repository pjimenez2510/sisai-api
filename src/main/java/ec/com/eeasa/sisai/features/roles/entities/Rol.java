package ec.com.eeasa.sisai.features.roles.entities;

import ec.com.eeasa.sisai.features.auditoria.entities.DatosBaseAuditoria;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "DIST_USU_ROL", schema = "ROOTSISAI")
@AttributeOverrides({
        @AttributeOverride(name = "creadoPor", column = @Column(name = "DUROL_CREADO_POR")),
        @AttributeOverride(name = "fechaCreacion", column = @Column(name = "DUROL_FECHA_CREACION")),
        @AttributeOverride(name = "modificadoPor", column = @Column(name = "DUROL_MODIFICADO_POR")),
        @AttributeOverride(name = "fechaModificacion", column = @Column(name = "DUROL_FECHA_MODIFICACION"))
})
public class Rol extends DatosBaseAuditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_USU_ROL")
    @SequenceGenerator(name = "SEC_DIST_USU_ROL", sequenceName = "SEC_DIST_USU_ROL", allocationSize = 1)
    @Column(name = "DUROL_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DUROL_DESCRIPCION", length = 50)
    private String descripcion;

    @Column(name = "DUROL_ACTIVO", length = 20)
    private String activo;

}