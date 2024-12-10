package ec.com.eeasa.sisai.features.operadoras.dtos;

import ec.com.eeasa.sisai.features.operadoras.entities.Operadora;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Operadora}
 */
@Value
public class OperadoraDto implements Serializable {
    Long id;
    String nombre;
    String ruc;
    String telefono1;
    String telefono2;
    String direccion;
    String observacion;
    String email;
    Set<ResponsableDto> responsables;
}