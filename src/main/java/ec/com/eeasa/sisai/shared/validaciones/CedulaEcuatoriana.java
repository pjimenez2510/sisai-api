package ec.com.eeasa.sisai.shared.validaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ec.com.eeasa.sisai.shared.validaciones.validators.CedulaEcuatorianaValidator;

@Documented
@Constraint(validatedBy = CedulaEcuatorianaValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CedulaEcuatoriana {
    String message() default "Cédula inválida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}