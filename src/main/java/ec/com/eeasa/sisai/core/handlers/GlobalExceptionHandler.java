package ec.com.eeasa.sisai.core.handlers;

import ec.com.eeasa.sisai.features.auth.exceptions.NoAutenticado;
import ec.com.eeasa.sisai.shared.excepciones.MalaSolicitud;
import ec.com.eeasa.sisai.shared.excepciones.RecursoNoEncontrado;
import ec.com.eeasa.sisai.shared.models.RespuestaGenerica;
import ec.com.eeasa.sisai.shared.utils.GeneradorRespuesta;
import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private final GeneradorRespuesta generadorRespuesta;

    public GlobalExceptionHandler(GeneradorRespuesta generadorRespuesta) {
        this.generadorRespuesta = generadorRespuesta;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespuestaGenerica<Object>> handleException(Exception ex) {
        log.error("Error no controlado", ex);
        return generadorRespuesta.buildErrorResponse("Error interno del servidor",
                Collections.singletonList(ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(RecursoNoEncontrado.class)
    public ResponseEntity<RespuestaGenerica<Object>> handleResourceNotFound(RecursoNoEncontrado ex) {
        return generadorRespuesta.buildErrorResponse(ex.getTitle(), Collections.singletonList(ex.getMessage()),
                ex.getStatus().value());
    }

    @ExceptionHandler(MalaSolicitud.class)
    public ResponseEntity<RespuestaGenerica<Object>> handleBadRequest(MalaSolicitud ex) {
        return generadorRespuesta.buildErrorResponse(ex.getTitle(), Collections.singletonList(ex.getMessage()),
                ex.getStatus().value());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RespuestaGenerica<Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        return generadorRespuesta.buildErrorResponse("Validation error", errors, HttpStatus.BAD_REQUEST.value());
    }

    // AUTH

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<RespuestaGenerica<Object>> handleAccessDeniedException(AccessDeniedException ex) {
        return generadorRespuesta.buildErrorResponse("Acceso denegado", Collections.singletonList("No tiene permisos para acceder a este recurso."),
                HttpStatus.FORBIDDEN.value());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<RespuestaGenerica<Object>> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        return generadorRespuesta.buildErrorResponse("Usuario no encontrado",
                Collections.singletonList(ex.getMessage()),
                HttpStatus.UNAUTHORIZED.value());
    }

    @ExceptionHandler(NoAutenticado.class)
    public ResponseEntity<RespuestaGenerica<Object>> handleNoAutenticado(NoAutenticado ex) {
        return generadorRespuesta.buildErrorResponse("No autenticado", Collections.singletonList(ex.getMessage()),
                ex.getStatus().value());
    }

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<RespuestaGenerica<Object>> handleMalformedJwtException(MalformedJwtException ex) {
        return generadorRespuesta.buildErrorResponse("Token mal formado", Collections.singletonList(ex.getMessage()),
                HttpStatus.UNAUTHORIZED.value());
    }

}
