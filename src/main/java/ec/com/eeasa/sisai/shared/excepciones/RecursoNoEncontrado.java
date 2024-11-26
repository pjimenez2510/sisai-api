package ec.com.eeasa.sisai.shared.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNoEncontrado extends ExcepcionBase {
    public RecursoNoEncontrado(String resource, String field, String value) {
        super(
                "Recurso no encontrado",
                String.format("%s no encontrado con %s: %s", resource, field, value),
                HttpStatus.NOT_FOUND
        );
    }
}
