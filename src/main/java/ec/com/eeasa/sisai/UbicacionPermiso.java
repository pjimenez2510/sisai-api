package ec.com.eeasa.sisai;

import ec.com.eeasa.sisai.features.sectores.entities.Provincia;
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
@Table(name = "DIST_USU_UBICACION_PERMISO")
public class UbicacionPermiso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIST_USU_UBICACION_PERMISO_id_gen")
    @SequenceGenerator(name = "DIST_USU_UBICACION_PERMISO_id_gen", sequenceName = "SEC_DIST_USU_UBICACION_PERMISO", allocationSize = 1)
    @Column(name = "DUUP_CODIGO", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DIUSU_CODIGO_USUARIO", nullable = false)
    private Usuario codigoUsuario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DISPR_CODIGO_PROVINCIA", nullable = false)
    private Provincia codigoProvincia;

    @Size(max = 20)
    @Column(name = "DUUP_ACTIVO", length = 20)
    private String activo;

    @Size(max = 100)
    @Column(name = "DUUP_CREADO_POR", length = 100)
    private String creadoPor;

    @Column(name = "DUUP_FECHA_CREACION")
    private Instant fechaCreacion;

    @Size(max = 100)
    @Column(name = "DUUP_MODIFICADO_POR", length = 100)
    private String modificadoPor;

    @Column(name = "DUUP_FECHA_MODIFICACION")
    private Instant fechaModificacion;

}