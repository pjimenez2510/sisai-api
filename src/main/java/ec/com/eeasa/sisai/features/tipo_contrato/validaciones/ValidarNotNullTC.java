package ec.com.eeasa.sisai.features.tipo_contrato.validaciones;

import org.springframework.stereotype.Component;

import ec.com.eeasa.sisai.features.tipo_contrato.entities.TipoContrato;
import ec.com.eeasa.sisai.shared.excepciones.MalaSolicitud;
import ec.com.eeasa.sisai.shared.models.ValidacionBase;

@Component
public class ValidarNotNullTC extends ValidacionBase<TipoContrato> {

    private static final String DEFAULT_MESSAGE = "El tipo de contrato no puede ser nulo";

    @Override
    public void validar(TipoContrato contexto) {
        if (contexto == null) {
            throw new MalaSolicitud(DEFAULT_MESSAGE);
        }
    }

    public void validar(Long id) {
        if (id == null) {
            throw new MalaSolicitud("El id del tipo de contrato no puede ser nulo");
        }
    }

}
