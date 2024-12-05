package ec.com.eeasa.sisai.shared.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RespuestaGenerica<T> {
    private int estado;
    private T datos;
    private String mensage;
    private List<String> errores;
    private MetaData metadatos;
}