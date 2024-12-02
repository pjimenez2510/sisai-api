package ec.com.eeasa.sisai.features.auth.exceptions;

import ec.com.eeasa.sisai.shared.excepciones.ExcepcionBase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NoAutenticado extends ExcepcionBase {
    public NoAutenticado(String message) {
        super(
                "No autenticado",
                message,
               HttpStatus.FORBIDDEN
        );
    }
}
