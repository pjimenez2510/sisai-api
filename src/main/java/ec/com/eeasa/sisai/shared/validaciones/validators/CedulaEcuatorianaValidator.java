package ec.com.eeasa.sisai.shared.validaciones.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ec.com.eeasa.sisai.shared.validaciones.CedulaEcuatoriana;

public class CedulaEcuatorianaValidator implements ConstraintValidator<CedulaEcuatoriana, String> {

    @Override
    public void initialize(CedulaEcuatoriana constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cedula, ConstraintValidatorContext context) {
        if (cedula == null || (cedula.length() != 13 && cedula.length() != 10)) {
            return false;
        }

        // Verificar que todos sean dígitos
        if (!cedula.matches("\\d+")) {
            return false;
        }

        // Verificar provincia (primeros dos dígitos)
        int provincia = Integer.parseInt(cedula.substring(0, 2));
        if (provincia < 1 || provincia > 24) {
            return false;
        }

        // Obtener el tipo de identificación (tercer dígito)
        int tipoIdentificacion = Integer.parseInt(cedula.substring(2, 3));

        // Validar según el tipo de contribuyente
        if (tipoIdentificacion == 9) {
            // Sociedades privadas o extranjeros
            return validarRucSociedad(cedula);
        } else if (tipoIdentificacion == 6) {
            // Entidades públicas
            return validarRucEntidadPublica(cedula);
        } else if (tipoIdentificacion < 6) {
            // Personas naturales
            return validarRucPersonaNatural(cedula);
        }

        return false;
    }

    private boolean validarRucPersonaNatural(String cedula) {
        int[] coeficientes = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
        return validarModulo10(cedula, coeficientes);
    }

    private boolean validarRucSociedad(String cedula) {
        int[] coeficientes = { 4, 3, 2, 7, 6, 5, 4, 3, 2 };
        return validarModulo11(cedula, coeficientes);
    }

    private boolean validarRucEntidadPublica(String cedula) {
        int[] coeficientes = { 3, 2, 7, 6, 5, 4, 3, 2 };
        return validarModulo11(cedula, coeficientes);
    }

    private boolean validarModulo10(String cedula, int[] coeficientes) {
        int suma = 0;
        for (int i = 0; i < coeficientes.length; i++) {
            int valor = Integer.parseInt(cedula.substring(i, i + 1)) * coeficientes[i];
            suma += valor > 9 ? valor - 9 : valor;
        }

        int digitoVerificador = Integer.parseInt(cedula.substring(9, 10));
        int resultado = 10 - (suma % 10);
        if (resultado == 10)
            resultado = 0;

        // Verificar los 3 últimos dígitos para RUC
        if (cedula.length() == 13) {
            return resultado == digitoVerificador &&
                    cedula.substring(10, 13).equals("001");
        }

        return resultado == digitoVerificador;
    }

    private boolean validarModulo11(String cedula, int[] coeficientes) {
        int suma = 0;
        for (int i = 0; i < coeficientes.length; i++) {
            suma += Integer.parseInt(cedula.substring(i, i + 1)) * coeficientes[i];
        }

        int digitoVerificador = Integer.parseInt(cedula.substring(9, 10));
        int resultado = 11 - (suma % 11);
        if (resultado == 11)
            resultado = 0;
        if (resultado == 10)
            return false;

        // Verificar los 3 últimos dígitos para RUC
        return resultado == digitoVerificador &&
                cedula.substring(10, 13).equals("001");
    }
}