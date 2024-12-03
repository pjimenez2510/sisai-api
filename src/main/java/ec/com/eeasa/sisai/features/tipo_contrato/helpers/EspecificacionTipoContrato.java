package ec.com.eeasa.sisai.features.tipo_contrato.helpers;

import ec.com.eeasa.sisai.features.tipo_contrato.dtos.FiltroTipoContratoDto;
import ec.com.eeasa.sisai.features.tipo_contrato.entities.TipoContrato;
import ec.com.eeasa.sisai.shared.filtros.EspecificacionBase;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class EspecificacionTipoContrato extends EspecificacionBase<TipoContrato, FiltroTipoContratoDto> {
    public EspecificacionTipoContrato(FiltroTipoContratoDto filter) {
        super(filter);
    }

    @Override
    public Predicate toPredicate(Root<TipoContrato> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new java.util.ArrayList<>();
        addPredicateIfNotNull(predicates,
                createLikePredicate("nombre", filter.getNombre(), root, criteriaBuilder));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void addPredicateIfNotNull(List<Predicate> predicates, Predicate predicate) {
        if (predicate != null)
            predicates.add(predicate);
    }
}
