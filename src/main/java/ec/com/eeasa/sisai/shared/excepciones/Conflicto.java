package ec.com.eeasa.sisai.shared.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class Conflicto extends ExcepcionBase {
  public Conflicto(String message) {
    super("Existe un conflicto", message, HttpStatus.CONFLICT);
  }
}
