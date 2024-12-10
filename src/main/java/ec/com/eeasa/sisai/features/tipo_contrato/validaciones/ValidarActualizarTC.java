package ec.com.eeasa.sisai.features.tipo_contrato.validaciones;

import org.springframework.stereotype.Component;

import ec.com.eeasa.sisai.features.tipo_contrato.entities.TipoContrato;
import ec.com.eeasa.sisai.shared.models.ValidacionBase;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ValidarActualizarTC extends ValidacionBase<TipoContrato> {
    private final String ERROR_INACTIVO = "No se puede actualizar un tipo de contrato inactivo";

    private final ValidarEstadoActivoTC validarEstadoActivoTC;
    private final ValidarNotNullTC validarNotNullTC;
    private final ValidarContratosAsociadosTC validarContratosAsociadosTC;

    @Override
    public void validar(TipoContrato tipoContrato) {
        validarNotNullTC.validar(tipoContrato);
        validarEstadoActivoTC.validar(tipoContrato, ERROR_INACTIVO);
        validarContratosAsociadosTC.validar(tipoContrato.getId());
    }

}