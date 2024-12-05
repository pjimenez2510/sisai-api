package ec.com.eeasa.sisai.shared.utils;

import ec.com.eeasa.sisai.shared.models.MetaData;
import ec.com.eeasa.sisai.shared.models.RespuestaGenerica;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneradorRespuesta {
    public <T> ResponseEntity<RespuestaGenerica<T>> buildResponse(T data, int status, String message) {
        return ResponseEntity.ok(RespuestaGenerica.<T>builder()
                .estado(status)
                .datos(data)
                .mensage(message)
                .build());
    }

    public <T> ResponseEntity<RespuestaGenerica<T>> buildPagedResponse(Page<T> page, String message) {
        MetaData metadata = MetaData.builder()
                .paginaActual(page.getNumber())
                .totalPaginas(page.getTotalPages())
                .totalElementos(page.getTotalElements())
                .elementosPorPagina(page.getSize())
                .build();

        return ResponseEntity.ok(RespuestaGenerica.<T>builder()
                .estado(HttpStatus.OK.value())
                .datos((T) page.getContent())
                .mensage(message)
                .metadatos(metadata)
                .build());
    }

    public ResponseEntity<RespuestaGenerica<Object>> buildErrorResponse(String message, List<String> errors, int status) {
        return ResponseEntity.status(status).body(RespuestaGenerica.builder()
                .estado(status)
                .mensage(message)
                .errores(errors)
                .build());
    }
}
