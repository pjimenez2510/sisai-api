package ec.com.eeasa.sisai.features.provincia.dtos;

import ec.com.eeasa.sisai.features.provincia.entities.Provincia;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Provincia}
 */
@Setter
@Getter
@AllArgsConstructor
public class ProvinciaDto implements Serializable {
    Long id;
    String nombre;
    String descripcion;
}