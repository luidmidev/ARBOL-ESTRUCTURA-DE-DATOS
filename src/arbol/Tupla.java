package arbol;

/**
 *
 * @author playe
 */
public class Tupla<T extends Comparable, V> implements Comparable<Tupla> {

    public T llave;
    private V elemento;

    public Tupla(T llave, V elemento) {
        this.llave = llave;
        this.elemento = elemento;
    }

    @Override
    public String toString() {
        return llave + " - " + elemento.toString();
    }

    @Override
    public int compareTo(Tupla o) {
        return llave.compareTo(o.llave);
    }

}
