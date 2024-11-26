package ec.com.eeasa.sisai.features.usuarios.helpers;

import ec.com.eeasa.sisai.features.usuarios.dtos.FiltroUsuarioDto;
import ec.com.eeasa.sisai.features.usuarios.entities.Usuario;
import ec.com.eeasa.sisai.shared.filtros.EspecificacionBase;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class EspecificacionUsuario extends EspecificacionBase<Usuario, FiltroUsuarioDto> {
    public EspecificacionUsuario(FiltroUsuarioDto filter) {
        super(filter);
    }

    @Override
    public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new java.util.ArrayList<>();
        addPredicateIfNotNull(predicates, createLikePredicate("nombres", filter.getNombres(), root, criteriaBuilder));
        addPredicateIfNotNull(predicates, createLikePredicate("apellidos", filter.getApellidos(), root, criteriaBuilder));
        addPredicateIfNotNull(predicates, createLikePredicate("email", filter.getEmail(), root, criteriaBuilder));
        addPredicateIfNotNull(predicates, createLikePredicate("cedula", filter.getCedula(), root, criteriaBuilder));
        addPredicateIfNotNull(predicates, createLikePredicate("codigoUnico", filter.getCodigoUnico(), root, criteriaBuilder));
        addPredicateIfNotNull(predicates, createLikePredicate("nombreUsuario", filter.getNombreUsuario(), root, criteriaBuilder));
        addPredicateIfNotNull(predicates, createLikePredicate("departamento", filter.getDepartamento(), root, criteriaBuilder));
        addPredicateIfNotNull(predicates, createLikePredicate("seccion", filter.getSeccion(), root, criteriaBuilder));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void addPredicateIfNotNull(List<Predicate> predicates, Predicate predicate) {
        if (predicate != null) predicates.add(predicate);
    }
}
