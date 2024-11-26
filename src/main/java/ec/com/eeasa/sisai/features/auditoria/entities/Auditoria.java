package ec.com.eeasa.sisai.features.auditoria.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DIST_AUD_AUDITORIA", schema = "ROOTSISAI")
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_AUD_AUDITORIA")
    @SequenceGenerator(name = "SEC_DIST_AUD_AUDITORIA", sequenceName = "SEC_DIST_AUD_AUDITORIA", allocationSize = 1)
    @Column(name = "DISAU_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DISAU_TABLA", nullable = false, length = 100)
    private String disauTabla;

    @Column(name = "DISAU_OPERACION", nullable = false, length = 20)
    private String disauOperacion;

    @Column(name = "DISAU_CODIGO_REGISTRO", nullable = false, length = 100)
    private String disauCodigoRegistro;

    @Column(name = "DISAU_FECHA_OPERACION", nullable = false)
    private Instant disauFechaOperacion;

    @Column(name = "DISAU_USUARIO", nullable = false, length = 100)
    private String disauUsuario;

}