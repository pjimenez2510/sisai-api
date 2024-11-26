package ec.com.eeasa.sisai.features.roles.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_USU_ROL", schema = "ROOTSISAI")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_USU_ROL")
    @SequenceGenerator(name = "SEC_DIST_USU_ROL", sequenceName = "SEC_DIST_USU_ROL", allocationSize = 1)
    @Column(name = "DUROL_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DUROL_DESCRIPCION", length = 50)
    private String descripcion;

    @Column(name = "DUROL_ACTIVO", length = 20)
    private String activo;

    @Column(name = "DUROL_CREADO_POR", length = 100)
    private String creadoPor;

    @Column(name = "DUROL_FECHA_CREACION")
    private Instant fechaCreacion;

    @Column(name = "DUROL_MODIFICADO_POR", length = 100)
    private String modificadoPor;

    @Column(name = "DUROL_FECHA_MODIFICACION")
    private Instant fechaModificacion;

}