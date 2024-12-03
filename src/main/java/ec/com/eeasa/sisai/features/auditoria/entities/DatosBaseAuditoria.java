package ec.com.eeasa.sisai.features.auditoria.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class DatosBaseAuditoria {
    @CreatedBy
    private String creadoPor;

    @CreatedDate
    private Instant fechaCreacion;

    @LastModifiedBy
    private String modificadoPor;

    @LastModifiedDate
    private Instant fechaModificacion;

}
