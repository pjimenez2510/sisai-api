package ec.com.eeasa.sisai.shared.respuesta;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MetaData {
    private int paginaActual;
    private int totalPaginas;
    private long totalElementos;
    private int elementosPorPagina;
}