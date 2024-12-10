package ec.com.eeasa.sisai.features.provincia.repositories;

import ec.com.eeasa.sisai.features.provincia.dtos.FiltroProvinciaDto;
import ec.com.eeasa.sisai.features.provincia.entities.Provincia;
import ec.com.eeasa.sisai.shared.constantes.Estado;
import ec.com.eeasa.sisai.shared.models.EspecificacionBase;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class EspecificacionProvincia extends EspecificacionBase<Provincia, FiltroProvinciaDto> {
    public EspecificacionProvincia(FiltroProvinciaDto filter) {
        super(filter);
    }

    @Override
    public Predicate toPredicate(Root<Provincia> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new java.util.ArrayList<>();
        String estado = filter.getEstado().equals(Estado.INACTIVO) ? Estado.INACTIVO : Estado.ACTIVO;
        addPredicateIfNotNull(predicates,
                createLikePredicate("nombre", filter.getNombre(), root, criteriaBuilder));
        addPredicateIfNotNull(predicates,
                createPredicate("activo", estado,
                        root, criteriaBuilder));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void addPredicateIfNotNull(List<Predicate> predicates, Predicate predicate) {
        if (predicate != null)
            predicates.add(predicate);
    }
}
