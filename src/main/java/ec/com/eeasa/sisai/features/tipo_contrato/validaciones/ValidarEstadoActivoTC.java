package ec.com.eeasa.sisai.features.tipo_contrato.validaciones;

import org.springframework.stereotype.Component;

import ec.com.eeasa.sisai.features.tipo_contrato.entities.TipoContrato;
import ec.com.eeasa.sisai.shared.constantes.Estado;
import ec.com.eeasa.sisai.shared.excepciones.MalaSolicitud;
import ec.com.eeasa.sisai.shared.models.ValidacionBase;

@Component
public class ValidarEstadoActivoTC extends ValidacionBase<TipoContrato> {

    private static final String DEFAULT_MESSAGE = "No se puede realizar la acción, el Tipo de contrato esta inactivo";

    @Override
    public void validar(TipoContrato contexto) {
        validar(contexto, DEFAULT_MESSAGE);
    }

    public void validar(TipoContrato contexto, String mensaje) {
        if (!contexto.getActivo().equals(Estado.ACTIVO)) {
            throw new MalaSolicitud(mensaje);
        }
    }

}
