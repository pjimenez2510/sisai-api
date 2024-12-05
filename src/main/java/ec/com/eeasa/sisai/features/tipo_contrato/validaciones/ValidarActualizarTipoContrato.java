package ec.com.eeasa.sisai.features.tipo_contrato.validaciones;

import org.springframework.stereotype.Component;

import ec.com.eeasa.sisai.features.contratos.entities.ContratoRepository;
import ec.com.eeasa.sisai.features.tipo_contrato.entities.TipoContrato;
import ec.com.eeasa.sisai.shared.constantes.Estado;
import ec.com.eeasa.sisai.shared.excepciones.Conflicto;
import ec.com.eeasa.sisai.shared.excepciones.MalaSolicitud;
import ec.com.eeasa.sisai.shared.models.ValidacionBase;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ValidarActualizarTipoContrato extends ValidacionBase<TipoContrato> {

    private final ContratoRepository contratoRepository;

    @Override
    public void validar(TipoContrato tipoContrato) {
        if (!tipoContrato.getActivo().equals(Estado.ACTIVO)) {
            throw new MalaSolicitud("No se puede actualizar un tipo de contrato inactivo");
        }
        if (contratoRepository.existsByDictpCodigoTipoContrato_Id(tipoContrato.getId())) {
            throw new Conflicto(String
                    .format("No se puede actualizar el tipo de contrato con id %d porque tiene contratos asociados",
                            tipoContrato.getId()));
        }
    }

}
