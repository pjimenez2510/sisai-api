package ec.com.eeasa.sisai.shared.models;

public abstract class ValidacionBase<T> {
    public abstract void validar(T contexto);
}
