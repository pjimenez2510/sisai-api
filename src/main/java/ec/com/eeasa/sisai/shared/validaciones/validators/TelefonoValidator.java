package ec.com.eeasa.sisai.shared.validaciones.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ec.com.eeasa.sisai.shared.validaciones.TelefonoValido;

public class TelefonoValidator implements ConstraintValidator<TelefonoValido, String> {

    @Override
    public void initialize(TelefonoValido constraintAnnotation) {
    }

    @Override
    public boolean isValid(String telefono, ConstraintValidatorContext context) {
        if (telefono == null) {
            return true; // null es válido a menos que se use @NotNull
        }

        // Eliminar espacios en blanco
        telefono = telefono.trim();

        // Verificar longitud (7-10 dígitos)
        if (telefono.length() < 7 || telefono.length() > 10) {
            return false;
        }

        // Verificar que solo contenga números
        return telefono.matches("\\d+");
    }
}
