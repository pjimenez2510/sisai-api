package ec.com.eeasa.sisai.features.permisos.helpers;

import ec.com.eeasa.sisai.features.permisos.dtos.FiltroPermisoDto;
import ec.com.eeasa.sisai.features.permisos.entities.Permiso;
import ec.com.eeasa.sisai.shared.models.EspecificacionBase;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EspecificacionPermiso extends EspecificacionBase<Permiso, FiltroPermisoDto> {

    public EspecificacionPermiso(FiltroPermisoDto filter) {
        super(filter);
    }

    @Override
    public Predicate toPredicate(Root<Permiso> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        List<Predicate> predicates = new ArrayList<>();

        addPredicateIfNotNull(predicates, createLikePredicate("accion", filter.getAccion(), root, cb));
        addPredicateIfNotNull(predicates, createLikePredicate("recurso", filter.getRecurso(), root, cb));
        addPredicateIfNotNull(predicates, createLikePredicate("descripcion", filter.getDescripcion(), root, cb));

        return cb.and(predicates.toArray(new Predicate[0]));

    }

    private void addPredicateIfNotNull(List<Predicate> predicates, Predicate predicate) {
        if (predicate != null) predicates.add(predicate);
    }
}
