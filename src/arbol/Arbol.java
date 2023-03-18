package arbol;

public class Arbol<T extends Comparable> {

    /**
     * Atributos de la Clase.
     */
    private Nodo raiz;
    private int size;

    /**
     * Modificardor de acceso del tipo getter para obtener la raiz del arbol, 
     * este metodo se lo usará para poder dibuar el arbol en un JPanel.
     *
     * @return Nodo con la Raíz del ABB
     */
    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * Modificador de acceso para obtener la cantidad de nodos pertenecientes 
     * al ABB.
     *
     * @return cantidad de nodos del ABB
     */
    public int getSize() {
        return size;
    }

    /**
     * Constructor Inicializando la raiz en NUll.
     */
    public Arbol() {
        this.raiz = null;
        this.size = 0;
    }

    /**
     * Metodo para buscar un dato dentro del ABB, en caso de encontrar la
     * coincidencia con parametro dato retornará Ture.
     *
     * @param dato
     * @return Valor logico que indica si se encontró el dato
     */
    public Boolean buscarDato(T dato) {
        Nodo aux = this.raiz;
        while (true) {
            if (aux != null) {
                int comp = aux.getDato().compareTo(dato);
                if (comp == 0) {
                    return true;
                } else if (comp < 0) {
                    aux = aux.gethDer();
                } else {
                    aux = aux.gethIzq();
                }
            } else {
                return false;
            }
        }
    }

    /**
     * Metodo para eliminar un dato dentro del ABB, en caso de que el dato a 
     * eliminar tenga dos nodos hijos se aplicará recursividad directa.
     *
     * @param dato
     * @return Valor logico que indica si se eliminó el dato
     */
    public Boolean eliminarDato(T dato) {
        if (buscarDato(dato)) {
            Nodo aEliminar = buscarNodo(dato);
            Nodo padre;
            if (esHoja(aEliminar)) {
                aEliminar.setDato(null);
            } else if (tieneSoloDerecho(aEliminar) ^ tieneSoloIzquierdo(aEliminar)) {
                padre = buscarPadre(dato);
                if (padre.gethDer().getDato().compareTo(dato) == 0) {
                    if (tieneSoloDerecho(aEliminar)) {
                        padre.sethDer(aEliminar.gethDer());
                        size -= 1;
                        return true;
                    } else if (tieneSoloIzquierdo(aEliminar)) {
                        padre.sethDer(aEliminar.gethIzq());
                        size -= 1;
                        return true;
                    }
                } else if (padre.gethIzq().getDato().compareTo(dato) == 0) {
                    if (tieneSoloDerecho(aEliminar)) {
                        padre.sethIzq(aEliminar.gethDer());
                        size -= 1;
                        return true;
                    } else if (tieneSoloIzquierdo(aEliminar)) {
                        padre.sethIzq(aEliminar.gethIzq());
                        size -= 1;
                        return true;
                    }
                }
            } else if (tieneDosHijos(aEliminar)) {
                Nodo hDerDelete = aEliminar.gethDer();

                if (aEliminar == this.raiz) {
                    if (esHoja(hDerDelete)) {
                        aEliminar.setDato(hDerDelete.getDato());
                        aEliminar.sethDer(null);
                        size -= 1;
                        return true;
                    } else if (tieneSoloDerecho(hDerDelete)) {
                        aEliminar.setDato(hDerDelete.getDato());
                        aEliminar.sethDer(hDerDelete.gethDer());
                        size -= 1;
                        return true;
                    } else if (tieneSoloIzquierdo(hDerDelete)) {
                        aEliminar.setDato(hDerDelete.getDato());
                        aEliminar.sethDer(hDerDelete.gethIzq());
                        size -= 1;
                        return true;
                    } else if (tieneDosHijos(hDerDelete)) {
                        Comparable aux = hDerDelete.getDato();
                        eliminarDato((T) hDerDelete.getDato());
                        aEliminar.setDato(aux);
                    }
                }

                padre = buscarPadre(dato);
                if (padre != null) {

                    if (padre.gethDer() != null) {
                        if (padre.gethDer().getDato().compareTo(dato) == 0) {
                            if (esHoja(hDerDelete)) {
                                padre.gethDer().setDato(hDerDelete.getDato());
                                aEliminar.sethDer(null);
                                size -= 1;
                                return true;
                            } else if (tieneSoloDerecho(hDerDelete)) {
                                padre.gethDer().setDato(hDerDelete.getDato());
                                aEliminar.sethDer(hDerDelete.gethDer());
                                size -= 1;
                                return true;
                            } else if (tieneSoloIzquierdo(hDerDelete)) {
                                padre.gethDer().setDato(hDerDelete.getDato());
                                aEliminar.sethDer(hDerDelete.gethIzq());
                                size -= 1;
                                return true;
                            } else if (tieneDosHijos(hDerDelete)) {
                                Comparable aux = hDerDelete.getDato();
                                eliminarDato((T) hDerDelete.getDato());
                                size -= 1;
                                aEliminar.setDato(aux);
                            }
                        }
                    }
                    if (padre.gethIzq() != null) {
                        if (padre.gethIzq().getDato().compareTo(dato) == 0) {
                            if (esHoja(hDerDelete)) {
                                padre.gethIzq().setDato(hDerDelete.getDato());
                                aEliminar.sethDer(null);
                                size -= 1;
                                return true;
                            } else if (tieneSoloDerecho(hDerDelete)) {
                                padre.gethIzq().setDato(hDerDelete.getDato());
                                aEliminar.sethDer(hDerDelete.gethDer());
                                size -= 1;
                                return true;
                            } else if (tieneSoloIzquierdo(hDerDelete)) {
                                padre.gethIzq().setDato(hDerDelete.getDato());
                                aEliminar.sethDer(hDerDelete.gethIzq());
                                size -= 1;
                                return true;
                            } else if (tieneDosHijos(hDerDelete)) {
                                Comparable aux = hDerDelete.getDato();
                                eliminarDato((T) hDerDelete.getDato());
                                aEliminar.setDato(aux);
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("No se encontró dato: " + dato);
            return false;
        }
        return true;
    }

    /**
     * Metodo para buscar un nodo a partir de un dato, en caso de hayar la 
     * coincidencia retornará el Nodo condicho dato buscado.
     *
     * @param dato
     * @return Nodo buscado
     */
    private Nodo buscarNodo(T dato) {
        Nodo aux = this.raiz;
        while (true) {
            if (aux != null) {
                int comp = aux.getDato().compareTo(dato);
                if (comp == 0) {
                    return aux;
                } else if (comp < 0) {
                    aux = aux.gethDer();
                } else {
                    aux = aux.gethIzq();
                }
            } else {
                return null;
            }
        }
    }

    /**
     * @param dato
     * @return True si se agresgó el elemento, caso contrario False
     */
    public Boolean agregarDato(T dato) {
        Nodo aux = this.raiz;
        Nodo nDato = new Nodo(dato);
        if (raiz == null) {
            raiz = nDato;
        }
        while (true) {
            if (aux != null) {
                int comp = aux.getDato().compareTo(dato);
                if (comp == 0) {
                    size += 1;
                    return true;
                } else if (comp < 0) {
                    if (aux.gethDer() == null) {
                        aux.sethDer(nDato);
                        size += 1;
                        return true;
                    }
                    aux = aux.gethDer();
                } else {
                    if (aux.gethIzq() == null) {
                        aux.sethIzq(nDato);
                        size += 1;
                        return true;
                    }
                    aux = aux.gethIzq();
                }
            } else {
                return false;
            }
        }
    }

    /**
     * Metodos para saber el tipo de Nodo con el que nos encontramos.
     */
    private Boolean esHoja(Nodo dato) {
        return dato.gethIzq() == null && dato.gethDer() == null;
    }

    private Boolean tieneSoloDerecho(Nodo dato) {
        return dato.gethIzq() == null && dato.gethDer() != null;
    }

    private Boolean tieneSoloIzquierdo(Nodo dato) {
        return dato.gethIzq() != null && dato.gethDer() == null;
    }

    private Boolean tieneDosHijos(Nodo dato) {
        return dato.gethIzq() != null && dato.gethDer() != null;
    }

    /**
     * Metodo con la funcionalidad para encontrar el Nodo padre de un Dato
     *
     * @param dato
     * @return Nodo padre.
     */
    private Nodo buscarPadre(T dato) {
        Nodo aux = this.raiz;
        if (aux.getDato().compareTo(dato) == 0) {
            return null;
        }
        while (true) {
            if (aux != null) {

                int comp = aux.getDato().compareTo(dato);

                if (aux.gethDer() != null) {
                    if (aux.gethDer().getDato().compareTo(dato) == 0) {
                        return aux;
                    }
                }
                if (aux.gethIzq() != null) {
                    if (aux.gethIzq().getDato().compareTo(dato) == 0) {
                        return aux;
                    }
                }
                if (comp < 0) {
                    aux = aux.gethDer();
                } else {
                    aux = aux.gethIzq();
                }
            } else {
                return null;
            }
        }
    }
    

    /**
     * Metodo estatico que cuenta la cantidad de Nodos que hay en cada nivel 
     * del ABB.
     *
     * @param n
     * @return Cantidad de Nodos en el nivel del nodo "n"
     */
    public static int nodosCompletos(Nodo n) {
        if (n == null) {
            return 0;
        } else {
            if (n.gethIzq() != null && n.gethDer() != null) {
                return nodosCompletos(n.gethIzq()) + nodosCompletos(n.gethDer()) + 1;
            }
            return nodosCompletos(n.gethIzq()) + nodosCompletos(n.gethDer());
        }
    }

    @Override
    public String toString() {
        return raiz.toString();
    }
}
