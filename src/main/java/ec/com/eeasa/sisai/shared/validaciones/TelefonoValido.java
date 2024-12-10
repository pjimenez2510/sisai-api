package ec.com.eeasa.sisai.shared.validaciones;

import javax.validation.Constraint;
import javax.validation.Payload;

import ec.com.eeasa.sisai.shared.validaciones.validators.TelefonoValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TelefonoValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface TelefonoValido {
    String message() default "Formato de teléfono inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}