package ec.com.eeasa.sisai.features.tipo_contrato.validaciones;

import org.springframework.stereotype.Component;

import ec.com.eeasa.sisai.features.contratos.entities.ContratoRepository;
import ec.com.eeasa.sisai.shared.excepciones.Conflicto;
import ec.com.eeasa.sisai.shared.models.ValidacionBase;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ValidarEliminarTipoContrato extends ValidacionBase<Long> {

    private final ContratoRepository contratoRepository;

    @Override
    public void validar(Long id) {
        if (contratoRepository.existsByDictpCodigoTipoContrato_Id(id)) {
            throw new Conflicto(String.format("No se puede eliminar el tipo de contrato con id %d porque tiene contratos asociados", id));
        }
    }

}
