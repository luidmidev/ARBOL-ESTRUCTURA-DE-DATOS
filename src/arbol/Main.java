package arbol;

import javax.swing.JFrame;
import arbol.Draw.*;

public class Main {

    public static void main(String[] args) {
        ejercicio1();
        ejercicio2();
    }

    public static void ejercicio1() {

        Arbol<String> arbol = new Arbol<>();
        arbol.agregarDato("F");
        arbol.agregarDato("A");
        arbol.agregarDato("G");
        arbol.agregarDato("B");
        arbol.agregarDato("D");
        arbol.agregarDato("I");
        arbol.agregarDato("C");
        arbol.agregarDato("E");
        arbol.agregarDato("H");

        /**
         * DIBUJAR ARBOL EN JFRAME
         */
        Lienzo arbolLienzo = new Lienzo(); //VISTA
        arbolLienzo.setObjArbol(arbol);
        JFrame ventana = new JFrame();
        ventana.getContentPane().add(arbolLienzo);
        ventana.setDefaultCloseOperation(3);
        ventana.setSize(600, 600);
        ventana.setVisible(true);

        /**
         * EJERCICIO 1
         */
        System.out.println("RECORRIDO PRE ORDEN");
        preOrden(arbol.getRaiz());
        System.out.println("\nRECORRIDO IN ORDEN");
        inOrden(arbol.getRaiz());
        System.out.println("\nRECORRIDO POST ORDEN");
        postOrden(arbol.getRaiz());
        System.out.println("\n");
    }

    public static void ejercicio2() {

        Arbol<Tupla<Integer, String>> arbol = new Arbol<>();
        arbol.agregarDato(new Tupla(4, "Naranja"));
        arbol.agregarDato(new Tupla(8, "Manzana"));
        arbol.agregarDato(new Tupla(1, "Uva"));
        arbol.agregarDato(new Tupla(9, "Sandía"));
        arbol.agregarDato(new Tupla(7, "Pera"));

        /**
         * DIBUJAR ARBOL EN JFRAME
         */
        Lienzo arbolLienzo = new Lienzo(); //VISTA
        arbolLienzo.setObjArbol(arbol);
        JFrame ventana = new JFrame();
        ventana.getContentPane().add(arbolLienzo);
        ventana.setDefaultCloseOperation(3);
        ventana.setSize(600, 600);
        ventana.setVisible(true);

        /**
         * EJERCICIO 2
         */
        System.out.println("RECORRIDO PRE ORDEN");
        preOrden(arbol.getRaiz());
        System.out.println("\nRECORRIDO IN ORDEN");
        inOrden(arbol.getRaiz());
        System.out.println("\nRECORRIDO POST ORDEN");
        postOrden(arbol.getRaiz());
        System.out.println("\n");
    }

    public static void preOrden(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.getDato() + ", ");
            preOrden(raiz.gethIzq());
            preOrden(raiz.gethDer());
        }
    }

    public static void inOrden(Nodo raiz) {
        if (raiz != null) {
            inOrden(raiz.gethIzq());
            System.out.print(raiz.getDato() + ", ");
            inOrden(raiz.gethDer());
        }
    }

    public static void postOrden(Nodo raiz) {
        if (raiz != null) {
            inOrden(raiz.gethIzq());
            inOrden(raiz.gethDer());
            System.out.print(raiz.getDato() + ", ");
        }
    }
}
