package ec.com.eeasa.sisai.features.tipo_contrato.dtos;

import ec.com.eeasa.sisai.features.tipo_contrato.entities.TipoContrato;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link TipoContrato}
 */
@Data
public class ActualizarTipoContratoDto implements Serializable {
    @NotNull(message = "El nombre es requerido")
    @Size(message = "El nombre debe tener entre 3 y 50 caracteres", min = 3, max = 50)
    @NotBlank(message = "El nombre no debe estar en blanco")
    String nombre;

    @Size(message = "La descripción debe tener como máximo 50 caracteres", max = 50)
    String descripcion;

    @NotNull(message = "El valor unitario es requerido")
    @Positive(message = "El valor unitario debe ser positivo")
    BigDecimal valorUnitario;
}