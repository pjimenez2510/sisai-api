package ec.com.eeasa.sisai.utils;

import ec.com.eeasa.sisai.shared.filtros.FiltroBase;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PaginacionUtils {
    public static PageRequest crearPageRequest(FiltroBase filtro) {
        return PageRequest.of(
                filtro.getPagina(),
                filtro.getElementosPorPagina(),
                filtro.getDireccionOrdenamiento().equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC,
                filtro.getOrdenarPor());
    }
}
