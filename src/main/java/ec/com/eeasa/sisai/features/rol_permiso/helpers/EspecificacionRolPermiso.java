package ec.com.eeasa.sisai.features.rol_permiso.helpers;

import ec.com.eeasa.sisai.features.rol_permiso.dtos.FiltroRolPermisoDto;
import ec.com.eeasa.sisai.features.rol_permiso.entities.RolPermiso;
import ec.com.eeasa.sisai.shared.filtros.EspecificacionBase;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EspecificacionRolPermiso extends EspecificacionBase<RolPermiso, FiltroRolPermisoDto> {
    public EspecificacionRolPermiso(FiltroRolPermisoDto filter) {
        super(filter);
    }

    @Override
    public Predicate toPredicate(Root<RolPermiso> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
