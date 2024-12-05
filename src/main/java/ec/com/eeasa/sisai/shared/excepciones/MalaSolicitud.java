package ec.com.eeasa.sisai.shared.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MalaSolicitud extends ExcepcionBase {
    public MalaSolicitud(String message) {
        super(
                "Mala solicitud",
                message,
                HttpStatus.BAD_REQUEST
        );
    }
}
