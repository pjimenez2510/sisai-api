package ec.com.eeasa.sisai.features.auditoria.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DIST_AUD_AUDITORIA", schema = "ROOTSISAI")
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DIST_AUD_AUDITORIA")
    @SequenceGenerator(name = "SEC_DIST_AUD_AUDITORIA", sequenceName = "SEC_DIST_AUD_AUDITORIA", allocationSize = 1)
    @Column(name = "DISAU_CODIGO", nullable = false)
    private Long id;

    @Column(name = "DISAU_TABLA", nullable = false, length = 100)
    private String tabla;

    @Column(name = "DISAU_OPERACION", nullable = false, length = 20)
    private String operacion;

    @Column(name = "DISAU_CODIGO_REGISTRO", nullable = false, length = 100)
    private String codigoRegistro;

    @Column(name = "DISAU_FECHA_OPERACION", nullable = false)
    private Instant fechaOperacion;

    @Column(name = "DISAU_USUARIO", nullable = false, length = 100)
    private String usuario;

}