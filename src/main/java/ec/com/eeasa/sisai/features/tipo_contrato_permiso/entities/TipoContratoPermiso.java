package ec.com.eeasa.sisai.features.tipo_contrato_permiso.entities;

import ec.com.eeasa.sisai.features.tipo_contrato.entities.TipoContrato;
import ec.com.eeasa.sisai.features.usuarios.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_USU_TIPO_CONTRATO_PERMISO")
public class TipoContratoPermiso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIST_USU_TIPO_CONTRATO_PERMISO_id_gen")
    @SequenceGenerator(name = "DIST_USU_TIPO_CONTRATO_PERMISO_id_gen", sequenceName = "SEC_DIST_USU_TIPO_CONTRATO_PERMISO", allocationSize = 1)
    @Column(name = "DUTC_CODIGO", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DIUSU_CODIGO_USUARIO", nullable = false)
    private Usuario codigoUsuario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DICTP_CODIGO_TIPO_CONTRATO", nullable = false)
    private TipoContrato codigoTipoContrato;

    @Size(max = 20)
    @Column(name = "DUTC_ACTIVO", length = 20)
    private String activo;

    @Size(max = 100)
    @Column(name = "DUTC_CREADO_POR", length = 100)
    private String creadoPor;

    @Column(name = "DUTC_FECHA_CREACION")
    private Instant fechaCreacion;

    @Size(max = 100)
    @Column(name = "DUTC_MODIFICADO_POR", length = 100)
    private String modificadoPor;

    @Column(name = "DUTC_FECHA_MODIFICACION")
    private Instant fechaModificacion;

}