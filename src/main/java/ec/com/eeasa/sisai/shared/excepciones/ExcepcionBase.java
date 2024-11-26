package ec.com.eeasa.sisai.shared.excepciones;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExcepcionBase extends RuntimeException {
    private final String title;
    private final HttpStatus status;

    public ExcepcionBase(String title, String message, HttpStatus status) {
        super(message);
        this.title = title;
        this.status = status;
    }
}