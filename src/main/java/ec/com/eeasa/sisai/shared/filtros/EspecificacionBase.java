package ec.com.eeasa.sisai.shared.filtros;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class EspecificacionBase<T, F extends FiltroBase> implements Specification<T> {
    protected final F filter;

    public EspecificacionBase(F filter) {
        this.filter = filter;
    }

    protected Predicate createPredicate(String nombreCampo, Object valor, Root<T> root, CriteriaBuilder cb) {
        if (valor == null) return null;
        return cb.equal(root.get(nombreCampo), valor);
    }

    protected Predicate createLikePredicate(String nombreCampo, String valor, Root<T> root, CriteriaBuilder cb) {
        if (valor == null) return null;
        return cb.like(cb.lower(root.get(nombreCampo)), "%" + valor.toLowerCase() + "%");
    }
}