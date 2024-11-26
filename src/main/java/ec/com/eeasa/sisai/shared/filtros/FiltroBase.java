package ec.com.eeasa.sisai.shared.filtros;

import ec.com.eeasa.sisai.shared.constantes.ConstantesPaginacion;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;

@Data
public class FiltroBase {
    @Parameter(description = "Pagina actual")
    private Integer pagina = ConstantesPaginacion.DEFAULT_PAGE;

    @Parameter(description = "Elementos por pagina")
    private Integer elementosPorPagina = ConstantesPaginacion.DEFAULT_SIZE;

    @Parameter(description = "Campo por el cual se ordena")
    private String ordenarPor = ConstantesPaginacion.DEFAULT_SORT;

    @Parameter(description = "Direccion del ordenamiento")
    private String direccionOrdenamiento = ConstantesPaginacion.DEFAULT_SORT_DIRECCION;
}
