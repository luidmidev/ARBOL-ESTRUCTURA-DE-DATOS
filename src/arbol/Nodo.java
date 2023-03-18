package arbol;

public class Nodo <T extends Comparable> {
    
    private T dato;
    private Nodo<T> hIzq;
    private Nodo<T> hDer;

    public Nodo(){
    }
    
    public Nodo(T dato) {
        this.dato = dato;
        hIzq = null;
        hDer = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo gethIzq() {
        return hIzq;
    }

    public void sethIzq(Nodo hIzq) {
        this.hIzq = hIzq;
    }

    public Nodo gethDer() {
        return hDer;
    }

    public void sethDer(Nodo hDer) {
        this.hDer = hDer;
    }

    @Override
    public String toString() {
        return "Nodo[" + dato + "(Izq: " + hIzq + ", Der: " + hDer + ")]";
    }
}
