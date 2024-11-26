package ec.com.eeasa.sisai.features.operadoras.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_OPE_OPERADORA", schema = "ROOTSISAI")
public class Operadora {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_OPE_OPERADORA")
    @SequenceGenerator(name = "SEC_DIST_OPE_OPERADORA", sequenceName = "SEC_DIST_OPE_OPERADORA", allocationSize = 1)
    @Column(name = "DISOP_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DISOP_NOMBRE", nullable = false, length = 200)
    private String disopNombre;

    @Column(name = "DISOP_RUC", nullable = false, length = 15)
    private String disopRuc;

    @Column(name = "DISOP_TELEFONO1", length = 15)
    private String disopTelefono1;

    @Column(name = "DISOP_TELEFONO2", length = 15)
    private String disopTelefono2;

    @Column(name = "DISOP_DIRECCION", nullable = false, length = 250)
    private String disopDireccion;

    @Column(name = "DISOP_OBSERVACION", length = 500)
    private String disopObservacion;

    @Column(name = "DISOP_ACTIVO", length = 20)
    private String disopActivo;

    @Column(name = "DISOP_EMAIL", nullable = false, length = 100)
    private String disopEmail;

    @Column(name = "DISOP_CREADO_POR", length = 100)
    private String disopCreadoPor;

    @Column(name = "DISOP_FECHA_CREACION")
    private Instant disopFechaCreacion;

    @Column(name = "DISOP_MODIFICADO_POR", length = 100)
    private String disopModificadoPor;

    @Column(name = "DISOP_FECHA_MODIFICACION")
    private Instant disopFechaModificacion;

}