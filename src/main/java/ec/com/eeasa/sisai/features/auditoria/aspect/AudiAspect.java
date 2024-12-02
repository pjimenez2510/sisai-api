package ec.com.eeasa.sisai.features.auditoria.aspect;

import ec.com.eeasa.sisai.features.auditoria.anotaciones.Auditable;
import ec.com.eeasa.sisai.features.auditoria.entities.Auditoria;
import ec.com.eeasa.sisai.features.auditoria.services.AuditoriaService;
import ec.com.eeasa.sisai.features.auth.entities.CustomUserDetails;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Instant;

@Aspect
@Component
@AllArgsConstructor
public class AudiAspect {

    private AuditoriaService auditService;

    @Pointcut(value = "@annotation(ec.com.eeasa.sisai.features.auditoria.anotaciones.Auditable)")
    public void auditableMethod() {}

    @AfterReturning(pointcut = "auditableMethod()", returning = "result")
    public void auditMethod(JoinPoint joinPoint, Object result) {
        String username = ((CustomUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getUsername();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Auditable auditable = signature.getMethod().getAnnotation(Auditable.class);

        Auditoria audit = Auditoria.builder()
                .tabla(auditable.tabla())
                .operacion(auditable.operacion())
                .codigoRegistro(extractId(result))
                .fechaOperacion(Instant.now())
                .usuario(username)
                .build();

        auditService.crear(audit);
    }

    private String extractId(Object result) {
        if (result == null) {
            return "N/A";
        }
        try {
            Method getIdMethod = result.getClass().getMethod("getId");
            Object id = getIdMethod.invoke(result);
            System.out.println(id);
            return id != null ? id.toString() : "N/A";
        } catch (Exception e) {
            return "N/A";
        }
    }

}
