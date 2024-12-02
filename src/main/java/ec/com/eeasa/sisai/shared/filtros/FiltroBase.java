package ec.com.eeasa.sisai.shared.filtros;

import ec.com.eeasa.sisai.shared.constantes.PaginacionOpciones;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;

@Data
public class FiltroBase {
    @Parameter(description = "Pagina actual")
    private Integer pagina = PaginacionOpciones.DEFAULT_PAGE;

    @Parameter(description = "Elementos por pagina")
    private Integer elementosPorPagina = PaginacionOpciones.DEFAULT_SIZE;

    @Parameter(description = "Campo por el cual se ordena")
    private String ordenarPor = PaginacionOpciones.DEFAULT_SORT;

    @Parameter(description = "Direccion del ordenamiento")
    private String direccionOrdenamiento = PaginacionOpciones.DEFAULT_SORT_DIRECCION;
}
