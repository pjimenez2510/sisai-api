package ec.com.eeasa.sisai.features.tipo_contrato.validaciones;

import org.springframework.stereotype.Component;

import ec.com.eeasa.sisai.features.tipo_contrato_permiso.repositories.TipoContratoPermisoRepository;
import ec.com.eeasa.sisai.shared.excepciones.Conflicto;
import ec.com.eeasa.sisai.shared.models.ValidacionBase;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ValidarUsuariosAsociadosTC extends ValidacionBase<Long> {

    private static final String DEFAULT_MESSAGE = "No se puede realizar la acción el tipo de contrato con id %d tiene usuarios asociados";
    private final TipoContratoPermisoRepository tipoContratoPermisoRepository;

    @Override
    public void validar(Long idTipoContrato) {
        if (tipoContratoPermisoRepository.existsByCodigoTipoContrato_Id(idTipoContrato)) {
            throw new Conflicto(String.format(DEFAULT_MESSAGE, idTipoContrato));
        }

    }

}
