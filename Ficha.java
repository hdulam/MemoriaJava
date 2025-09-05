public class Ficha {
    private String simbolo;
    private boolean visible;
    private boolean emparejada;

    public Ficha(String simbolo) {
        this.simbolo = simbolo;
        this.visible = false;
        this.emparejada = false;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isEmparejada() {
        return emparejada;
    }

    public void mostrar() {
        this.visible = true;
    }

    public void ocultar() {
        if (!emparejada) {
            this.visible = false;
        }
    }

    public void marcarEmparejada() {
        this.emparejada = true;
    }

    public boolean esIgual(Ficha otra) {
        return this.simbolo.equals(otra.simbolo);
    }

    @Override
    public String toString() {
        if (emparejada) return "✔";   // ya emparejada
        if (visible) return simbolo;  // visible
        return "■";                   // oculta
    }
}
