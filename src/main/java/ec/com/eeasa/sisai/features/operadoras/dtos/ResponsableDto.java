package ec.com.eeasa.sisai.features.operadoras.dtos;

import ec.com.eeasa.sisai.features.operadoras.entities.Responsable;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Responsable}
 */
@Value
public class ResponsableDto implements Serializable {
    Long id;
    String nombres;
    String apellidos;
    String email;
    String telefono;
}