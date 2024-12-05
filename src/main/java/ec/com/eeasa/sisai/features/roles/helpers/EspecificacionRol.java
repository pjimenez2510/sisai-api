package ec.com.eeasa.sisai.features.roles.helpers;

import ec.com.eeasa.sisai.features.roles.dtos.FiltroRolDto;
import ec.com.eeasa.sisai.features.roles.entities.Rol;
import ec.com.eeasa.sisai.shared.models.EspecificacionBase;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class EspecificacionRol extends EspecificacionBase<Rol, FiltroRolDto> {
    public EspecificacionRol(FiltroRolDto filter) {
        super(filter);
    }

    @Override
    public Predicate toPredicate(Root<Rol> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new java.util.ArrayList<>();
        addPredicateIfNotNull(predicates, createLikePredicate("descripcion", filter.getDescripcion(), root, criteriaBuilder));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void addPredicateIfNotNull(List<Predicate> predicates, Predicate predicate) {
        if (predicate != null) predicates.add(predicate);
    }
}
