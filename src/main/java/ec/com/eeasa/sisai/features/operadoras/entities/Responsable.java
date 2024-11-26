package ec.com.eeasa.sisai.features.operadoras.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_OPE_RESPONSABLE", schema = "ROOTSISAI")
public class Responsable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_OPE_RESPONSABLE")
    @SequenceGenerator(name = "SEC_DIST_OPE_RESPONSABLE", sequenceName = "SEC_DIST_OPE_RESPONSABLE", allocationSize = 1)
    @Column(name = "DORES_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DORES_NOMBRES", nullable = false, length = 100)
    private String doresNombres;

    @Column(name = "DORES_APELLIDOS", nullable = false, length = 100)
    private String doresApellidos;

    @Column(name = "DORES_EMAIL", nullable = false, length = 100)
    private String doresEmail;

    @Column(name = "DORES_TELEFONO", length = 15)
    private String doresTelefono;

    @Column(name = "DORES_ACTIVO", length = 20)
    private String doresActivo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DISOP_CODIGO_OPERADORA", nullable = false)
    private Operadora disopCodigoOperadora;

    @Column(name = "DORES_CREADO_POR", length = 100)
    private String doresCreadoPor;

    @Column(name = "DORES_FECHA_CREACION")
    private Instant doresFechaCreacion;

    @Column(name = "DORES_MODIFICADO_POR", length = 100)
    private String doresModificadoPor;

    @Column(name = "DORES_FECHA_MODIFICACION")
    private Instant doresFechaModificacion;

}