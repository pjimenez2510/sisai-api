package ec.com.eeasa.sisai.shared.excepciones;

import org.springframework.http.HttpStatus;

public class MalaSolicitud extends ExcepcionBase {
    public MalaSolicitud(String message) {
        super(
                "Mala solicitud",
                message,
                HttpStatus.BAD_REQUEST
        );
    }
}
