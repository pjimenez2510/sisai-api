package ec.com.eeasa.sisai.features.tipo_contrato.validaciones;

import org.springframework.stereotype.Component;

import ec.com.eeasa.sisai.shared.models.ValidacionBase;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ValidarEliminarTC extends ValidacionBase<Long> {
    private final ValidarNotNullTC validarNotNullTC;
    private final ValidarContratosAsociadosTC validarContratosAsociadosTC;
    private final ValidarUsuariosAsociadosTC validarUsuariosAsociadosTC;

    @Override
    public void validar(Long id) {
        validarNotNullTC.validar(id);
        validarContratosAsociadosTC.validar(id);
        validarUsuariosAsociadosTC.validar(id);
    }

}