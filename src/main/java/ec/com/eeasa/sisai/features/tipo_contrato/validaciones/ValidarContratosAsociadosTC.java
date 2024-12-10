package ec.com.eeasa.sisai.features.tipo_contrato.validaciones;

import org.springframework.stereotype.Component;

import ec.com.eeasa.sisai.features.contratos.entities.ContratoRepository;
import ec.com.eeasa.sisai.shared.excepciones.Conflicto;
import ec.com.eeasa.sisai.shared.models.ValidacionBase;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ValidarContratosAsociadosTC extends ValidacionBase<Long> {

    private final String DEFAULT_MESSAGE = "No se puede realizar la acción, el tipo de contrato con id %d tiene contratos asociados";
    private final ContratoRepository contratoRepository;

    @Override
    public void validar(Long idTipoContrato) {
        if (contratoRepository.existsByDictpCodigoTipoContrato_Id(idTipoContrato)) {
            throw new Conflicto(String.format(DEFAULT_MESSAGE, idTipoContrato));
        }
    }

}
