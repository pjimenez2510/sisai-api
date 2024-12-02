package ec.com.eeasa.sisai.core.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.eeasa.sisai.shared.respuesta.GeneradorRespuesta;
import ec.com.eeasa.sisai.shared.respuesta.RespuestaGenerica;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Component
public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;
    private final GeneradorRespuesta generadorRespuesta;

    public AuthenticationEntryPointHandler(ObjectMapper objectMapper, GeneradorRespuesta generadorRespuesta) {
        this.objectMapper = objectMapper;
        this.generadorRespuesta = generadorRespuesta;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");

        RespuestaGenerica<Object> errorResponse = generadorRespuesta.buildErrorResponse("No autorizado",
                Collections.singletonList("Se requiere autenticación completa para acceder a este recurso."),
                HttpStatus.UNAUTHORIZED.value()).getBody();

        String jsonResponse = objectMapper.writeValueAsString(errorResponse);
        response.getWriter().write(jsonResponse);
    }
}